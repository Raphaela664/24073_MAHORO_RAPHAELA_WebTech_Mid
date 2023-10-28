package com.example.mid1.dao;

import com.example.mid1.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();
    public CourseDAO(){}
    public boolean createCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(course);
        tx.commit();
        session.close();
        return Boolean.TRUE;
    };
    public List<Course> getAllCourses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Course";
            Query<Course> query = session.createQuery(hql, Course.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    // for dropdownlist
    public List<AcademicUnit> getAcademicUnits() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<AcademicUnit> results = new ArrayList<>();
        try {
            results = session.createQuery("select acUnit.code, acUnit.name from AcademicUnit acUnit where acUnit.Unit = 'DEPARTMENT'").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Semester> getAllSemesters() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Semester> results = new ArrayList<>();
        try {
            results = session.createQuery("select sem.id, sem.semester_id, sem.name, sem.startDate, sem.endDate from Semester sem").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<CourseDefinition> getCourseDefinition() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseDefinition> results = new ArrayList<>();
        try {
            results = session.createQuery("select cd.code, cd.name from CourseDefinition cd").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Teacher> getTutorsAndAssistants() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Teacher> results = new ArrayList<>();
        try {
            results = session.createQuery("select t.teacher_code, t.names from Teacher t").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public Course findById(UUID course_id) {
        Session session = null;
        Course course = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            course = session.get(Course.class, course_id);
        } catch (HibernateException ex) {
            // Handle exceptions as needed
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return course;
    }
    public List<Course> getCourseByDepartmentAndSemester(AcademicUnit department, Semester semester){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Course sr WHERE sr.Unit = :department AND sr.semester = :semester";
            Query<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("department", department);
            query.setParameter("semester", semester);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
