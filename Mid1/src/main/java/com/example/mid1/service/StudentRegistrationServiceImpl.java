package com.example.mid1.service;

import com.example.mid1.dao.SemesterDAO;
import com.example.mid1.dao.StudentRegistrationDAO;
import com.example.mid1.model.AcademicUnit;
import com.example.mid1.model.Semester;
import com.example.mid1.model.Student;
import com.example.mid1.model.StudentRegistration;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;


public class StudentRegistrationServiceImpl implements StudentRegistrationService{
    StudentRegistrationDAO dao = new StudentRegistrationDAO();
    public boolean addStudentReg(StudentRegistration studentRegistration) throws RemoteException{
        return dao.addStudentReg(studentRegistration);

    };
    public List<StudentRegistration> findAllStudentsReg() throws  RemoteException{
        return dao.findAllStudentsReg();
    };
    public List<Semester> getSemesters() throws  RemoteException{
        return dao.getSemesters();

    };
    public List<AcademicUnit> getAcademicUnits() throws RemoteException{
        return dao.getAcademicUnits();

    };
    public List<Student> getStudents() throws RemoteException{
        return dao.getStudents();
    };
    public StudentRegistration findByIdStudReg(UUID id){
        return dao.findByIdStudReg(id);

    };
    public StudentRegistration findById(UUID id){
        return dao.findById(id);

    };
    public List<StudentRegistration> getStudentsByDepartmentAndSemester(AcademicUnit department, Semester semester) throws RemoteException{
        return dao.getStudentsByDepartmentAndSemester(department,semester);
    };
    public List<StudentRegistration> getStudentsBySemester(Semester semester) throws RemoteException{
        return dao.getStudentsBySemester(semester);
    };
}
