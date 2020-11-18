package com.cmpe281.smartcargonode.resource;

import com.cmpe281.smartcargonode.model.Sensor;
import com.cmpe281.smartcargonode.service.CargoNodeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/collectAllCargoNodesSensorData")
    @ApiOperation(value = "Fetches all sensors data for the given snm_id",
            notes = "DB query against the 'sensor' table",
            response = Sensor.class, responseContainer = "List")
    public List<Sensor> getAllCargoNodeSensorData(@ApiParam(value = "the snm_id to search for sensor data", required = true) @RequestParam Integer snm_id ) {
        logger.info("CargoNodeResource::getCargoNodeSensorData() -- fetching all sensors for given cargo_node_id: " + snm_id);
        return cargoNodeService.getAllCargoNodeSensorData(snm_id);
    }

    @GetMapping("/cargoNodeNetworkMap")
    @ApiOperation(value = "Fetches map of snm_id and cargo_node_id",
            notes = "DB query against the 'sensor' table")
    public Map<Integer, List<Integer>> cargoNodeNetworkMap(){
        return cargoNodeService.cargoNodeNetworkMap();
    }

    @GetMapping("/transferCargoNodeSensorData")
    @ApiOperation(value = "transferring all cargo nodes data for given snm_id",
            notes = "DB query against the backend cloud database")
    public Boolean transferAllCargoNodeSensorData(@ApiParam(value = "the snm_id to search for cargo nodes sensor data", required = true) @RequestParam Integer snm_id ) {
        logger.info("CargoNodeResource::transferAllCargoNodeSensorData() -- transferring all cargo nodes data for given snm_id: " + snm_id);
        return cargoNodeService.transferAllCargoNodeSensorData(snm_id);
    }

    @GetMapping("/transferCargoNodesSensorData")
    @ApiOperation(value = "Transfers all sensors data for all cargo nodes",
            notes = "DB query against the backend cloud database")
    public Boolean transferAllCargoNodesSensorData() {
        logger.info("CargoNodeResource::getAllCargoNodesSensorData() -- fetching all sensors data for all cargoNodes");
        return cargoNodeService.transferAllCargoNodesSensorData();
    }

    @PostMapping("/createCargoNode")
    @ApiOperation(value = "Adds a new cargo node with default sensor",
            notes = "DB query against the 'sensor' table.Returns true if addition is success else returns false")
    public Boolean createCargoNode(@ApiParam(value = "cargo_node_id", required = true) @RequestParam Integer cargo_node_id,
                                   @ApiParam(value = "snm_id", required = true) @RequestParam Integer snm_id,
                                    @ApiParam(value = "sensor_name", required = true) @RequestParam String sensor_name,
                                    @ApiParam(value = "sensor_data", required = true) @RequestParam String sensor_data,
                                    @ApiParam(value = "sensor_data_format", required = true) @RequestParam String sensor_data_format,
                                    @ApiParam(value = "sensor_status", required = true) @RequestParam String sensor_status)
    {
        return cargoNodeService.createCargoNode(cargo_node_id, snm_id, sensor_name, sensor_data, sensor_data_format, sensor_status);
    }

    @PutMapping("/updateCargoNode")
    @ApiOperation(value = "Updates a given sensor information in table",
            notes = "DB query against the 'sensor' table. Returns true if update success else returns false")
    public Boolean updateCargoNode(@ApiParam(value = "cargo_node_id", required = true) @RequestParam Integer cargo_node_id,
                                @ApiParam(value = "snm_id", required = true) @RequestParam Integer snm_id,
                                @ApiParam(value = "sensor_name", required = true) @RequestParam String sensor_name,
                                @ApiParam(value = "sensor_data", required = true) @RequestParam String sensor_data,
                                @ApiParam(value = "sensor_data_format", required = true) @RequestParam String sensor_data_format,
                                @ApiParam(value = "sensor_status", required = true) @RequestParam String sensor_status,
                                @ApiParam(value = "time_stamp", required = true) @RequestParam Date time_stamp) {
        return cargoNodeService.updateCargoNode(cargo_node_id, snm_id, sensor_name, sensor_data, sensor_data_format, sensor_status, time_stamp);
    }

    @DeleteMapping("/deleteCargoNode")
    @ApiOperation(value = "Deletes a given CargoNode and all sensors associated with it",
            notes = "DB query against the sensor table. Returns true if deletion is success else returns false")
    public Boolean deleteCargoNode(@ApiParam(value = "sensorId", required = true) @RequestParam Integer sensor_id,
                                @ApiParam(value = "cargo_node_id", required = true) @RequestParam Integer cargo_node_id){
        return cargoNodeService.deleteCargoNode(sensor_id, cargo_node_id);
    }

}
