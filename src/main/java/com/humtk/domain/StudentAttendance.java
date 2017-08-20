package com.humtk.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kursat on 6.8.2017.
 */
@Entity
@Table(name = "student_attendance")
@AssociationOverrides({
        @AssociationOverride(name = "pk.student",
                joinColumns = @JoinColumn(name = "student_id")),
        @AssociationOverride(name = "pk.course",
                joinColumns = @JoinColumn(name = "course_id")) })
public class StudentAttendance {

    private StudentAttendanceId pk = new StudentAttendanceId();

    @Transient
    private boolean attendance;

    private Date date;

    @EmbeddedId
    public StudentAttendanceId getPk() {
        return pk;
    }

    public void setPk(StudentAttendanceId pk) {
        this.pk = pk;
    }

    @Transient
    public Student getStudent() {
        return getPk().getStudent();
    }

    public void setStudent(Student student) {
        getPk().setStudent(student);
    }

    @Transient
    public Course getCourse() {
        return getPk().getCourse();
    }

    public void setCourse(Course course) {
        getPk().setCourse(course);
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false, length = 10)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        StudentAttendance that = (StudentAttendance) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    public boolean getAttendance() {
        return this.attendance;
    }

    @Override
    public String toString() {
        return "StudentAttendance{" +
                "pk=" + pk +
                ", attendance=" + attendance +
                ", date=" + date +
                '}';
    }
}
