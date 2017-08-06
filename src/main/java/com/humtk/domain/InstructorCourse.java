package com.humtk.domain;

/**
 * Created by user on 6.08.2017.
 */
public class InstructorCourse {
    private long id;
    private long instructor_id;
    private long course_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(long instructor_id) {
        this.instructor_id = instructor_id;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }
}
