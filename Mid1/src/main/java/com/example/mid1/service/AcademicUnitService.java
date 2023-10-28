package com.example.mid1.service;

import com.example.mid1.model.AcademicUnit;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface AcademicUnitService {
    public boolean addAcademicUnit(AcademicUnit academicUnit);
    public List<AcademicUnit> getAllAcademicUnits() throws RemoteException;
    public boolean updateAcademicUnit(AcademicUnit academicUnit);
    public boolean deleteAcademicUnitById(AcademicUnit academicUnit);
    public AcademicUnit findById(UUID id);
}
