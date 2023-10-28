package com.example.mid1.service;

import com.example.mid1.dao.StudentCourseDAO;
import com.example.mid1.model.Course;
import com.example.mid1.model.Semester;
import com.example.mid1.model.Student;
import com.example.mid1.model.StudentCourse;

import java.rmi.RemoteException;
import java.util.List;

public class StudentCourseServiceImpl implements StudentCourseService{
    StudentCourseDAO dao = new StudentCourseDAO();

    public boolean addStudentCourse(StudentCourse studentCourse){
        return dao.addStudentCourse(studentCourse);
    };
    public List<Object[]> getStudentCourses() throws RemoteException{
        return  dao.getStudentCourses();
    };
    public List<Object[]> getAllCourses() throws RemoteException{
        return dao.getAllCourses();
    };
    public List<Object[]> getRegisteredStudents() throws RemoteException{
        return dao.getRegisteredStudents();
    };
    public List<StudentCourse> getStudentsByCourseAndSemester(Course course, Semester semester) throws RemoteException{
        return dao.getStudentsByCourseAndSemester(course, semester);
    };
    public List<StudentCourse> getCoursesPerStudent(Student student) throws RemoteException{
        return dao.getCoursesPerStudent(student);
    }
}
