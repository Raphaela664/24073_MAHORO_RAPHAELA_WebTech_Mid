package com.example.mid1.service;

import com.example.mid1.model.AcademicUnit;
import com.example.mid1.model.Semester;
import com.example.mid1.model.Student;
import com.example.mid1.model.StudentRegistration;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface StudentRegistrationService {
    public boolean addStudentReg(StudentRegistration studentRegistration) throws RemoteException;
    public List<StudentRegistration> findAllStudentsReg() throws  RemoteException;
    public List<Semester> getSemesters() throws  RemoteException;
    public List<AcademicUnit> getAcademicUnits() throws RemoteException;
    public List<Student> getStudents() throws RemoteException;
    public StudentRegistration findByIdStudReg(UUID id);
    public StudentRegistration findById(UUID id);
    public List<StudentRegistration> getStudentsByDepartmentAndSemester(AcademicUnit department, Semester semester) throws RemoteException;
    public List<StudentRegistration> getStudentsBySemester(Semester semester) throws RemoteException;
}
