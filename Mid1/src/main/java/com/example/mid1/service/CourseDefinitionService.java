package com.example.mid1.service;

import com.example.mid1.model.CourseDefinition;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface CourseDefinitionService {

    public boolean addCourseDefinition(CourseDefinition courseDefinition);
    public List<CourseDefinition> findAllCourseDefinitions() throws RemoteException;
    public CourseDefinition findById(UUID id);
}
