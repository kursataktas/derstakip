package com.humtk.service;

import com.humtk.dao.InstructorDao;
import com.humtk.dao.StudentDao;
import com.humtk.domain.Instructor;
import com.humtk.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorDao instructorDao;

    @Override
    public Instructor findByMail(String mail) {
        return null;
    }

    @Override
    public Instructor findById(long id) {
        return instructorDao.findById(id);
    }

    @Override
    public void save(Instructor instructor) {
        instructorDao.save(instructor);
    }

    @Override
    public Instructor getByCourseId(Long courseId) {
        return null;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDao.findAll();
    }
}
