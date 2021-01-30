package com.example.CourseAPI.Controller;

import com.example.CourseAPI.Manager.CourseManager;
import com.example.CourseAPI.Manager.CourseManagerImpl;
import com.example.CourseAPI.Model.Course;

import com.example.CourseAPI.Service.CourseService;
import com.example.CourseAPI.ServiceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
public class CourseController {


    @Autowired
    private CourseService courseService;


    @RequestMapping("/hello")
    public String forHi() {
        return "HI";
    }

    @RequestMapping("/getAllCourse")
    public List<Course> getAllCourses() {
        return (List<Course>) this.courseService.getAllCourses();
    }

    @GetMapping("/getCourse/{id}")
    public ResponseEntity getCourse(@PathVariable("id") String id){
        try{
            Optional<Course> course= this.courseService.getCourse(Integer.parseInt(id));
            if(course==null){
                throw new NoSuchElementException();
            }
            return new ResponseEntity( course , HttpStatus.ACCEPTED);
        }
        catch(NullPointerException err){
            return new ResponseEntity("No item with this id Found" , HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/postCourse")
    public ResponseEntity postCourse(@RequestBody Course course){

        if(course.getName().equals("") && course.getDescription().equals("")){
            return new ResponseEntity("Field Can't Be Empty", HttpStatus.BAD_REQUEST);
        }
        try{
            this.courseService.addNewCourse(course);
            return new ResponseEntity( "Successful Post Request" , HttpStatus.ACCEPTED);
        }
        catch (Exception err){
            return new ResponseEntity("Some Error Occurs" +err.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value= "/updateCourse/{id}")
    public ResponseEntity updateCourse(@RequestBody Course course , @PathVariable String id){
        try{
            this.courseService.updateCourse(course , Integer.parseInt(id));
            return new ResponseEntity("Update Done"  , HttpStatus.OK);
        }
        catch(Exception err){
            return new ResponseEntity("No item with this id Found"  , HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value= "/deleteCourse/{id}")
    public ResponseEntity deleteCourse(@PathVariable String id){

        try{
            this.courseService.deleteCourse(Integer.parseInt(id));
            return new ResponseEntity("Delete Done"  , HttpStatus.OK);

        }
        catch(Exception err){
            return new ResponseEntity("No item with this id Found" , HttpStatus.NOT_FOUND);
        }
    }
}
