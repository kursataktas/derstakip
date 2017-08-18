package com.humtk.controller;

import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.service.CourseService;
import com.humtk.service.InstructorService;
import com.humtk.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by burcu on 12.08.2017.
 */

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private InstructorService instructorService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addCourse(@RequestParam("course") Course course, @RequestParam("studentList") List<Student> students) {
        System.out.println(course);
        System.out.println(students);
    }

    @RequestMapping(value = "/courses/{instructorId}", method = RequestMethod.GET)
    public List<Course> getCoursesByInstructorId(@PathVariable("instructorId") long id) {
        return instructorService.findById(1).getCourseList();
    }

    @RequestMapping(value = "/data/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> getCourseById(@PathVariable("courseId") long id) {
        Course course = courseService.findById(id);
        return new ResponseEntity<>(JsonResponse.success("message", "course", course), HttpStatus.OK);
    }

}
