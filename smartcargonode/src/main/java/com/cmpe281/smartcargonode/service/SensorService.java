package com.cmpe281.smartcargonode.service;

import java.util.Date;

public interface SensorService {
    Boolean updateSensor(Integer sensor_id, Integer cargo_node_id, Integer snm_id, String sensor_name, String sensor_data,
                         String sensor_data_format, String sensor_status, Date time_stamp);

    Boolean addSensor(Integer cargo_node_id, String sensor_name, String sensor_data,
                      String sensor_data_format, String sensor_status);

    Boolean deleteSensor(Integer sensor_id, Integer cargo_node_id);

}
