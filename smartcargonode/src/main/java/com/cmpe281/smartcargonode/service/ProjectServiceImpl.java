package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Project;
import com.cmpe281.smartcargonode.util.ProjectRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private static final Logger logger = LogManager.getLogger(ProjectServiceImpl.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Project> getAllOwnedProjects(String ownerId) {
        String query = "SELECT * FROM project WHERE owner_id = ?";
        List<Project> projects = jdbcTemplate.query(query, new Object[] {ownerId}, new ProjectRowMapper());
        return projects;
    }

    @Override
    public Project getProjectById(int projId) {
        String query = "SELECT * FROM project WHERE proj_id = ?";
        List<Project> projects = jdbcTemplate.query(query, new Object[] {projId}, new ProjectRowMapper());
        return projects.get(0);
    }

    @Override
    public List<Project> getProjectsByTitle(String title) {
        String query = "SELECT * FROM project WHERE title = ?";
        List<Project> projects = jdbcTemplate.query(query, new Object[] {title}, new ProjectRowMapper());
        return projects;
    }
}
