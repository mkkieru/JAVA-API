package dao;

import models.Departments;
import models.News;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentsDaoTest {


    private static Sql2oDepartmentsDao departmentsDao;
    private static Connection conn;

    @BeforeClass //changed to @BeforeClass (run once before running any tests in this file)
    public static void setUp() throws Exception { //changed to static
        String connectionString = "jdbc:postgresql://localhost:5432/organization_portal_test"; //connect to Organization_Portal, not Organization_Portal_test!
        Sql2o sql2o = new Sql2o(connectionString, "damark", "password");
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open(); //open connection once before this test file is run
    }

    @After //run after every test
    public void tearDown() throws Exception {  //I have changed
        System.out.println("clearing database");
        departmentsDao.clearAll(); //clear all restaurants after every test
    }

    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }

    @Test
    public void addingDepartmentSetsId() throws Exception {
        Departments department = new Departments("ICT","Deals with Comps","3");
        int originalDepartmentID = department.getId();
        departmentsDao.add(department);
        Assert.assertFalse(originalDepartmentID == department.getId());
    }

    @Test
    public void addedDepartmentsAreReturnedFromGetAll() throws Exception {
        Departments department = new Departments("ICT","Deals with Comps","3");
        departmentsDao.add(department);
        assertEquals(1, departmentsDao.getAll().size());
    }

    @Test
    public void noDepartmentsAreReturnsEmptyList() throws Exception {
        assertEquals(0, departmentsDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectFoodtype() throws Exception {
        Departments department = new Departments("ICT","Deals with Comps","3");
        departmentsDao.add(department);
        departmentsDao.deleteById(department.getId());
        assertEquals(0, departmentsDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Departments department = new Departments("ICT","Deals with Comps","3");
        departmentsDao.add(department);
        Departments department2 = new Departments("ICT","Deals with Comps","3");
        departmentsDao.add(department2);
        departmentsDao.clearAll();
        assertEquals(0, departmentsDao.getAll().size());
    }
}