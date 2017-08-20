package com.humtk.controller.admin;

import com.humtk.domain.Instructor;
import com.humtk.domain.Student;
import com.humtk.service.CourseService;
import com.humtk.service.InstructorService;
import com.humtk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by burcu on 20.08.2017.
 */
@RestController
@RequestMapping("api/admin")
public class AdminPanelController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private InstructorService instructorService;

    @RequestMapping(value = "/add/student")
    public void addStudent(@RequestParam("student")Student student) {
        studentService.save(student);
    }

    @RequestMapping(value = "/add/instructor")
    public void addInstructor (@RequestParam("instructor")Instructor instructor) {
        instructorService.save(instructor);
    }
}
