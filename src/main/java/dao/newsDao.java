package dao;

import models.Departments;
import models.News;

import java.util.List;

public interface newsDao {
    //create
    void add (News news);
    //read
    List<News> getAll();
    News findById(int id);
    List<News> getAllNewsByDepartmentID(String departmentid);

    //update
    //void update(int id, String name, String address, String zipcode, String phone, String website, String email);

    //delete
    void deleteById(int id);
    void clearAll();
}
