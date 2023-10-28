package com.example.mid1.dao;

import com.example.mid1.model.AcademicUnit;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class AcademicUnitDAO {
    public AcademicUnitDAO() {
    }


    public boolean addAcademicUnit(AcademicUnit academicUnit){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.merge(academicUnit);
        tr.commit();
        session.close();
        return Boolean.TRUE;
    }

    public List<AcademicUnit> getAllAcademicUnits() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM AcademicUnit";
            Query<AcademicUnit> query = session.createQuery(hql, AcademicUnit.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    public boolean updateAcademicUnit(AcademicUnit academicUnit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(academicUnit); // Use update instead of merge for updating
            tr.commit();
            return true;
        } catch (HibernateException ex) {
            if (tr != null) {
                tr.rollback(); // Rollback the transaction in case of an exception
            }
            ex.printStackTrace(); // Handle or log the exception as needed
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteAcademicUnitById(AcademicUnit academicUnit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.delete(academicUnit);
            tr.commit();
            return true;
        } catch (HibernateException ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public AcademicUnit findById(UUID id) {
        Session session = null;
        AcademicUnit academicUnit = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            academicUnit = session.get(AcademicUnit.class, id);
        } catch (HibernateException ex) {
            // Handle exceptions as needed
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return academicUnit;
    }
}
