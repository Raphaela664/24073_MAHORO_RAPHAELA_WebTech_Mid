package com.example.mid1.service;

import com.example.mid1.dao.CourseDAO;
import com.example.mid1.model.*;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public class CourseServiceImpl implements CourseService {
    CourseDAO dao = new CourseDAO();
    public boolean createCourse(Course course){
        return dao.createCourse(course);
    };
    public List<Course> getAllCourses() throws RemoteException{
        return dao.getAllCourses();
    };
    public List<AcademicUnit> getAcademicUnits() throws RemoteException{
        return dao.getAcademicUnits();
    };
    public List<Semester> getAllSemesters() throws RemoteException{
        return  dao.getAllSemesters();
    };
    public List<CourseDefinition> getCourseDefinition() throws RemoteException{
        return dao.getCourseDefinition();
    };
    public List<Teacher> getTutorsAndAssistants() throws RemoteException{
        return dao.getTutorsAndAssistants();
    };
    public Course findById(UUID course_id){
        return dao.findById(course_id);
    };
    public List<Course> getCourseByDepartmentAndSemester(AcademicUnit department, Semester semester) throws RemoteException{
        return dao.getCourseByDepartmentAndSemester(department,semester);
    };
}
