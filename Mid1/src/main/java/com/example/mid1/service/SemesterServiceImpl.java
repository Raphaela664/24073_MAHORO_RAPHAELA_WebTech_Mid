package com.example.mid1.service;

import com.example.mid1.dao.SemesterDAO;
import com.example.mid1.model.Semester;
import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public class SemesterServiceImpl implements SemesterService {
    SemesterDAO dao = new SemesterDAO();

    @Override
    public boolean addSemester(Semester semester) {
        return dao.addSemester(semester);
    }

    @Override
    public List<Semester> fetchAllSemesters() throws RemoteException {
        return dao.findAllSemesters();
    }

    @Override
    public Semester findById(UUID uuid) {
        return dao.findById(uuid);
    }

}
