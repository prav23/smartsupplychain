package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Sensor;

public interface SensorService {
    Sensor updateSensor(Integer sensor_id, Integer cargo_node_id, String sensor_name, String sensor_data,
                         String sensor_data_format, String sensor_status);

    Sensor addSensor(Integer cargo_node_id, String sensor_name, String sensor_data,
                     String sensor_data_format, String sensor_status);

    Boolean deleteSensor(Integer sensor_id, Integer cargo_node_id);

}
