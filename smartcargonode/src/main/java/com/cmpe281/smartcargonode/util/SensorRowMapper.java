package com.cmpe281.smartcargonode.util;

import com.cmpe281.smartcargonode.model.Sensor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorRowMapper implements RowMapper<Sensor> {

    @Override
    public Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sensor sensor = new Sensor();
        sensor.setSensor_id(rs.getInt("sensor_id"));
        sensor.setCargo_node_id(rs.getInt("cargo_node_id"));
        sensor.setSnm_id(rs.getInt("snm_id"));
        sensor.setSensor_name(rs.getString("sensor_name"));
        sensor.setSensor_data(rs.getString("sensor_data"));
        sensor.setSensor_data_format(rs.getString("sensor_data_format"));
        sensor.setSensor_status(rs.getString("sensor_status"));
        sensor.setTime_stamp(rs.getDate("time_stamp"));

        return sensor;
    }
}
