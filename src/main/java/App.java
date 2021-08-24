import static spark.Spark.*;

import com.google.gson.Gson;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUsersDao;
import exceptions.ApiException;
import models.Departments;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        Sql2oDepartmentsDao departmentsDao;
        Sql2oNewsDao newsDao;
        Sql2oUsersDao usersDao;
        Connection conn;
        Gson gson = new Gson();



        //String connectionString = "jdbc:postgresql://localhost:5432/organization_portal"; //connect to Organization_Portal, not Organization_Portal_test!
        //Sql2o sql2o = new Sql2o(connectionString, "damark", "password");


        //postgres://qmgvctoxaejxgt:d4a72222987588c95f8f6ecc59fec20e2e1b18ba9231bdadabcebd272404ccf1@ec2-35-153-114-74.compute-1.amazonaws.com:5432/de189lcl3pv76p


        String connectionString = "jdbc:postgresql://ec2-35-153-114-74.compute-1.amazonaws.com:5432/de189lcl3pv76p"; //connect to Organization_Portal, not Organization_Portal_test!
        Sql2o sql2o = new Sql2o(connectionString, "qmgvctoxaejxgt", "d4a72222987588c95f8f6ecc59fec20e2e1b18ba9231bdadabcebd272404ccf1");


        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);

        //CREATE NEW USER
        post("/users/new", "application/json", (req, res) -> {
            Users user = gson.fromJson(req.body(), Users.class);
            usersDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });

        //READ ALL USERS
        get("/users", "application/json", (req, res) -> {
            System.out.println(usersDao.getAll());
            if(usersDao.getAll().size() > 0){
                return gson.toJson(usersDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no users are currently listed in the database.\"}";
            }
        });

        //READ SPECIFIC USER
        get("/users/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int userID = Integer.parseInt(req.params("id"));
            Users UserToFind = usersDao.findById(userID);
            if (UserToFind == null){
                throw new ApiException(404, String.format("No Department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(UserToFind);
        });

        //READ USERS IN A SPECIFIC DEPARTMENT
        get("/departments/:id/users", "application/json", (req, res) -> {
            String departmentid = req.params("id");
            int departmentidINT = Integer.parseInt(departmentid);
            Departments departmentToFind = departmentsDao.findById(departmentidINT);

            List<Users> allUsers;

            if (departmentToFind == null){
                throw new ApiException(404, String.format("No Departments with the id: \"%s\" exists", req.params("id")));
            }
            allUsers = usersDao.getAllUsersByDepartmentID(departmentid);
            return gson.toJson(allUsers);
        });



        //CREATE NEW NEWS
        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });

        //READ ALL NEWS
        get("/news", "application/json", (req, res) -> {
            System.out.println(newsDao.getAll());
            if(newsDao.getAll().size() > 0){
                return gson.toJson(newsDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no News are currently listed in the database.\"}";
            }
        });

        //READ SPECIFIC NEWS
        get("/news/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int newsID = Integer.parseInt(req.params("id"));
            News newsToFind = newsDao.findById(newsID);
            if (newsToFind == null){
                throw new ApiException(404, String.format("No Department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(newsToFind);
        });
        get("/departments/:id/news", "application/json", (req, res) -> {
            String departmentid = req.params("id");
            int departmentidINT = Integer.parseInt(departmentid);
            Departments departmentToFind = departmentsDao.findById(departmentidINT);

            List<News> allNews;

            if (departmentToFind == null){
                throw new ApiException(404, String.format("No Departments with the id: \"%s\" exists", req.params("id")));
            }
            allNews = newsDao.getAllNewsByDepartmentID(departmentid);
            return gson.toJson(allNews);
        });

        //CREATE DEPARTMENT
        post("/departments/new", "application/json", (req, res) -> {
            Departments department = gson.fromJson(req.body(), Departments.class);
            departmentsDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });

        //READ ALL DEPARTMENTS
        get("/departments", "application/json", (req, res) -> {
            System.out.println(departmentsDao.getAll());
            if(departmentsDao.getAll().size() > 0){
                return gson.toJson(departmentsDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no departments are currently listed in the database.\"}";
            }
        });
    //token :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
        //READ SPECIFIC DEPARTMENT
        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int departmentId = Integer.parseInt(req.params("id"));
            Departments departmentToFind = departmentsDao.findById(departmentId);
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No Department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentToFind);
        });

        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });


        after((req, res) ->{
            res.type("application/json");
        });

    }
}