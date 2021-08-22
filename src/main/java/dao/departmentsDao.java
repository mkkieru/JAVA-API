package dao;

import models.Departments;

import java.util.List;

public interface departmentsDao {
    //create
    void add (Departments department);
    //read
    List<Departments> getAll();
    Departments findById(int id);

    //update
    //void update(int id, String name, String address, String zipcode, String phone, String website, String email);

    //delete
    void deleteById(int id);
    void clearAll();
}
