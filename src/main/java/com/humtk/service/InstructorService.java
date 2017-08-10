package com.humtk.service;

import com.humtk.domain.Instructor;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface InstructorService {

    Instructor findByMail(String mail);
    Instructor findById(long id);
    void save(Instructor instructor);
    Instructor getByCourseId(Long courseId);
    List<Instructor> findAll();

}
