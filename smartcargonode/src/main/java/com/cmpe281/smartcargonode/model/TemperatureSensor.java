package com.cmpe281.smartcargonode.model;

import java.sql.Timestamp;

public class TemperatureSensor extends Sensor{

    public TemperatureSensor(int sensor_id, int cargo_node_id, String sensor_name, String sensor_data,
                             String sensor_data_format, String sensor_status, Timestamp time_stamp){
        super(sensor_id, cargo_node_id, sensor_name, sensor_data, sensor_data_format, sensor_status, time_stamp);
    }

}
