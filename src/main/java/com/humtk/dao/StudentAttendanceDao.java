package com.humtk.dao;

import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.domain.StudentAttendance;

import com.humtk.domain.StudentAttendanceId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface StudentAttendanceDao extends CrudRepository<StudentAttendance, Long>{
	
	List<StudentAttendance> findByPkStudent(Student student);
	List<StudentAttendance> findByPkCourse(Course course);
	List<StudentAttendance> findByPk(StudentAttendanceId studentAttendanceId);
	
	
}
