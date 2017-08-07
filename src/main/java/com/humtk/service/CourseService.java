package com.humtk.service;

import com.humtk.domain.Course;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface CourseService {

    List<Course> getCoursesByInstructorId(Long InstructorId);
}
