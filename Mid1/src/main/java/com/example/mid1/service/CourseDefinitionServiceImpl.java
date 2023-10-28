package com.example.mid1.service;

import com.example.mid1.dao.CourseDefinitionDAO;
import com.example.mid1.model.CourseDefinition;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public class CourseDefinitionServiceImpl implements CourseDefinitionService{
    CourseDefinitionDAO dao = new CourseDefinitionDAO();
    public boolean addCourseDefinition(CourseDefinition courseDefinition){
        return dao.addCourseDefinition(courseDefinition);
    };
    public List<CourseDefinition> findAllCourseDefinitions() throws RemoteException{
        return dao.findAllCourseDefinitions();
    };
    public CourseDefinition findById(UUID id){
        return dao.findById(id);
    }
}
