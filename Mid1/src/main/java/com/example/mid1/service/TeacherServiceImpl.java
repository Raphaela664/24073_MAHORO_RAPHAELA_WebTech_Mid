package com.example.mid1.service;

import com.example.mid1.dao.TeacherDAO;
import com.example.mid1.model.Teacher;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public class TeacherServiceImpl implements TeacherService{
    TeacherDAO dao = new TeacherDAO();
    @Override
    public boolean addTeacher(Teacher teacher) {
        return dao.addTeacher(teacher);
    }

    @Override
    public List<Teacher> fetchAllTeachers() throws RemoteException {
        return dao.findAllTeachers();
    }

    @Override
    public Teacher findById(UUID uuid) {
        return dao.findById(uuid);
    }
}
