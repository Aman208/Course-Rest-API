package com.example.CourseAPI.Manager;

import com.example.CourseAPI.Model.Course;

import java.util.Map;

public interface CourseManager {

    void save(Course newCourse);
    Map<String, Course> findAll();
    Course findById(int id);
    void update(Course course , int id );
    void delete( int id );
}
