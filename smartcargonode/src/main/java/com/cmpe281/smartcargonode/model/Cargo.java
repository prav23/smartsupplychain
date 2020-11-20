package com.cmpe281.smartcargonode.model;

public class Cargo {
    private int cargo_node_id;
    private String cargo_node_name;

    public Cargo(){
    }

    public Cargo(int cargo_node_id, String cargo_node_name) {
        this.cargo_node_id = cargo_node_id;
        this.cargo_node_name = cargo_node_name;
    }

    public int getCargo_node_id(){ return cargo_node_id;}
    public String getCargo_node_name(){return cargo_node_name;}

    public void setCargo_node_id(int cargo_node_id) {this.cargo_node_id = cargo_node_id;}
    public void setCargo_node_name(String cargo_node_name) {this.cargo_node_name = cargo_node_name;}

}
