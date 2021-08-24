package models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void newUserInstantiatesCorrrectly() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        Assert.assertTrue(user instanceof Users);
    }

    @Test
    public void setName() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        user.setName("Kieru");
        Assert.assertEquals("Kieru", user.getName());
    }

    @Test
    public void setId() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        user.setId(2);
        Assert.assertTrue(2 ==  user.getId());
    }

    @Test
    public void setCompanyPosition() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        user.setCompanyPosition("Developer");
        Assert.assertTrue("Developer" ==  user.getCompanyPosition());
    }

    @Test
    public void setRole() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        user.setRole("Front-End");
        Assert.assertTrue("Front-End" ==  user.getRole());
    }

    @Test
    public void setDepartment() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        user.setDepartment("ICT");
        Assert.assertTrue("ICT" ==  user.getDepartment());
    }

    @Test
    public void setDepartmentid() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        user.setDepartmentid("2");
        Assert.assertTrue("2" ==  user.getDepartmentid());
    }

    @Test
    public void getDepartmentid() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        Assert.assertTrue("1" ==  user.getDepartmentid());
    }

    @Test
    public void getDepartment() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        Assert.assertTrue("ICT" ==  user.getDepartment());
    }

    @Test
    public void getName() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        Assert.assertTrue("Mark" ==  user.getName());
    }

    @Test
    public void getId() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        Assert.assertTrue(0 ==  user.getId());
    }

    @Test
    public void getCompanyPosition() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        Assert.assertTrue("Dev" ==  user.getCompanyPosition());
    }

    @Test
    public void getRole() {
        Users user = new Users("Mark","ICT","1","Dev","Front-End");
        Assert.assertTrue("Front-End" ==  user.getRole());
    }
}