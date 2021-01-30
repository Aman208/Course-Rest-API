package com.example.CourseAPI.ServiceImpl;
import com.example.CourseAPI.Manager.CourseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CourseAPI.Model.Course;
import com.example.CourseAPI.Service.CourseService;
import com.example.CourseAPI.repo.CourseRepo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseRepo courseRepo;


    @Override
    public List<Course> getAllCourses(){
        return  courseRepo.findAll();
    }

    @Override
    public Optional<Course> getCourse(int id) throws NullPointerException{
        try{
            return courseRepo.findById(id);
        }
        catch (NullPointerException ex){
            throw new NullPointerException();
        }
    }
    @Override
    public void addNewCourse(Course course){
        courseRepo.save(course);
    }


    @Override
    public void updateCourse(Course course , int id) throws Exception {

        if(courseRepo.findById(id)==null){
            throw new Exception("Not Found");
        }
        else{
            courseRepo.save(course);
        }

    }

    @Override
    public void deleteCourse(int id){
        courseRepo.deleteById(id);
    }


}
