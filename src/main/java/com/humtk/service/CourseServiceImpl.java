package com.humtk.service;

import com.humtk.dao.CourseDao;
import com.humtk.dao.InstructorDao;
import com.humtk.dao.StudentDao;
import com.humtk.domain.Course;
import com.humtk.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private InstructorDao instructorDao;

    @Autowired
    private StudentDao studentDao;

    public List<Course> getCoursesByInstructorId(Long InstructorId) {
        return null;
    }

    @Override
    public Course findById(long id) {
        return courseDao.findById(id);
    }

    @Override
    public void save(Course course) {
        courseDao.save(course);
    }

    @Override
    public List<Course> getByInstructorCourse(long instructorId) {
        return instructorDao.findById(instructorId).getCourseList();
    }

    @Override
    public List<Course> getByStudentCourse(long studentId) {
        return new ArrayList<Course>();
    }
}
