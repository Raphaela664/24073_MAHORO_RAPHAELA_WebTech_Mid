package com.example.mid1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class StudentCourse {
    @Id
    private UUID studentcourse_id;
    private int credits;

    private BigDecimal results;
    @ManyToOne
    private Course course;
    @ManyToOne
    private StudentRegistration studentRegistration;

    public StudentCourse() {
    }

    public StudentCourse(UUID studentcourse_id, int credits, BigDecimal results, Course course, StudentRegistration studentRegistration) {
        this.studentcourse_id = studentcourse_id;
        this.credits = credits;
        this.results = results;
        this.course = course;
        this.studentRegistration = studentRegistration;
    }

    public UUID getStudentcourse_id() {
        return studentcourse_id;
    }

    public void setStudentcourse_id(UUID studentcourse_id) {
        this.studentcourse_id = studentcourse_id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public BigDecimal getResults() {
        return results;
    }

    public void setResults(BigDecimal results) {
        this.results = results;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public StudentRegistration getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(StudentRegistration studentRegistration) {
        this.studentRegistration = studentRegistration;
    }
}
