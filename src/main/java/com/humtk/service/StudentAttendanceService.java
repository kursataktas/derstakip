package com.humtk.service;

import com.humtk.domain.Course;
import com.humtk.domain.Student;
import com.humtk.domain.StudentCourseDailyAttendance;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface StudentAttendanceService {

    List<StudentCourseDailyAttendance> getByStudent(Student student);
    List<StudentCourseDailyAttendance> getByStudentAndCourse(Student student, Course course);
    
}
