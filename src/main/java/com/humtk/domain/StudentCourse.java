package com.humtk.domain;

/**
 * Created by user on 6.08.2017.
 */
public class StudentCourse {
    private long id;
    private long student_id;
    private long course_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }
}
