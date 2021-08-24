package dao;

import models.Departments;
import models.News;
import models.Users;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {

    private static Sql2oNewsDao newsDao;
    private static Sql2oDepartmentsDao departmentsDao;
    private static Connection conn;

    @BeforeClass //changed to @BeforeClass (run once before running any tests in this file)
    public static void setUp() throws Exception { //changed to static
        String connectionString = "jdbc:postgresql://localhost:5432/organization_portal_test"; //connect to Organization_Portal, not Organization_Portal_test!
        Sql2o sql2o = new Sql2o(connectionString, "damark", "password");
        newsDao = new Sql2oNewsDao(sql2o);
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open(); //open connection once before this test file is run
    }

    @After //run after every test
    public void tearDown() throws Exception {  //I have changed
        System.out.println("clearing database");
        newsDao.clearAll(); //clear all restaurants after every test
    }

    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }

    @Test
    public void addingNewsSetsId() throws Exception {
        News news = new News("Go for leave","1");
        int originalNewsID = news.getId();
        newsDao.add(news);
        Assert.assertFalse(originalNewsID == news.getId());
    }

    @Test
    public void addedNewsAreReturnedFromGetAll() throws Exception {
        News news = new News("Go for leave","1");
        newsDao.add(news);
        assertEquals(1, newsDao.getAll().size());
    }

    @Test
    public void noUsersAreReturnsEmptyList() throws Exception {
        assertEquals(0, newsDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectFoodtype() throws Exception {
        News news = new News("Go for leave","1");
        newsDao.add(news);
        newsDao.deleteById(news.getId());
        assertEquals(0, newsDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        News news = new News("Go for leave","1");
        newsDao.add(news);
        News news2 = new News("Go for leave","1");
        newsDao.clearAll();
        assertEquals(0, newsDao.getAll().size());
    }

    @Test
    public void GetNewsByDepartmentID() throws Exception {
        News news = new News("Go for leave","1");
        Departments department = new Departments("ICT","Deals with Comps","3");
        departmentsDao.add(department);
        newsDao.add(news);
        List<News> allNews = newsDao.getAllNewsByDepartmentID("1");
        assertEquals(1, allNews.size());
    }


}