package dao;

import models.Departments;
import models.Users;

import java.util.List;

public interface usersDao {
    //create
    void add (Users user);
    //read
    List<Users> getAll();
    Users findById(int id);
    List<Users> getAllUsersByDepartmentID(String departmentid);

    //update
    //void update(int id, String name, String address, String zipcode, String phone, String website, String email);

    //delete
    void deleteById(int id);
    void clearAll();
}
