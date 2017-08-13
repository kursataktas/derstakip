package com.humtk.service;

import com.humtk.domain.Student;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface StudentService {

    Student findById(long id);
    Student findByMail(String mail);
    Student findByStudentNo(int studentNo);
    void save(Student student);
    List<Student> getByCourseId(Long courseId);

}
