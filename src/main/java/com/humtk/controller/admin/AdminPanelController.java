package com.humtk.controller.admin;

import com.humtk.domain.Instructor;
import com.humtk.domain.Student;
import com.humtk.service.CourseService;
import com.humtk.service.InstructorService;
import com.humtk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @RequestMapping(value = "/add/student" , method = RequestMethod.POST)
    public void addStudent(@RequestBody @Valid Student student) {
        studentService.save(student);
    }

    @RequestMapping(value = "/add/instructor", method = RequestMethod.POST)
    public void addInstructor (@RequestBody @Valid Instructor instructor) {
        instructorService.save(instructor);
    }
}
