package com.humtk;

import com.humtk.domain.Course;
import com.humtk.domain.Instructor;
import com.humtk.domain.Student;
import com.humtk.domain.StudentAttendance;
import com.humtk.service.CourseService;
import com.humtk.service.InstructorService;
import com.humtk.service.StudentAttendanceService;
import com.humtk.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
	private StudentAttendanceService studentAttendanceService;

	@Test
	public void addStudent() {
		Student s = new Student();
		s.setMail("sdfo@gmail.com");
		s.setStudentNo(21227949);
		s.setFirstName("burcu");
		s.setLastName("iskender");
		s.setPassword("123456");
		s.setCourseList(null);
		studentService.save(s);
	}

	@Test
	public void addStudent2() {
		Student s = new Student();
		s.setMail("kursat.ce@gmail.com");
		s.setStudentNo(21228103);
		s.setFirstName("kürşat");
		s.setLastName("aktaş");
		s.setPassword("123456");
		s.setCourseList(null);
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
		c.setCourseCode("bbm201");
		c.setName("Yazılım lab 1");
		c.setInstructor(instructorService.findById(1));
		c.setStudentList(null);
		courseService.save(c);
	}

	@Test
	public void addCourse2() {
		Course c = new Course();
		c.setCourseCode("bbm202");
		c.setName("Yazılım lab 2");
		c.setInstructor(instructorService.findById(1));
		c.setStudentList(null);
		courseService.save(c);
	}

	@Test
	public void addCourseToStudent() {
		Course course = courseService.findById(2);
		Student student = studentService.findById(2);

		try {
			courseService.addStudent(student, course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getStudentsOfCourse() {
		System.out.print(studentService.getByCourseId(1));
	}

	@Test
	public void getCoursesOfStudent() {
		System.out.print(courseService.getByStudentId(1));
	}

	@Test
	public void getInstructor() {
		System.out.print(instructorService.findById(1));
	}

	@Test
	public void getInstructorCourses() {
		System.out.print(instructorService.findById(1).getCourseList());
	}

	@Test
	public void addAttendance() {
		StudentAttendance studentAttendance = new StudentAttendance();
		studentAttendance.setAttendance(true);
		studentAttendance.setCourse(courseService.findById(2));
		studentAttendance.setStudent(studentService.findById(2));
		studentAttendance.setDate(new Date());

		studentAttendanceService.save(studentAttendance);
	}

	@Test
	public void getAttendanceOfStudent() {
		System.out.print(studentAttendanceService.getByStudent(studentService.findById(2)));
	}

	@Test
	public void getAttendanceOfCourse() {
		System.out.print(studentAttendanceService.getByCourse(courseService.findById(1)));
	}

	@Test
	public void getAttendanceStudentAndCourse() {
		System.out.print(studentAttendanceService.getByStudentAndCourse(studentService.findById(1), courseService.findById(1)));
	}
}
