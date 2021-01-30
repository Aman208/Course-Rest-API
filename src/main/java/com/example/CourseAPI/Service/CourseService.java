package com.example.CourseAPI.Service;
import com.sun.xml.internal.xsom.impl.scd.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseAPI.Model.Course;
import com.example.CourseAPI.repo.CourseRepo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface CourseService   {

    public List<Course> getAllCourses();
    public Optional<Course> getCourse(int id);
    public void addNewCourse(Course course);
    public void updateCourse(Course course , int id) throws Exception;
    public void deleteCourse(int id);

}

