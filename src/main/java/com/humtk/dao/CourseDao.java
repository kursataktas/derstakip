package com.humtk.dao;

import com.humtk.domain.Course;
import com.humtk.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface CourseDao extends CrudRepository<Course, Long> {
    Course findById(long id);
    /*List<Course> getInstructorCourse(long instructorId);*/
}
