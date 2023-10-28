package com.example.mid1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Student {
    @Id
    private UUID ID;

    private String regNo;


    private String firstName;

    private LocalDate dateOfBirth;

    public Student() {
    }
    @Override
    public String toString(){
        return this.firstName;
    }

    public Student(UUID ID, String regNo, String firstName, LocalDate dateOfBirth) {
        this.ID = ID;
        this.regNo = regNo;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
