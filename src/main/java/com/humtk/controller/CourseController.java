package com.humtk.controller;

import com.humtk.domain.Course;
import com.humtk.service.CourseService;
import com.humtk.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by burcu on 12.08.2017.
 */

@Controller("course")
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses/{instructorId}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> getCoursesByInstructorId(@PathVariable("instructorId") long id) {
        List<Course> courses = courseService.getByInstructorCourse(id);
        return new ResponseEntity<>(JsonResponse.success("message", "courses", courses), HttpStatus.OK);
    }

    @RequestMapping(value = "/data/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> getCourseById(@PathVariable("courseId") long id) {
        Course course = courseService.findById(id);
        return new ResponseEntity<>(JsonResponse.success("message", "course", course), HttpStatus.OK);
    }

}
