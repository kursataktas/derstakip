package com.humtk.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kursat on 6.8.2017.
 */

@Entity
public class Course {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String courseCode;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StudentCourse> studentList;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


   /* @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StudentCourseDailyAttendance> studentCourseDailyAttendanceList;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<StudentCourse> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentCourse> studentList) {
        this.studentList = studentList;
    }

    @JsonBackReference
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
