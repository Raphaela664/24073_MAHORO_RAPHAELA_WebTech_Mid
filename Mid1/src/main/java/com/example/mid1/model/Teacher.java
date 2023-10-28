package com.example.mid1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Teacher {
    @Id
    private UUID ID;

    private String teacher_code;

    private String names;


    @Enumerated(EnumType.STRING)
    private EQualification qualification;

    public Teacher() {
    }
    @Override
    public String toString(){
        return this.names;
    }

    public Teacher(UUID ID, String teacher_code, String names, EQualification qualification) {
        this.ID = ID;
        this.teacher_code = teacher_code;
        this.names = names;
        this.qualification = qualification;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getTeacher_code() {
        return teacher_code;
    }

    public void setTeacher_code(String teacher_code) {
        this.teacher_code = teacher_code;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public EQualification getQualification() {
        return qualification;
    }

    public void setQualification(EQualification qualification) {
        this.qualification = qualification;
    }
}
