package com.cmpe281.smartcargonode.util;

import com.cmpe281.smartcargonode.model.Cargo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CargoRowMapper implements RowMapper<Cargo> {

    @Override
    public Cargo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cargo cargo = new Cargo();
        cargo.setCargo_node_id(rs.getInt("cargo_node_id"));
        cargo.setCargo_node_name(rs.getString("cargo_node_name"));
        return cargo;
    }
}
