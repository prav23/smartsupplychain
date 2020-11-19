package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Sensor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<Sensor> sensorList = new ArrayList<>();
        // Simulate sensor values at random here with latest time_stamp and update in sql table and send to backend cloud
        //String update_sensor_query = "UPDATE sensor set sensor_status = ? where sensor_id = ?";
        /*
        int update_status = jdbcTemplate.update(update_sensor_query, sensor_id, sensor_status);
        if(update_status !=0){
            logger.info("updated sensor table with query " + update_sensor_query);
        }
        else{
            logger.info("update sensor status failed for query" + update_sensor_query);
            return false;
        }
        */
        return sensorList;
    }

    @Override
    public List<Sensor> getAllCargoNodesSensorData(){
        logger.info("getAllCargoNodesSensorData for all cargo nodes");

        List<Sensor> sensorList = new ArrayList<>();
        // Simulate sensor values at random here with latest time_stamp and update in sql table and send to backend cloud
        //String update_sensor_query = "UPDATE sensor set sensor_status = ? where sensor_id = ?";
        /*
        int update_status = jdbcTemplate.update(update_sensor_query, sensor_id, sensor_status);
        if(update_status !=0){
            logger.info("updated sensor table with query " + update_sensor_query);
        }
        else{
            logger.info("update sensor status failed for query" + update_sensor_query);
            return false;
        }
        */
        return sensorList;
    }

    @Override
    public Boolean transferCargoNodeSensorData(Integer cargo_node_id){
        return true;
    }

    @Override
    public Boolean transferAllCargoNodesSensorData(){
        return true;
    }


}
