package com.humtk.service;

import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.domain.StudentAttendance;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface StudentAttendanceService {

    List<StudentAttendance> getByStudent(Student student);
    List<StudentAttendance> getByCourse(Course course);
    List<StudentAttendance> getByStudentAndCourse(Student student, Course course);
    void save(StudentAttendance studentAttendance);
}
