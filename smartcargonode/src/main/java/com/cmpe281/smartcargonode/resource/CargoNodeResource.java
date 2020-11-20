package com.cmpe281.smartcargonode.resource;

import com.cmpe281.smartcargonode.model.Cargo;
import com.cmpe281.smartcargonode.model.Sensor;
import com.cmpe281.smartcargonode.service.CargoNodeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*
    @PostMapping("/addCargoNode")
    @ApiOperation(value = "Adds a cargo node with default sensor's data",
            notes = "DB query against the 'sensor' table.Returns Cargo Node if addition is successful")
    public Sensor addCargoNode(@ApiParam(value = "cargo_node_id", required = true) @RequestParam Integer cargo_node_id,
                            @ApiParam(value = "sensor_name", required = true) @RequestParam String sensor_name,
                            @ApiParam(value = "sensor_data", required = true) @RequestParam String sensor_data,
                            @ApiParam(value = "sensor_data_format", required = true) @RequestParam String sensor_data_format,
                            @ApiParam(value = "sensor_status", required = true) @RequestParam String sensor_status){
        return cargoNodeService.addCargoNode(cargo_node_id, sensor_name, sensor_data, sensor_data_format, sensor_status);
    }
     */

    @PostMapping("/addCargoNode")
    @ApiOperation(value = "Adds a cargo node with given cargo_node_name",
            notes = "DB query against the 'cargo' table.Returns Cargo Node if addition is successful")
    public Cargo addCargoNode(@ApiParam(value = "cargo_node_name", required = true) @RequestParam String cargo_node_name){
        return cargoNodeService.addCargoNode(cargo_node_name);
    }

    @DeleteMapping("/deleteCargoNode")
    @ApiOperation(value = "Deletes a given CargoNode(all sensors data in that CargoNode gets deleted",
            notes = "DB query against the sensor table. Returns true if deletion is success else returns false")
    public Boolean deleteCargoNode(@ApiParam(value = "cargo_node_id", required = true) @RequestParam Integer cargo_node_id){
        return cargoNodeService.deleteCargoNode(cargo_node_id);
    }

}
