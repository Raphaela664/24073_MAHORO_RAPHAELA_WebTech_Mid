package com.example.mid1.dao;

import com.example.mid1.model.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeacherDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public TeacherDAO() {
    }
    public boolean addTeacher(Teacher teacher){
        Transaction tr = session.beginTransaction();
        session.merge(teacher);
        tr.commit();
        session.close();
        return true;
    }

    public List<Teacher> findAllTeachers(){
        Session session = null;
        List<Teacher> result = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createQuery("from Teacher").list();
        } catch (HibernateException ex) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }
    public Teacher findById(UUID id) {
        Session session = null;
        Teacher teacher = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            teacher = session.get(Teacher.class, id);
        } catch (HibernateException ex) {
            // Handle exceptions as needed
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return teacher;
    }
}
