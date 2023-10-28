package com.example.mid1.service;

import com.example.mid1.model.Teacher;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface TeacherService {
    public boolean addTeacher(Teacher teacher);
    public List<Teacher> fetchAllTeachers() throws RemoteException;
    Teacher findById(UUID uuid);
}
