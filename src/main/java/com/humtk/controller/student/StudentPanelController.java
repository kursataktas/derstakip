package com.humtk.controller.student;

import com.humtk.domain.Course;
import com.humtk.domain.Instructor;
import com.humtk.domain.Student;
import com.humtk.domain.StudentCourseDailyAttendance;
import com.humtk.service.CourseService;
import com.humtk.service.StudentAttendanceService;
import com.humtk.service.StudentCourseService;
import com.humtk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
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
    
    @Autowired
    private StudentAttendanceService attendanceService;
    

    @RequestMapping(value = "", method= RequestMethod.GET)
    public String indexGet(HttpSession session) {
    	if(session.getAttribute("student")==null)
            return "redirect:/student/login";
        return "redirect:/student/ana_sayfa";
    }

    
    @RequestMapping(value = "/ana_sayfa", method= RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	if(session.getAttribute("student")==null)
            return "redirect:/student/login";
    	model.addAttribute("activeAnaSayfa",true);
        return "ana_sayfa";
    }

    @RequestMapping(value = "/devamsizlik", method=RequestMethod.GET)
    public String devamsizlik(Model model, HttpSession session) {
        if(session.getAttribute("student")==null)
            return "redirect:/student/login";
        
        Student st = (Student) session.getAttribute("student");
        List<Course> sc = studentCourseService.getByStudent(st);
        List<StudentCourseDailyAttendance> attendance = attendanceService.getByStudent(st);
       
        model.addAttribute("activeDevam",true);
        model.addAttribute("attendance",attendance);
        model.addAttribute("course", new Course());
        model.addAttribute("studentCourses",sc);
			
        return "devamsizlik";
    }
    
    @RequestMapping(value = "/devamsizlik/{id}", method=RequestMethod.GET)
    public String devamsizlik(@PathVariable long id, Model model, HttpSession session) {
    	Student student = (Student) session.getAttribute("student");
        List<Course> sc = studentCourseService.getByStudent(student);
        Course course = courseService.findById(id);
        List<StudentCourseDailyAttendance> attendance = attendanceService.getByStudentAndCourse(student, course);
        
        int countYok = 0;
        
        for (StudentCourseDailyAttendance sa : attendance)
			if(!sa.isAttendance())
				countYok++;
        
        model.addAttribute("activeDevam",true);
        model.addAttribute("attendance",attendance);
        model.addAttribute("course", course);
        model.addAttribute("studentCourses",sc);
        model.addAttribute("countYok",countYok);
        
			
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


