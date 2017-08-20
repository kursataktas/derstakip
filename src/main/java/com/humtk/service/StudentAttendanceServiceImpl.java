package com.humtk.service;

import com.humtk.dao.StudentAttendanceDao;
import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.domain.StudentAttendance;

import com.humtk.domain.StudentAttendanceId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    @Autowired
    private StudentAttendanceDao studentAttendanceDao;

	@Override
	public List<StudentAttendance> getByStudent(Student student) {
		return studentAttendanceDao.findByPkStudent(student);
	}

	@Override
	public List<StudentAttendance> getByCourse(Course course) {
		return studentAttendanceDao.findByPkCourse(course);
	}

	@Override
	public List<StudentAttendance> getByStudentAndCourse(Student student, Course course) {
		return studentAttendanceDao.findByPk(new StudentAttendanceId(student, course));
	}

	@Override
	public void save(StudentAttendance studentAttendance) {
		studentAttendanceDao.save(studentAttendance);
	}
}



















