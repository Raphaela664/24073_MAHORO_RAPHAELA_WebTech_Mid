package com.example.mid1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Semester {

    @Id
    private UUID ID;
    private String semester_id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public Semester() {
    }

    @Override
    public String toString(){
        return this.name;
    }

    public Semester(UUID ID, String semester_id, String name, LocalDate startDate, LocalDate endDate) {
        this.ID = ID;
        this.semester_id = semester_id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(String semester_id) {
        this.semester_id = semester_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
