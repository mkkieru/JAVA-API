package models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {

    @Test
    public void newDepartmentsInstantiatesCorrectly() {
        Departments department = new Departments("ICT","Deals with Comps","3");
        Assert.assertTrue(department instanceof Departments);
    }

    @Test
    public void setId() {
        Departments department = new Departments("ICT","Deals with Comps","3");
        department.setId(2);
        Assert.assertTrue(2 == department.getId());
    }

    @Test
    public void setName() {
        Departments department = new Departments("ICT","Deals with Comps","3");
        department.setName("Comps");
        Assert.assertTrue("Comps" == department.getName());
    }

    @Test
    public void setDescription() {
        Departments department = new Departments("ICT","Deals with Comps","3");
        department.setDescription("Dealing with computers");
        Assert.assertTrue("Dealing with computers" == department.getDescription());
    }

    @Test
    public void setTotalEmployees() {
        Departments department = new Departments("ICT","Deals with Comps","3");
        department.setTotalEmployees("3");
        Assert.assertTrue("3" == department.getTotalEmployees());
    }

    @Test
    public void getId() {
        Departments department = new Departments("ICT","Deals with Comps","3");
        department.setId(2);
        Assert.assertTrue(2 == department.getId());

    }

    @Test
    public void getName() {
        Departments department = new Departments("ICT","Deals with Comps","3");
        department.setName("HR");
        Assert.assertTrue("HR" == department.getName());
    }

    @Test
    public void getTotalEmployees() {
        Departments department = new Departments("ICT","Deals with Comps","3");
        department.setTotalEmployees("5");
        Assert.assertTrue("5" == department.getTotalEmployees());
    }

    @Test
    public void getDescription() {
        Departments department = new Departments("ICT","Deals with Comps","3");
        department.setDescription("Employment");
        Assert.assertTrue("Employment" == department.getDescription());
    }
}