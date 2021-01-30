package com.example.CourseAPI.Manager;

import com.example.CourseAPI.Model.Course;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CourseManager {

    void saveCourse(Course newCourse);
    List< Course> fetchAllCourse();
    Course fetchCourseById(int id);
    void updateCourse(Course course , int id );
    void deleteCourse( int id );
}
