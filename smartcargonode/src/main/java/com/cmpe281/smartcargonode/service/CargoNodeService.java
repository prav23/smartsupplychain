package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Sensor;

import java.util.List;

public interface CargoNodeService {
    List<Sensor> getCargoNodeSensorData(Integer cargo_node_id);
    List<Sensor> getAllCargoNodesSensorData();
    Boolean transferCargoNodeSensorData(Integer cargo_node_id);
    Boolean transferAllCargoNodesSensorData();
}

