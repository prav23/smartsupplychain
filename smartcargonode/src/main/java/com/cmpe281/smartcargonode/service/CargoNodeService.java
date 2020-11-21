package com.cmpe281.smartcargonode.service;

import com.cmpe281.smartcargonode.model.Cargo;
import com.cmpe281.smartcargonode.model.Sensor;

import java.util.List;

public interface CargoNodeService {
    List<Sensor> getCargoNodeSensorData(Integer cargo_node_id);
    List<Sensor> getAllCargoNodesSensorData();
    Boolean transferCargoNodeSensorData(Integer cargo_node_id);
    Boolean transferAllCargoNodesSensorData();

    //Sensor addCargoNode(Integer cargo_node_id, String sensor_name, String sensor_data, String sensor_data_format, String sensor_status);

    Boolean deleteCargoNode(Integer cargo_node_id);

    Cargo addCargoNode(String cargo_node_name);

    List<Cargo> getAllCargoNodesList();

}

