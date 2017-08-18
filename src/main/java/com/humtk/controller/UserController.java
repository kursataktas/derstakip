package com.humtk.controller;

import com.humtk.domain.Student;
import com.humtk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by burcu on 12.08.2017.
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/add")
    public void addStudent(@RequestParam("student")Student student) {
        studentService.save(student);
    }

}
