package com.cmpe281.smartcargonode.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

@Service
public class SensorServiceImpl implements SensorService{
    private static final Logger logger = LogManager.getLogger(SensorServiceImpl.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean updateSensor(Integer sensor_id, Integer cargo_node_id, Integer snm_id, String sensor_name, String sensor_data,
                                String sensor_data_format, String sensor_status, Date time_stamp){
        logger.info("updateSensorStatus for given sensor_id: " + sensor_id);

        String update_sensor_query = "UPDATE sensor set cargo_node_id = ?, sensor_name = ?, sensor_data = ?, sensor_data_format = ?, sensor_status = ?, time_stamp = ? where sensor_id = ?";
        int update_status = jdbcTemplate.update(update_sensor_query, cargo_node_id, sensor_name, sensor_data, sensor_data_format, sensor_status, time_stamp, sensor_id);
        if(update_status !=0){
            logger.info("updated sensor table with query " + update_sensor_query);
        }
        else{
            logger.info("update sensor status failed for query" + update_sensor_query);
            return false;
        }
        return true;
    }

    @Override
    public Boolean addSensor(Integer cargo_node_id, String sensor_name, String sensor_data,
                                String sensor_data_format, String sensor_status){
        logger.info("addSensor");
        String add_sensor_query = "INSERT INTO sensor(cargo_node_id, sensor_name, sensor_data, sensor_data_format, sensor_status)" +
                "VALUES (?, ?, ?, ?, ?)";
        logger.info("addSensor -- INSERT SQL: " + add_sensor_query);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        Date createdDate = new Date(System.currentTimeMillis());
        int numRows = jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(add_sensor_query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cargo_node_id);
            ps.setString(2, sensor_name);
            ps.setString(3, sensor_data);
            ps.setString(4, sensor_data_format);
            ps.setString(5, sensor_status);
           ps.setDate(6, (java.sql.Date) createdDate);
            return ps;
        }, keyHolder);

        if (numRows > 0) {
            logger.info("createSensor -- success");
            /*
            Sensor sensor = jdbcTemplate.queryForObject("SELECT * FROM sensor WHERE sensor_id = ?",
                    new Object[]{keyHolder.getKey()},
                    new SensorRowMapper());
            return sensor;
            or create an entity here
            */
            return true;
        } else {
            logger.error("failed to create new sensor record in the db");
            //return null;
            return false;
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

