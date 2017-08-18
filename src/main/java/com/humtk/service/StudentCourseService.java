package com.humtk.service;

import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.domain.StudentCourse;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface StudentCourseService {

    List<Course> getByStudent(Student student);
    List<Student> getByCourse(long id);
    void save(StudentCourse studentCourseList);
}
