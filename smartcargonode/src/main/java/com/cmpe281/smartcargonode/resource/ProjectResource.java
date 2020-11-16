package com.cmpe281.smartcargonode.resource;

import com.cmpe281.smartcargonode.model.Project;
import com.cmpe281.smartcargonode.service.ProjectService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectResource {

    private static final Logger logger = LogManager.getLogger(ProjectResource.class);
    private ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/owned")
    @ApiOperation(value = "Fetches all projects owned by the specified ownerId",
            notes = "DB query against the 'project' table",
            response = Project.class, responseContainer = "List")
    public List<Project> getAllOwnedProjects(@ApiParam(value = "the ownerId to search for projects", required = true) @RequestParam String ownerId) {
        logger.info("ProjectResource::getAllOwnedProjects() -- fetching all projects for ownerId: " + ownerId);
        return projectService.getAllOwnedProjects(ownerId);
    }

    @GetMapping("/byid")
    @ApiOperation(value = "Fetches project by ID",
            notes = "DB query against the 'project' table",
            response = Project.class, responseContainer = "Project")
    public Project getProjectById(@ApiParam(value = "project ID", required = true) @RequestParam int projId) {
        logger.info("ProjectResource::getProjectById() -- fetch project by ID: " + projId);
        return projectService.getProjectById(projId);
    }

    @GetMapping("/bytitle")
    @ApiOperation(value = "Fetches project by title",
            notes = "DB query against the 'project' table",
            response = Project.class, responseContainer = "Project")
    public List<Project> getProjectsByTitle(@ApiParam(value = "title", required = true) @RequestParam String title) {
        logger.info("ProjectResource::getProjectsByTitle() -- fetch project by title: " + title);
        return projectService.getProjectsByTitle(title);
    }

}
