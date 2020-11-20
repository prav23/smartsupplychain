package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Cargo;
import com.cmpe281.smartcargonode.model.Sensor;
import com.cmpe281.smartcargonode.util.CargoRowMapper;
import com.cmpe281.smartcargonode.util.SensorRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Service
public class CargoNodeServiceImpl implements CargoNodeService {

    private static final Logger logger = LogManager.getLogger(CargoNodeServiceImpl.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Sensor> getCargoNodeSensorData(Integer cargo_node_id){
        logger.info("getALLSensorData for given cargo_node_id: " + cargo_node_id);
        // Simulate sensor values at random here with latest time_stamp and update in sql table and send to backend cloud
        String query = "SELECT * FROM sensor WHERE cargo_node_id = ?";
        logger.info("getCargoNodeSensorData -- SELECT SQL: " + query);

        try {
            List<Sensor> sensorsData = jdbcTemplate.query(query, new Object[]{cargo_node_id}, new SensorRowMapper());
            return sensorsData;
        }
        catch (EmptyResultDataAccessException e) {
            logger.info("getCargoNodeSensorData -- exception caught no results queried");
            return Collections.emptyList();
        }
    }

    @Override
    public List<Sensor> getAllCargoNodesSensorData(){
        logger.info("getAllCargoNodesSensorData for all cargo nodes");
        String query = "SELECT * FROM sensor";
        logger.info("getCargoNodeSensorData -- SELECT SQL: " + query);

        try {
            List<Sensor> sensorsData = jdbcTemplate.query(query, new Object[]{}, new SensorRowMapper());
            return sensorsData;
        }
        catch (EmptyResultDataAccessException e) {
            logger.info("getCargoNodeSensorData -- exception caught no results queried");
            return Collections.emptyList();
        }
    }

    @Override
    public Boolean transferCargoNodeSensorData(Integer cargo_node_id){
        return true;
    }

    @Override
    public Boolean transferAllCargoNodesSensorData(){
        return true;
    }

    /*
    @Override
    public Sensor addCargoNode(Integer cargo_node_id, String sensor_name, String sensor_data, String sensor_data_format, String sensor_status){
        logger.info("addCargoNode");
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
     */

    @Override
    public Boolean deleteCargoNode(Integer cargo_node_id){
        String query = "DELETE FROM cargo WHERE cargo_node_id = ?";
        logger.info("delete all cargo and its sensors for given cargo_node_id"+ cargo_node_id);
        logger.info("delete query :"+ query);

        if (jdbcTemplate.update(query, cargo_node_id) == 0) {
            logger.info("deletion failed for sensor: " + cargo_node_id);
        } else {
            logger.info("deleteCargoNode -- cargo_node_id: " + cargo_node_id + " removed from cargo table");
        }

        logger.info("deleteCargoNode -- deletion complete");
        return true;
    }

    @Override
    public Cargo addCargoNode(String cargo_node_name){
        logger.info("addCargoNode");
        String add_cargo_query = "INSERT INTO cargo(cargo_node_name)" + "VALUES (?)";
        logger.info("addCargoNode -- INSERT SQL: " + add_cargo_query);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int numRows = jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(add_cargo_query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cargo_node_name);
            return ps;
        }, keyHolder);

        if (numRows > 0) {
            logger.info("createCargo -- success");
            Cargo cargo = jdbcTemplate.queryForObject("SELECT * FROM cargo WHERE cargo_node_id = ?",
                    new Object[]{keyHolder.getKey()},
                    new CargoRowMapper());
            return cargo;
        } else {
            logger.error("failed to create new cargo record in the db");
            return null;
        }
    }
}
