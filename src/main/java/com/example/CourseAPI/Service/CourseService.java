package com.example.CourseAPI.Service;

import com.example.CourseAPI.Model.Course;


import java.util.List;

public interface CourseService   {

    public List<Course> getAllCourses();
    public Course getCourse(int id);
    public void addNewCourse(Course course);
    public void updateCourse(Course course , int id) throws Exception;
    public void deleteCourse(int id);

}

