package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Sensor;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CargoNodeService {
    List<Sensor> getCargoNodeSensorData(Integer cargo_node_id);
    List<Sensor> getAllCargoNodeSensorData(Integer snm_id);
    Map<Integer, List<Integer>> cargoNodeNetworkMap();

    Boolean transferAllCargoNodeSensorData(Integer snm_id);
    Boolean transferAllCargoNodesSensorData();

    Boolean createCargoNode(Integer cargo_node_id, Integer snm_id, String sensor_name, String sensor_data, String sensor_data_format, String sensor_status);
    Boolean updateCargoNode(Integer cargo_node_id, Integer snm_id, String sensor_name, String sensor_data, String sensor_data_format, String sensor_status, Date time_stamp);
    Boolean deleteCargoNode(Integer sensor_id, Integer cargo_node_id);
}

