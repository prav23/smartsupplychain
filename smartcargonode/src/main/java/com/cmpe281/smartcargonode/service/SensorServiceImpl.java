package com.cmpe281.smartcargonode.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService{
    private static final Logger logger = LogManager.getLogger(ProjectServiceImpl.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean updateSensorStatus(Integer sensor_id, String sensor_status){
        logger.info("updateSensorStatus for given sensor_id with status: " + sensor_status);

        String update_sensor_query = "UPDATE sensor set sensor_status = ? where sensor_id = ?";
        int update_status = jdbcTemplate.update(update_sensor_query, sensor_id, sensor_status);
        if(update_status !=0){
            logger.info("updated sensor table with query " + update_sensor_query);
        }
        else{
            logger.info("update sensor status failed for query" + update_sensor_query);
            return false;
        }
        return true;
    }
}
