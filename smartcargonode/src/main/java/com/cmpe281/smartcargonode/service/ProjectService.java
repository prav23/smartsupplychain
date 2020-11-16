package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Project;
import java.util.List;

public interface ProjectService {
    List<Project> getAllOwnedProjects(String userId);
    Project getProjectById(int projId);
    List<Project> getProjectsByTitle(String title);
}
