package com.example.mid1.dao;

import com.example.mid1.model.Semester;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SemesterDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public SemesterDAO() {
    }

    public boolean addSemester(Semester semester){
        Transaction tr = session.beginTransaction();
        session.merge(semester);
        tr.commit();
        session.close();
        return true;
    }

    public List<Semester> findAllSemesters() {
        Session session = null;
        List<Semester> result = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createQuery("from Semester").list();
        } catch (HibernateException ex) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public Semester findById(UUID id) {
        Session session = null;
        Semester semester = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            semester = session.get(Semester.class, id);
        } catch (HibernateException ex) {
            // Handle exceptions as needed
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return semester;
    }

}
