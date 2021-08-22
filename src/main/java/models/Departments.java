package models;

public class Departments {
    private String name;
    private String description;
    private String totalemployees;
    private int id;

    public Departments(String name, String description, String totalemployees){
        this.name = name;
        this.description = description;
        this.totalemployees = totalemployees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTotalEmployees(String totalEmployees) {
        this.totalemployees = totalEmployees;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTotalEmployees() {
        return totalemployees;
    }

    public String getDescription() {
        return description;
    }
}
