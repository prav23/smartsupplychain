package com.cmpe281.smartcargonode.resource;

import com.cmpe281.smartcargonode.service.SensorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/sensor")
public class SensorResource {

    private static final Logger logger = LogManager.getLogger(SensorResource.class);
    private SensorService sensorService;

    @Autowired
    public void setSensorService(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PutMapping("/updateSensor")
    @ApiOperation(value = "Updates a given sensor information in table",
            notes = "DB query against the 'sensor' table. Returns true if update success else returns false")
    public Boolean updateSensor(@ApiParam(value = "sensorId", required = true) @RequestParam Integer sensor_id,
                                @ApiParam(value = "cargo_node_id", required = true) @RequestParam Integer cargo_node_id,
                               @ApiParam(value = "snm_id", required = true) @RequestParam Integer snm_id,
                              @ApiParam(value = "sensor_name", required = true) @RequestParam String sensor_name,
                              @ApiParam(value = "sensor_data", required = true) @RequestParam String sensor_data,
                              @ApiParam(value = "sensor_data_format", required = true) @RequestParam String sensor_data_format,
                              @ApiParam(value = "sensor_status", required = true) @RequestParam String sensor_status,
                              @ApiParam(value = "time_stamp", required = true) @RequestParam Date time_stamp) {
        return sensorService.updateSensor(sensor_id, cargo_node_id, snm_id, sensor_name, sensor_data, sensor_data_format, sensor_status, time_stamp);
    }

    @PostMapping("/addSensor")
    @ApiOperation(value = "Adds a sensor to a cargo node",
            notes = "DB query against the 'sensor' table.Returns true if addition is success else returns false")
    public Boolean addSensor(@ApiParam(value = "cargo_node_id", required = true) @RequestParam Integer cargo_node_id,
                             @ApiParam(value = "sensor_name", required = true) @RequestParam String sensor_name,
                             @ApiParam(value = "sensor_data", required = true) @RequestParam String sensor_data,
                             @ApiParam(value = "sensor_data_format", required = true) @RequestParam String sensor_data_format,
                             @ApiParam(value = "sensor_status", required = true) @RequestParam String sensor_status){
        return sensorService.addSensor(cargo_node_id, sensor_name, sensor_data, sensor_data_format, sensor_status);
    }

    @DeleteMapping("/deleteSensor")
    @ApiOperation(value = "Deletes a given sensor",
                notes = "DB query against the sensor table. Returns true if deletion is success else returns false")
    public Boolean deleteSensor(@ApiParam(value = "sensorId", required = true) @RequestParam Integer sensor_id,
                                @ApiParam(value = "cargo_node_id", required = true) @RequestParam Integer cargo_node_id){
        return sensorService.deleteSensor(sensor_id, cargo_node_id);
    }
}
