package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Sensor;
import com.cmpe281.smartcargonode.util.SensorRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

@Service
public class SensorServiceImpl implements SensorService{
    private static final Logger logger = LogManager.getLogger(SensorServiceImpl.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Sensor updateSensor(Integer sensor_id, Integer cargo_node_id, String sensor_name, String sensor_data,
                                String sensor_data_format, String sensor_status){
        logger.info("updateSensorStatus for given sensor_id: " + sensor_id);
        Timestamp time_stamp = new Timestamp(System.currentTimeMillis());
        String update_sensor_query = "UPDATE sensor set cargo_node_id = ?, sensor_name = ?, sensor_data = ?, sensor_data_format = ?, sensor_status = ?, time_stamp = ? where sensor_id = ?";


        KeyHolder keyHolder = new GeneratedKeyHolder();
        int numRows = jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(update_sensor_query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cargo_node_id);
            ps.setString(2, sensor_name);
            ps.setString(3, sensor_data);
            ps.setString(4, sensor_data_format);
            ps.setString(5, sensor_status);
            ps.setTimestamp(6, time_stamp);
            ps.setInt(7, sensor_id);
            return ps;
        }, keyHolder);

        if (numRows > 0) {
            logger.info("createProject -- success");
            Sensor sensor = jdbcTemplate.queryForObject("SELECT * FROM sensor WHERE sensor_id = ?",
                    new Object[]{sensor_id},
                    new SensorRowMapper());
            return sensor;
        } else {
            logger.error("failed to create new sensor record in the db");
            return null;
        }
    }

    @Override
    public Sensor addSensor(Integer cargo_node_id, String sensor_name, String sensor_data,
                                String sensor_data_format, String sensor_status){
        logger.info("addSensor");
        String add_sensor_query = "INSERT INTO sensor(cargo_node_id, sensor_name, sensor_data, sensor_data_format, sensor_status, time_stamp)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        logger.info("addSensor -- INSERT SQL: " + add_sensor_query);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int numRows = jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(add_sensor_query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cargo_node_id);
            ps.setString(2, sensor_name);
            ps.setString(3, sensor_data);
            ps.setString(4, sensor_data_format);
            ps.setString(5, sensor_status);
            ps.setTimestamp(6, timestamp);
            return ps;
        }, keyHolder);

        if (numRows > 0) {
            logger.info("createProject -- success");
            Sensor sensor = jdbcTemplate.queryForObject("SELECT * FROM sensor WHERE sensor_id = ?",
                    new Object[]{keyHolder.getKey()},
                    new SensorRowMapper());
            return sensor;
        } else {
            logger.error("failed to create new sensor record in the db");
            return null;
        }
    }

    @Override
    public Boolean deleteSensor(Integer sensor_id, Integer cargo_node_id){
        String query = "DELETE FROM sensor WHERE sensor_id = ?";
        logger.info("delete sensor_id " + sensor_id + "in cargo_node_id"+ cargo_node_id);
        logger.info("delete query :"+ query);

        if (jdbcTemplate.update(query, sensor_id) == 0) {
            logger.info("deletion failed for sensor: " + sensor_id);
        } else {
            logger.info("deleteSensor -- sensorId: " + sensor_id + " removed from task table");
        }

        logger.info("deleteSensor -- deletion complete");
        return true;
    }
}

