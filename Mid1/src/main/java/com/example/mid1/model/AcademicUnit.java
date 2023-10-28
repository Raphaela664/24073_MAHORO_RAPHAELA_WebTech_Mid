package com.example.mid1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class AcademicUnit {
    @Id
    private UUID ID;
    private int code;
    private String name;

    @Enumerated(EnumType.STRING)
    private EAcademicUnit Unit;

    public AcademicUnit() {
    }

    public AcademicUnit(UUID ID, int code, String name, EAcademicUnit unit) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        Unit = unit;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EAcademicUnit getUnit() {
        return Unit;
    }

    public void setUnit(EAcademicUnit unit) {
        Unit = unit;
    }
}
