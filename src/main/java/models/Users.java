package models;

public class Users {

    private String name;
    private String department;
    private String departmentid;
    private String companyposition;
    private String roleplayed;
    private int id;

    public Users(String name, String department, String departmentid, String companyposition, String roleplayed){
        this.name = name;
        this.department = department;
        this.departmentid = departmentid;
        this.companyposition = companyposition;
        this.roleplayed = roleplayed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyPosition(String companyposition) {
        this.companyposition = companyposition;
    }

    public void setRole(String roleplayed) {
        this.roleplayed = roleplayed;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getCompanyPosition() {
        return companyposition;
    }

    public String getRole() {
        return roleplayed;
    }

}
