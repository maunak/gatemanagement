package com.example.gate;

public class entryData {
    private String name, phoneNumber, detail, vehicleNumber, block, entryTime;

    public entryData() {
    }

    public entryData(String name, String phoneNumber, String detail, String vehicleNumber, String block, String entryTime) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.detail = detail;
        this.vehicleNumber = vehicleNumber;
        this.block = block;
        this.entryTime = entryTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }
}
