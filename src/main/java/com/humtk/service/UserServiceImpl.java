package com.humtk.service;

import com.humtk.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kursat on 8.8.2017.
 */
@Service
public class UserServiceImpl  implements  UserService{

    public List<Student> getStudentsByCourseId(Long courseId) {
        return null;
    }

}
