package com.humtk.controller.student;

import com.humtk.domain.Student;
import com.humtk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by kursat on 13.8.2017.
 */

@Controller
public class StudentLoginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student")
    public String index(HttpSession session) {
        if(session.getAttribute("student")==null)
            return "redirect:/login";
        return "redirect:/student/ana_sayfa";
    }

    @RequestMapping(value = "/student/login", method= RequestMethod.GET)
    public String login(ModelMap modelMap, HttpSession session) {
        if(session.getAttribute("student")!=null)
            return "redirect:/student/ana_sayfa";
        return "login";
    }

    @RequestMapping(value = "/student/login", method=RequestMethod.POST)
    public String login(@RequestParam String mail, @RequestParam String password, ModelMap modelMap, HttpSession session) {
        Student newStudent = studentService.findByMail(mail);
        if(newStudent!=null) {
            if(newStudent.getPassword().equals(password)) {
                session.setAttribute("student", newStudent);
                return "redirect:/student/ana_sayfa";
            }
        }
        modelMap.put("error", "Account is invalid.");
        return "login";
    }


}
