package com.example.mid1.dao;

import com.example.mid1.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentCourseDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public StudentCourseDAO () {
    }

    public boolean addStudentCourse(StudentCourse studentCourse){
        Transaction tr = session.beginTransaction();
        session.merge(studentCourse);
        tr.commit();
        session.close();
        return true;
    }

    public List<Object[]> getStudentCourses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT sc.studentcourse_id, st.regNo, st.firstName, cd.code, cd.name, sc.credits, sc.results FROM CourseDefinition cd JOIN Course c ON cd.id = c.Definition.code JOIN StudentCourse sc ON c.Course_id = sc.course.Course_id JOIN StudentRegistration stu ON stu.id = sc.studentcourse_id JOIN Student st On st.regNo = stu.student.regNo";
            Query<Object[]> query = session.createQuery(hql);
            return query.list();
        } finally {
            session.close();
        }
    }

    public List<Object[]> getAllCourses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> results = new ArrayList<>();
        try {
            results = session.createQuery("SELECT cs.Course_id,  cd.code, cd.name FROM Course cs JOIN CourseDefinition cd ON cd.code = cs.Definition.code").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Object[]> getRegisteredStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> results = new ArrayList<>();
        try {
            results = session.createQuery("SELECT studreg.id, stud.regNo, stud.firstName FROM StudentRegistration studreg JOIN Student stud ON stud.id = studreg.student.id").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
    public List<StudentCourse> getStudentsByCourseAndSemester(Course course, Semester semester) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM StudentCourse sr WHERE sr.course = :course AND sr.studentRegistration.semester = :semester";
            Query<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
            query.setParameter("course", course);
            query.setParameter("semester", semester);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<StudentCourse> getCoursesPerStudent(Student student) {
        try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM StudentCourse sr WHERE sr.studentRegistration.student = :student";
            Query<StudentCourse> query = session1.createQuery(hql, StudentCourse.class);
            query.setParameter("student", student);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
