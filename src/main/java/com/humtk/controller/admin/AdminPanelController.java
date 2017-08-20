package com.humtk.controller.admin;

import com.humtk.domain.Course;
import com.humtk.domain.Instructor;
import com.humtk.domain.Student;
import com.humtk.service.CourseService;
import com.humtk.service.InstructorService;
import com.humtk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by burcu on 20.08.2017.
 */
@RestController
@RequestMapping("api/admin")
public class AdminPanelController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/add/student" , method = RequestMethod.POST)
    public void addStudent(@RequestBody @Valid Student student) {
        studentService.save(student);
    }

    @RequestMapping(value = "add/course", method = RequestMethod.POST)
    public void addCourse (@RequestBody Course course) {
        courseService.save(course);
    }

    @RequestMapping(value = "/add/instructor", method = RequestMethod.POST)
    public void addInstructor (@RequestBody @Valid Instructor instructor) {
        instructorService.save(instructor);
    }

    @RequestMapping(value = "list/instructor", method = RequestMethod.GET )
    public List<Instructor> listInstructors () {
        return instructorService.findAll();
    }


}
