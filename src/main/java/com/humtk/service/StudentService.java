package com.humtk.service;

import com.humtk.domain.Student;

import java.util.List;
import java.util.Set;

/**
 * Created by kursat on 8.8.2017.
 */
public interface StudentService {

    Student findById(long id);
    Student findByMail(String mail);
    Student findByStudentNo(int studentNo);
    void save(Student student);
    Set<Student> getByCourseId(long courseId);

}
