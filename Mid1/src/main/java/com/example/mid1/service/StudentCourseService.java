package com.example.mid1.service;

import com.example.mid1.model.Course;
import com.example.mid1.model.Semester;
import com.example.mid1.model.Student;
import com.example.mid1.model.StudentCourse;

import java.rmi.RemoteException;
import java.util.List;

public interface StudentCourseService {
    public boolean addStudentCourse(StudentCourse studentCourse);
    public List<Object[]> getStudentCourses() throws RemoteException;
    public List<Object[]> getAllCourses() throws RemoteException;
    public List<Object[]> getRegisteredStudents() throws RemoteException;
    public List<StudentCourse> getStudentsByCourseAndSemester(Course course, Semester semester) throws RemoteException;
    public List<StudentCourse> getCoursesPerStudent(Student student) throws RemoteException;
}
