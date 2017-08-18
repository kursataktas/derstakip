package com.humtk;

import com.humtk.domain.Course;
import com.humtk.domain.Instructor;
import com.humtk.domain.Student;
import com.humtk.domain.StudentCourse;
import com.humtk.service.CourseService;
import com.humtk.service.InstructorService;
import com.humtk.service.StudentCourseService;
import com.humtk.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DersyonetimApplicationTests {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private InstructorService instructorService;

	@Autowired
	private StudentCourseService studentCourseService;

	@Test
	public void addStudent() {
		Student s = new Student();
		s.setMail("kursat.ce@gmail.com");
		s.setStudentNo(21227949);
		s.setFirstName("Kursat");
		s.setLastName("Aktas");

		studentService.save(s);
	}

	@Test
	public void getStudent() {
		System.out.print(studentService.findByMail("kursat.ce@gmail.com"));
		/*System.out.print(studentService.findById(1));*/
	}

	@Test
	public void addInstructor() {
		Instructor i = new Instructor();
		i.setFirstName("Mustafa");
		i.setLastName("Ege");
		i.setMail("m.ege@gmail.com");
		i.setPassword("123456");

		instructorService.save(i);
	}

	@Test
	public void addCourse() {
		Course c = new Course();
		c.setCourseCode("bbm202");
		c.setName("Yazılım lab 2");
		c.setInstructor(instructorService.findById(1));
		courseService.save(c);

		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setCourse(c);
		studentCourse.setStudent(studentService.findById(1));
		studentCourseService.save(studentCourse);
	}

	@Test
	public void getStudentsOfCourse() {
		System.out.print(courseService.findById(4).getStudentList());
	}

	@Test
	public void getInstructor() {
		System.out.print(instructorService.findById(1));
	}

	@Test
	public void getInstructorCourses() {
		System.out.print(instructorService.findById(1).getCourseList());
	}
}
