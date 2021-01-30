package com.example.CourseAPI.Repo;

import com.example.CourseAPI.Model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends CrudRepository<Course , Integer>{


    List<Course> findAll();
    Course findById(int id);

}
