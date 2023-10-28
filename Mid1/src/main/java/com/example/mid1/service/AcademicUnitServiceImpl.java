package com.example.mid1.service;

import com.example.mid1.dao.AcademicUnitDAO;
import com.example.mid1.model.AcademicUnit;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public class AcademicUnitServiceImpl implements AcademicUnitService{
    AcademicUnitDAO dao = new AcademicUnitDAO();
    public boolean addAcademicUnit(AcademicUnit academicUnit){
        return dao.addAcademicUnit(academicUnit);
    }

    public List<AcademicUnit> getAllAcademicUnits() throws RemoteException{
        return dao.getAllAcademicUnits();
    }
    public boolean updateAcademicUnit(AcademicUnit academicUnit){
        return dao.updateAcademicUnit(academicUnit);
    }
    public boolean deleteAcademicUnitById(AcademicUnit academicUnit){
        return dao.deleteAcademicUnitById(academicUnit);
    }
    public AcademicUnit findById(UUID id){
        return dao.findById(id);
    }
}
