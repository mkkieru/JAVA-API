package models;

import org.junit.Assert;
import org.junit.Test;

public class NewsTest {


    @Test
    public void newNewsInstantiatesCorrectly() {
        News news = new News("Go for leave","1");
        Assert.assertTrue(news instanceof News);
    }

    @Test
    public void setId() {
        News news = new News("Go for leave","1");
        news.setId(2);
        Assert.assertTrue(2 == news.getId());
    }

    @Test
    public void setContent() {
        News news = new News("Go for leave","1");
        news.setDescription("content 2");
        Assert.assertTrue("content 2" == news.getDescription());
    }

    @Test
    public void getId() {
        News news = new News("Go for leave","1");
        news.setId(2);
        Assert.assertTrue(2 == news.getId());
    }

    @Test
    public void getContent() {
        News news = new News("Go for leave","1");
        news.setDescription("content 2");
        Assert.assertTrue("content 2" == news.getDescription());
    }
    @Test
    public void setDepartmentIdAndGetDepartmentId() {
        News news = new News("Go for leave","1");
        news.setDepartmentid("2");
        Assert.assertTrue("2" == news.getDepartmentid());
    }
}