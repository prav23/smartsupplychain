package com.cmpe281.smartcargonode.resource;

import com.cmpe281.smartcargonode.service.SensorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(value = "Updates a given sensor",
            notes = "DB query against the 'sensor' table. Returns true if update success else returns false")
    public Boolean updateSensorStatus(@ApiParam(value = "sensorId", required = true) @RequestParam Integer sensor_id,
                                     @ApiParam(value = "sensor_status", required = true) @RequestParam String sensor_status) {
        return sensorService.updateSensorStatus(sensor_id, sensor_status);
    }
}
