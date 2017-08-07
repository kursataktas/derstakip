package com.humtk.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kursat on 6.8.2017.
 */
public class StudentCourseDailyAttendance {

    /*
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinTable(name = "student")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinTable(name = "course")
    @JoinColumn(name = "course_id")
    private Course course;

    private boolean attendance;

    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    */
}
