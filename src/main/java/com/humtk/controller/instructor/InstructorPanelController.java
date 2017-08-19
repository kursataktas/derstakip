package com.humtk.controller.instructor;

import com.humtk.domain.Course;
import com.humtk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by burcu on 19.08.2017.
 */
@RestController
@RequestMapping("api/instructor")
public class InstructorPanelController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private StudentAttendanceService attendanceService;

    @RequestMapping(value = "/courses/{instructorId}", method = RequestMethod.GET)
    public List<Course> getCoursesByInstructorId(@PathVariable("instructorId") long id) {
        System.out.print(instructorService.findById(id).getCourseList());
        return instructorService.findById(id).getCourseList();
    }

    @RequestMapping(value = "/students/{courseId}", method = RequestMethod.GET)
    public List<Course> getStudentsByCourseId(@PathVariable("instructorId") long id) {
        return (List)courseService.findById(id).getStudentList();
    }

}