package com.humtk.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by kursat on 20.8.2017.
 */

@Embeddable
public class StudentAttendanceId implements java.io.Serializable{

    private Student student;

    private Course course;

    public StudentAttendanceId(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public StudentAttendanceId() {
    }

    @ManyToOne
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentAttendanceId that = (StudentAttendanceId) o;

        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (course != null ? !course.equals(that.course) : that.course != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (student != null ? student.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentAttendanceId{" +
                "student=" + student +
                ", course=" + course +
                '}';
    }
}
