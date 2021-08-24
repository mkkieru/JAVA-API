package models;

public class News {
    private int id;
    private String description;
    private String departmentid;

    public News(String name ,String departmentid){

        this.departmentid = departmentid;
        this.description = name;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String name) {
        this.description = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartmentid() {
        return departmentid;
    }
}