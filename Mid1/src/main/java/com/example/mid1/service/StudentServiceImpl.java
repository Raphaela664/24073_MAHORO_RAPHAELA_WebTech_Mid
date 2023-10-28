package com.example.mid1.service;

import com.example.mid1.dao.StudentDAO;
import com.example.mid1.model.Student;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public class StudentServiceImpl  implements StudentService {
    StudentDAO dao = new StudentDAO();
    @Override
    public boolean addStudent(Student student) {
        return dao.addStudent(student);
    }

    @Override
    public List<Student> fetchAllStudents() throws RemoteException {
        return dao.findAllStudents();
    }

    @Override
    public Student findById(UUID uuid) {
        return dao.findById(uuid);
    }
}
