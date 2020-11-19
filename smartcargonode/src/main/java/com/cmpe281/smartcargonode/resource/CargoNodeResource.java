package com.cmpe281.smartcargonode.resource;

import com.cmpe281.smartcargonode.model.Sensor;
import com.cmpe281.smartcargonode.service.CargoNodeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/CargoNode")
public class CargoNodeResource {

    private static final Logger logger = LogManager.getLogger(CargoNodeResource.class);
    private CargoNodeService cargoNodeService;

    @Autowired
    public void setCargoNodeService(CargoNodeService cargoNodeService) {
        this.cargoNodeService = cargoNodeService;
    }

    @GetMapping("/collectCargoNodeSensorData")
    @ApiOperation(value = "Fetches all sensors data for the given cargo node id",
            notes = "DB query against the 'sensor' table",
            response = Sensor.class, responseContainer = "List")
    public List<Sensor> getCargoNodeSensorData(@ApiParam(value = "the cargo node id to search for sensor data", required = true) @RequestParam Integer cargo_node_id ) {
        logger.info("CargoNodeResource::getCargoNodeSensorData() -- fetching all sensors for given cargo_node_id: " + cargo_node_id);
        return cargoNodeService.getCargoNodeSensorData(cargo_node_id);
    }

    @GetMapping("/collectCargoNodesSensorData")
    @ApiOperation(value = "Fetches all sensors data for all cargo nodes",
            notes = "DB query against the 'sensor' table",
            response = Sensor.class, responseContainer = "List")
    public List<Sensor> getAllCargoNodesSensorData() {
        logger.info("CargoNodeResource::getAllCargoNodesSensorData() -- fetching all sensors data");
        return cargoNodeService.getAllCargoNodesSensorData();
    }

    @GetMapping("/transferCargoNodeSensorData")
    @ApiOperation(value = "Transfers all sensors data for the given cargo node id",
            notes = "DB query against the backend cloud database")
    public Boolean transferCargoNodeSensorData(@ApiParam(value = "the cargo node id to search for sensor data", required = true) @RequestParam Integer cargo_node_id ) {
        logger.info("CargoNodeResource::getCargoNodeSensorData() -- fetching all sensors for given cargo_node_id: " + cargo_node_id);
        return cargoNodeService.transferCargoNodeSensorData(cargo_node_id);
    }

    @GetMapping("/transferCargoNodesSensorData")
    @ApiOperation(value = "Transfers all sensors data for all cargo nodes",
            notes = "DB query against the backend cloud database",
            response = Sensor.class, responseContainer = "List")
    public Boolean transferAllCargoNodesSensorData() {
        logger.info("CargoNodeResource::getAllCargoNodesSensorData() -- fetching all sensors data");
        return cargoNodeService.transferAllCargoNodesSensorData();
    }


}
