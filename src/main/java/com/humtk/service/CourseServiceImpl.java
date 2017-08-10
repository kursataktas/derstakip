package com.humtk.service;

import com.humtk.dao.CourseDao;
import com.humtk.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getCoursesByInstructorId(Long InstructorId) {
        return null;
    }

    @Override
    public Course findById(long id) {
        return null;
    }

    @Override
    public void save(Course course) {
        courseDao.save(course);
    }

    @Override
    public List<Course> getByInstructorCourse(long instructorId) {
        return null;
    }
}
