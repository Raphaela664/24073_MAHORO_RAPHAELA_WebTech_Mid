package com.example.mid1.dao;

import com.example.mid1.model.CourseDefinition;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseDefinitionDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public CourseDefinitionDAO() {
    }

    public boolean addCourseDefinition(CourseDefinition courseDefinition){
        Transaction tr = session.beginTransaction();
        session.merge(courseDefinition);
        tr.commit();
        session.close();
        return true;
    }

    public List<CourseDefinition> findAllCourseDefinitions() {
        Session session = null;
        List<CourseDefinition> result = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createQuery("from CourseDefinition ").list();
        } catch (HibernateException ex) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }


    public CourseDefinition findById(UUID id) {
        Session session = null;
        CourseDefinition courseDefinition = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            courseDefinition = session.get(CourseDefinition.class, id);
        } catch (HibernateException ex) {
            // Handle exceptions as needed
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return courseDefinition;
    }
}
