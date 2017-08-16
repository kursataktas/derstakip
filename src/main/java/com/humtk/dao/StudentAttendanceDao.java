package com.humtk.dao;

import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.domain.StudentCourseDailyAttendance;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface StudentAttendanceDao extends CrudRepository<StudentCourseDailyAttendance, Long>{
	
	List<StudentCourseDailyAttendance> findByStudent(Student student);
	List<StudentCourseDailyAttendance> findByStudentAndCourse(Student student, Course course);
	
	
}
