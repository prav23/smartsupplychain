package com.cmpe281.smartcargonode.model;

public class Project {
    private int projId;
    private String title;
    private String description;
    private String ownerId;

    public int getProjId(){
        return projId;
    }
    public void setProjId(int projId){
        this.projId = projId;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String  getOwnerId(){
        return ownerId;
    }
    public void setOwnerId(String ownerId){
        this.ownerId = ownerId;
    }
}
