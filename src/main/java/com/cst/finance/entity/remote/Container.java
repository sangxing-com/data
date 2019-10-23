package com.cst.finance.entity.remote;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Container")
public class Container {

    @Id
    private String id;
    @Field("ContainerID")
    private String ContainerID;
    @Field("Image")
    private String Image;
    @Field("Command")
    private String Command;
    @Field("Created")
    private String Created;
    @Field("Status")
    private String Status;
    @Field("Ports")
    private String Ports;
    @Field("Names")
    private String Names;

    public String getContainerID() {
        return ContainerID;
    }

    public void setContainerID(String containerID) {
        ContainerID = containerID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getPorts() {
        return Ports;
    }

    public void setPorts(String ports) {
        Ports = ports;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }
}
