package com.example.CourseAPI.ServiceImpl;
import com.example.CourseAPI.Manager.CourseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CourseAPI.Model.Course;
import com.example.CourseAPI.Service.CourseService;
import com.example.CourseAPI.Repo.CourseRepo;


import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseManager courseManager;


    @Override
    public List<Course> getAllCourses(){

        List<Course> courseList = courseManager.fetchAllCourse();git
        if(courseList.size()>=3){
            System.out.println("Data Coming From Redis");
            return courseList;
        }
        else{
            courseList = courseRepo.findAll();
            System.out.println("Data Coming From DB");
            return  courseList;
        }
    }

    @Override
    public Course getCourse(int id) throws NullPointerException{
        try{
           Course course = courseManager.fetchCourseById(id);
            if(course != null){
                System.out.println("Data Coming From Redis");
                return course;
            }
            else{
                System.out.println("Data Coming From Db");
                 return  (Course) courseRepo.findById(id);


            }
        }
        catch (NullPointerException ex){
            throw new NullPointerException();
        }
    }
    @Override
    public void addNewCourse(Course course){
        courseRepo.save(course);
        courseManager.saveCourse(course);
    }


    @Override
    public void updateCourse(Course course , int id) throws Exception {

        if(courseRepo.findById(id)==null){
            throw new Exception("Not Found");
        }
        else{
            courseRepo.save(course);
            courseManager.updateCourse(course , id);
        }

    }

    @Override
    public void deleteCourse(int id){
        courseRepo.deleteById(id);
        courseManager.deleteCourse(id);
    }


}
