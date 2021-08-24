package dao;

import models.Departments;
import models.Users;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;


public class Sql2oUsersDaoTest {
    private static Sql2oUsersDao usersDao;
    private static Sql2oDepartmentsDao departmentsDao;
    private static Connection conn;

    @BeforeClass //changed to @BeforeClass (run once before running any tests in this file)
    public static void setUp() throws Exception { //changed to static
        String connectionString = "jdbc:postgresql://localhost:5432/organization_portal_test"; //connect to Organization_Portal, not Organization_Portal_test!
        Sql2o sql2o = new Sql2o(connectionString, "damark", "password");
        usersDao = new Sql2oUsersDao(sql2o);
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open(); //open connection once before this test file is run
    }

    @After //run after every test
    public void tearDown() throws Exception {  //I have changed
        System.out.println("clearing database");
        usersDao.clearAll(); //clear all restaurants after every test
        departmentsDao.clearAll();
    }

    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }

    @Test
    public void addingUserSetsId() throws Exception {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        int originalUserID = user.getId();
        usersDao.add(user);
        Assert.assertFalse(originalUserID == user.getId());
    }

    @Test
    public void addedUsersAreReturnedFromGetAll() throws Exception {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        usersDao.add(user);
        assertEquals(1, usersDao.getAll().size());
    }

    @Test
    public void noUsersAreReturnsEmptyList() throws Exception {
        assertEquals(0, usersDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectFoodtype() throws Exception {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        usersDao.add(user);
        usersDao.deleteById(user.getId());
        assertEquals(0, usersDao.getAll().size());
    }

    @Test
    public void GetUsersByDepartmentID() throws Exception {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        Departments department = new Departments("ICT","Deals with Comps","3");
        departmentsDao.add(department);
        usersDao.add(user);
        List<Users> allUsers = usersDao.getAllUsersByDepartmentID("1");
        assertEquals(1, allUsers.size());
    }

    @Test
    public void clearAll() throws Exception {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        Users user2 = new Users("Mark","ICT","1","Dev","Front-End");
        usersDao.add(user);
        usersDao.add(user2);
        usersDao.clearAll();
        assertEquals(0, usersDao.getAll().size());
    }

}