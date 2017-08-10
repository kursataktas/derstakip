package com.humtk.service;

import com.humtk.domain.Course;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface CourseService {

    Course findById(long id);
    void save(Course course);
    List<Course> getByInstructorCourse(long instructorId);
}
