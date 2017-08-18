package com.humtk.dao;

import com.humtk.domain.Student;
import com.humtk.domain.StudentCourse;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
public interface StudentCourseDao extends CrudRepository<StudentCourse, Long>{
    List<StudentCourse> findByStudent(Student student);
    List<Student> findByCourse(long id);
}


