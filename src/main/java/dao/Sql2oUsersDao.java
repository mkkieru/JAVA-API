package dao;

import models.Departments;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUsersDao implements usersDao {
    private final Sql2o sql2o;
    public Sql2oUsersDao(Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(Users users) {
        String sql = "INSERT INTO users (name,department,departmentid,companyposition,roleplayed) VALUES (:name,:department,:departmentid,:companyposition,:roleplayed)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", users.getName())
                    .addParameter("department", users.getDepartment())
                    .addParameter("departmentid", users.getDepartmentid())
                    .addParameter("companyposition", users.getCompanyPosition())
                    .addParameter("roleplayed", users.getRole())
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public List<Users> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        }
    }
    @Override
    public List<Users> getAllUsersByDepartmentID(String departmentid) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE departmentid = :departmentid")
                    .addParameter("departmentid", departmentid)
                    .executeAndFetch(Users.class);
        }
    }


    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Users findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Users.class);
        }
    }
}
