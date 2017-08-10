package com.humtk.dao;

import com.humtk.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface StudentDao extends CrudRepository<Student, Long>{
    Student findByMail(String mail);
    Student findByStudentNo(int studentNo);
    List<Student> findAll();
}
