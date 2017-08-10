package com.humtk.dao;

import com.humtk.domain.Instructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface InstructorDao extends CrudRepository<Instructor, Long>{
    Instructor findByMail(String mail);
    Instructor findById(long instructorId);
    List<Instructor> findAll();
}
