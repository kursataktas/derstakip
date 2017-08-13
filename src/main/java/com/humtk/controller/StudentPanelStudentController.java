package com.humtk.controller;

import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.service.CourseService;
import com.humtk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by kursat on 13.8.2017.
 */
@Controller
public class StudentPanelStudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/student/ana_sayfa", method= RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "ana_sayfa";
    }

    @RequestMapping(value = "/student/devamsizlik", method=RequestMethod.GET)
    public String devamsizlik(Model model, HttpSession session) {
        if(session.getAttribute("student")==null)
            return "redirect:/student/login";
        model.addAttribute("activeDevam",true);
        return "devamsizlik";
    }

    @RequestMapping(value = "/student/alinan_dersler", method=RequestMethod.GET)
    public String alinan_dersler(Model model, HttpSession session) {
        if(session.getAttribute("student")==null)
            return "redirect:/student/login";

        Student student = (Student) session.getAttribute("student");
        List<Course> sc = courseService.getByStudentCourse(student.getId());

        model.addAttribute("studentCourses",sc);
        model.addAttribute("activeAlinan",true);
        return "alinan_dersler";
    }

    @RequestMapping(value = "/student/logout", method=RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("student");
        return "redirect:/student/login";
    }
}
