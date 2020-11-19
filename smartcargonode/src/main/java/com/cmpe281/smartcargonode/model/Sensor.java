package com.cmpe281.smartcargonode.model;

import java.sql.Timestamp;
import java.util.Date;

public class Sensor {
    private int sensor_id;
    private int cargo_node_id;
    private String sensor_name;
    private String sensor_data;
    private String sensor_data_format;
    private String sensor_status;
    private Timestamp time_stamp;

    public Sensor(){
    }

    public Sensor(int sensor_id, int cargo_node_id, String sensor_name, String sensor_data,
                  String sensor_data_format, String sensor_status, Timestamp time_stamp){
        this.sensor_id = sensor_id;
        this.cargo_node_id = cargo_node_id;
        this.sensor_name = sensor_name;
        this.sensor_data = sensor_data;
        this.sensor_data_format = sensor_data_format;
        this.sensor_status = sensor_status;
        this.time_stamp = time_stamp;
    }

    public int getSensor_id() { return sensor_id; }
    public int getCargo_node_id(){ return cargo_node_id;  }
    public String getSensor_name(){ return sensor_name;}
    public String getSensor_data(){ return sensor_data;}
    public String getSensor_data_format() {return sensor_data_format;}
    public String getSensor_status(){ return sensor_status;}
    public Date getTime_stamp(){ return time_stamp;}

    public void setSensor_id(int sensor_id) { this.sensor_id = sensor_id;}
    public void setCargo_node_id(int cargo_node_id) {this.cargo_node_id = cargo_node_id;}
    public void setSensor_name(String sensor_name){ this.sensor_name = sensor_name;}
    public void setSensor_data(String sensor_data){ this.sensor_data = sensor_data;}
    public void setSensor_data_format(String sensor_data_format){ this.sensor_data_format = sensor_data_format;}
    public void setSensor_status(String sensor_status){ this.sensor_status = sensor_status;}
    public void setTime_stamp(Timestamp time_stamp){ this.time_stamp = time_stamp;}
}
