package com.example.CourseAPI.Manager;

import com.example.CourseAPI.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;


public class CourseManagerImpl implements CourseManager {

    private RedisTemplate<String, Course> redisTemplate;
    private HashOperations hashOperations;

    public CourseManagerImpl(RedisTemplate<String, Course> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = this.redisTemplate.opsForHash();
    }

    @Override
    public void save(Course newCourse) {
        hashOperations.put("COURSE" , newCourse.getId() , newCourse);
    }

    @Override
    public Map<String, Course> findAll() {
        return hashOperations.entries("COURSE");
    }

    @Override
    public Course findById(int id) {
        return (Course)hashOperations.get("COURSE" , id) ;
    }

    @Override
    public void update(Course course , int id ) {
        save(new Course(id , course.getName() , course.getDescription()));

    }

    @Override
    public void delete(int id) {
       hashOperations.delete("COURSE" , id);
    }
}
