package com.humtk.service;

import com.humtk.dao.StudentAttendanceDao;
import com.humtk.dao.StudentCourseDao;
import com.humtk.dao.StudentDao;
import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.domain.StudentCourse;
import com.humtk.domain.StudentCourseDailyAttendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    @Autowired
    private StudentAttendanceDao studentAttendanceDao;

	@Override
	public List<StudentCourseDailyAttendance> getByStudent(Student student) {
		return studentAttendanceDao.findByStudent(student);
	}

	@Override
	public List<StudentCourseDailyAttendance> getByStudentAndCourse(Student student, Course course) {
		return studentAttendanceDao.findByStudentAndCourse(student,course);
	}

}



















