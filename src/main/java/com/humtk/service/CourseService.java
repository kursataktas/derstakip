package com.humtk.service;

import com.humtk.domain.Course;
import com.humtk.domain.Student;

import java.util.List;
import java.util.Set;

/**
 * Created by kursat on 8.8.2017.
 */
public interface CourseService {

    Course findById(long id);
    void save(Course course);
    void addStudent(Student student, Course course) throws Exception;
    List<Course> getByInstructorCourse(long instructorId);
    Set<Course> getByStudentId(long studentId);
    List<Course> getByStudent(Student student);
}
