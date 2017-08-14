package com.humtk.service;

import com.humtk.dao.StudentCourseDao;
import com.humtk.dao.StudentDao;
import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.domain.StudentCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseDao studentCourseDao;

	@Override
	public List<Course> getByStudent(Student student) {
		List<StudentCourse> all = studentCourseDao.findByStudent(student);
		List<Course> courses = new ArrayList<>();
		for (StudentCourse sc : all) {
			courses.add(sc.getCourse());
		}
		return courses;
	}

}



















