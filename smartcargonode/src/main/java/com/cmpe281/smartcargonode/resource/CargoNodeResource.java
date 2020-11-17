package com.cmpe281.smartcargonode.resource;

import com.cmpe281.smartcargonode.model.Project;
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

    @GetMapping("/collectSensorData")
    @ApiOperation(value = "Fetches all sensors data for the five cargo node id",
            notes = "DB query against the 'sensor' table",
            response = Project.class, responseContainer = "List")
    public List<Sensor> getAllSensorData(@ApiParam(value = "the cargon node id to search for sensor data", required = true) @RequestParam Integer cargo_node_id ) {
        logger.info("CargoNodeResource::getAllSensorData() -- fetching all sensors for given cargo_node_id: " + cargo_node_id);
        return cargoNodeService.getAllSensorData(cargo_node_id);
    }
}
