package com.humtk.controller.student;

import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.domain.StudentAttendance;
import com.humtk.service.CourseService;
import com.humtk.service.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


import java.util.List;

/**
 * Created by kursat on 13.8.2017.
 */
@Controller
@RequestMapping("/student")
public class StudentPanelController {


    @Autowired
    private CourseService courseService;
    
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
        
        List<Course> sc = courseService.getByStudent(st);
        List<StudentAttendance> attendance = attendanceService.getByStudent(st);
       
        model.addAttribute("activeDevam",true);
        model.addAttribute("attendance",attendance);
        model.addAttribute("course", new Course());
        model.addAttribute("studentCourses",sc);
			
        return "devamsizlik";
    }
    
    @RequestMapping(value = "/devamsizlik/{id}", method=RequestMethod.GET)
    public String devamsizlik(@PathVariable long id, Model model, HttpSession session) {
    	Student student = (Student) session.getAttribute("student");
        List<Course> sc = courseService.getByStudent(student);
        Course course = courseService.findById(id);
        List<StudentAttendance> attendance = attendanceService.getByStudentAndCourse(student, course);
        
        int countYok = 0;
        
        for (StudentAttendance sa : attendance)
			if(!sa.getAttendance())
				countYok++;
        
        model.addAttribute("id",id);
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
        
        List<Course> sc = courseService.getByStudent(student);

        model.addAttribute("studentCourses",sc);
        
        model.addAttribute("activeAlinan",true);
        
        return "alinan_dersler";
    }
    
    @RequestMapping(value="/alinan_dersler_excel", method=RequestMethod.GET)
    public ModelAndView getExcelAlinanDersler(HttpSession session){
    	Student student = (Student) session.getAttribute("student");       
	    List<Course> courses = courseService.getByStudent(student);
        return new ModelAndView(new ExcelAlinanDersler(), "courses", courses);
    }
    
    @RequestMapping(value="/devamsizlik/{id}/devamsizlik_excel", method=RequestMethod.GET)
    public ModelAndView getExcelDevamsizlik(@PathVariable long id, HttpSession session){
    	Student student = (Student) session.getAttribute("student");
        Course course = courseService.findById(id);
        List<StudentAttendance> attendance = attendanceService.getByStudentAndCourse(student, course);
        
        return new ModelAndView(new ExcelDevamsizlik(), "attendances", attendance);
    }

    @RequestMapping(value = "/logout", method=RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("student");
        return "redirect:/student/login";
    }
}


