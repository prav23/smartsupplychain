package com.cmpe281.smartcargonode.util;

import com.cmpe281.smartcargonode.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();
        project.setProjId(rs.getInt("proj_id"));
        project.setTitle(rs.getString("title"));
        project.setDescription(rs.getString("description"));
        project.setOwnerId(rs.getString("owner_id"));
        return project;
    }
}
