package com.example.mid1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class StudentRegistration {
    @Id
    private UUID id;
    private LocalDate registrationDate;
    @OneToOne
    private Student student;
    @ManyToOne
    private AcademicUnit academicUnit;
    @OneToOne
    private Semester semester;

    public StudentRegistration() {
    }

    public StudentRegistration(UUID id, LocalDate registrationDate, Student student, AcademicUnit academicUnit, Semester semester) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.student = student;
        this.academicUnit = academicUnit;
        this.semester = semester;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
