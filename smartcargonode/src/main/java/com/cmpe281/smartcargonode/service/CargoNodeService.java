package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Sensor;

import java.util.List;

public interface CargoNodeService {
    List<Sensor> getAllSensorData(Integer cargo_node_id);
}

