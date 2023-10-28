package com.example.mid1.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.example.mid1.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StudentDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public StudentDAO() {
    }
    public boolean addStudent(Student student){
        Transaction tr = session.beginTransaction();
        session.merge(student);
        tr.commit();
        session.close();
        return true;
    }

    public List<Student> findAllStudents() {
        Session session = null;
        List<Student> result = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createQuery("from Student ").list();
        } catch (HibernateException ex) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public Student findById(UUID id) {
        Session session = null;
        Student student = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            student = session.get(Student.class, id);
        } catch (HibernateException ex) {
            // Handle exceptions as needed
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return student;
    }
}
