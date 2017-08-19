package com.humtk.service;

import com.humtk.dao.StudentDao;
import com.humtk.domain.Course;
import com.humtk.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by kursat on 8.8.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private  CourseService courseService;

    @Override
    public Set<Student> getByCourseId(long courseId) {
        Course course = courseService.findById(courseId);
        return course.getStudentList();
    }

    @Override
    public Student findByMail(String mail) {
        return studentDao.findByMail(mail);
    }

    @Override
    public Student findByStudentNo(int studentNo) {
        return null;
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student findById(long id) {
        return studentDao.findById(id);
    }
}
