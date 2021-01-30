package com.example.CourseAPI.repo;

import com.example.CourseAPI.Model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Join;
import java.util.List;

@Repository
public interface CourseRepo extends CrudRepository<Course , Integer>{


    List<Course> findAll();

}
