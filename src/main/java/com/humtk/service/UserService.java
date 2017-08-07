package com.humtk.service;

import com.humtk.domain.Student;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface UserService {

    List<Student> getStudentsByCourseId(Long courseId);
}
