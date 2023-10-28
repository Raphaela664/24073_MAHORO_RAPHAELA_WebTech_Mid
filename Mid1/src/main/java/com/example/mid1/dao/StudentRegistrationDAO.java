package com.example.mid1.dao;

import com.example.mid1.model.AcademicUnit;
import com.example.mid1.model.Semester;
import com.example.mid1.model.Student;
import com.example.mid1.model.StudentRegistration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentRegistrationDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public StudentRegistrationDAO() {
    }

    public boolean addStudentReg(StudentRegistration studentRegistration) {
        Transaction tr = session.beginTransaction();
        session.merge(studentRegistration);
        tr.commit();
        session.close();
        return true;
    }

    public List<StudentRegistration> findAllStudentsReg() {
        Session session = null;
        List<StudentRegistration> result = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createQuery("from StudentRegistration ").list();
        } catch (HibernateException ex) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public List<AcademicUnit> getAcademicUnits() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<AcademicUnit> results = new ArrayList<>();
        try {
            results = session.createQuery("select cd.code, cd.name from AcademicUnit cd").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Semester> getSemesters() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Semester> results = new ArrayList<>();
        try {
            results = session.createQuery("select cd.semester_id, cd.name from Semester cd").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Student> getStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> results = new ArrayList<>();
        try {
            results = session.createQuery("select cd.regNo, cd.firstName from Student cd").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public StudentRegistration findByIdStudReg(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM StudentRegistration WHERE id = :id";
            Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

    public StudentRegistration findById(UUID id) {
        Session session = null;
        StudentRegistration studentRegistration = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            studentRegistration = session.get(StudentRegistration.class, id);
        } catch (HibernateException ex) {
            // Handle exceptions as needed
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return studentRegistration;
    }

    public List<StudentRegistration> getStudentsByDepartmentAndSemester(AcademicUnit department, Semester semester) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM StudentRegistration sr WHERE sr.academicUnit = :department AND sr.semester = :semester";
            Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
            query.setParameter("department", department);
            query.setParameter("semester", semester);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentRegistration> getStudentsBySemester(Semester semester) {
        try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM StudentRegistration sr WHERE sr.semester = :semester";
            Query<StudentRegistration> query = session1.createQuery(hql, StudentRegistration.class);
            query.setParameter("semester", semester);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
