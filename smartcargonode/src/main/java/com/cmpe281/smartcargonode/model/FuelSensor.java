package com.cmpe281.smartcargonode.model;

import java.util.Date;

public class FuelSensor extends Sensor{

    public FuelSensor(int sensor_id, int cargo_node_id, int snm_id, String sensor_name, String sensor_data,
                             String sensor_data_format, String sensor_status, Date time_stamp){
        super(sensor_id, cargo_node_id, snm_id, sensor_name, sensor_data, sensor_data_format, sensor_status, time_stamp);
    }

}
