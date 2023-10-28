package com.example.mid1.service;

import com.example.mid1.model.*;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface CourseService {
    public boolean createCourse(Course course);
    public List<Course> getAllCourses() throws RemoteException;
    public List<AcademicUnit> getAcademicUnits() throws RemoteException;
    public List<Semester> getAllSemesters() throws RemoteException;
    public List<CourseDefinition> getCourseDefinition() throws RemoteException;
    public List<Teacher> getTutorsAndAssistants() throws RemoteException;
    public Course findById(UUID course_id);
    public List<Course> getCourseByDepartmentAndSemester(AcademicUnit department, Semester semester) throws RemoteException;

}
