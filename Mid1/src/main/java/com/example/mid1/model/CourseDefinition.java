package com.example.mid1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class CourseDefinition {

    @Id
    private UUID ID;
    private String code;

    private String name;


    private String description;

    public CourseDefinition() {
    }

    @Override
    public String toString(){
        return this.name;
    }

    public CourseDefinition(UUID ID, String code, String name, String description) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
