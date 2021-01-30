package com.example.CourseAPI.Manager;

import com.example.CourseAPI.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CourseManagerImpl implements CourseManager {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "COURSE";

    @Override
    public void saveCourse(Course newCourse) {
        this.redisTemplate.opsForHash().put(KEY, newCourse.getId() , newCourse);
    }

    @Override
    public List<Course> fetchAllCourse() {
        return this.redisTemplate.opsForHash().values(KEY);
    }

    @Override
    public Course fetchCourseById(int id) {
        return (Course) this.redisTemplate.opsForHash().get(KEY , id);
    }

    @Override
    public void updateCourse(Course course , int id ) {
        saveCourse(new Course(id , course.getName() , course.getDescription()));

    }

    @Override
    public void deleteCourse(int id) {
        this.redisTemplate.opsForHash().delete(KEY , id);
    }
}
