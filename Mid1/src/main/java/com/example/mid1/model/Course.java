package com.example.mid1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.ManyToAny;

import java.util.UUID;

@Entity
public class Course {
    @Id
    private UUID Course_id;
   @ManyToOne
   private CourseDefinition Definition;
   @ManyToOne
   private AcademicUnit Unit;

   @ManyToOne

   private Teacher tutor;

   @ManyToOne
    private Teacher assistant;

   @ManyToOne
   private Semester semester;

    public Course(UUID course_id, CourseDefinition definition, AcademicUnit unit, Teacher tutor, Teacher assistant, Semester semester) {
        Course_id = course_id;
        Definition = definition;
        Unit = unit;
        this.tutor = tutor;
        this.assistant = assistant;
        this.semester = semester;
    }

    public UUID getCourse_id() {
        return Course_id;
    }

    public void setCourse_id(UUID course_id) {
        Course_id = course_id;
    }

    public CourseDefinition getDefinition() {
        return Definition;
    }

    public void setDefinition(CourseDefinition definition) {
        Definition = definition;
    }

    public AcademicUnit getUnit() {
        return Unit;
    }

    public void setUnit(AcademicUnit unit) {
        Unit = unit;
    }

    public Teacher getTutor() {
        return tutor;
    }

    public void setTutor(Teacher tutor) {
        this.tutor = tutor;
    }

    public Teacher getAssistant() {
        return assistant;
    }

    public void setAssistant(Teacher assistant) {
        this.assistant = assistant;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Course() {
    }

}
