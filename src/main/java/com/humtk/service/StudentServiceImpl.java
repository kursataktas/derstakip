package com.humtk.service;

import com.humtk.dao.StudentDao;
import com.humtk.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getByCourseId(Long courseId) {
        return null;
    }

    public Student findByMail(String mail) {
        return null;
    }

    public Student findByStudentNo(int studentNo) {
        return null;
    }

    public void save(Student student) {
        studentDao.save(student);
    }
}
