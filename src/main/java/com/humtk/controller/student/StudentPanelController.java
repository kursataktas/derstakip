package com.humtk.controller.student;

import com.humtk.domain.Course;
import com.humtk.domain.Instructor;
import com.humtk.domain.Student;
import com.humtk.service.CourseService;
import com.humtk.service.StudentCourseService;
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
@RequestMapping("/student")
public class StudentPanelController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private StudentCourseService studentCourseService;
    
    
    @RequestMapping(value = "", method= RequestMethod.GET)
    public String indexGet(HttpSession session) {
    	if(session.getAttribute("student")==null)
            return "redirect:/student/login";
        return "redirect:/student/ana_sayfa";
    }

    
    @RequestMapping(value = "/ana_sayfa", method= RequestMethod.GET)
    public String index(HttpSession session) {
    	if(session.getAttribute("student")==null)
            return "redirect:/student/login";
        return "ana_sayfa";
    }

    @RequestMapping(value = "/devamsizlik", method=RequestMethod.GET)
    public String devamsizlik(Model model, HttpSession session) {
        if(session.getAttribute("student")==null)
            return "redirect:/student/login";
        model.addAttribute("activeDevam",true);
        return "devamsizlik";
    }

    @RequestMapping(value = "/alinan_dersler", method=RequestMethod.GET)
    public String alinan_dersler(Model model, HttpSession session) {
        if(session.getAttribute("student")==null)
            return "redirect:/student/login";

        Student student = (Student) session.getAttribute("student");
        List<Course> sc = studentCourseService.getByStudent(student);

        model.addAttribute("studentCourses",sc);
        model.addAttribute("activeAlinan",true);
        return "alinan_dersler";
    }

    @RequestMapping(value = "/logout", method=RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("student");
        return "redirect:/student/login";
    }
}
