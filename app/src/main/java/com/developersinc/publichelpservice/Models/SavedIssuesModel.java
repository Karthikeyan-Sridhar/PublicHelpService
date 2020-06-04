package com.developersinc.publichelpservice.Models;

public class SavedIssuesModel {

    public String address,description,lattitude,longitude,category;

    public SavedIssuesModel(){

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSlots() {
        return category;
    }

    public void setSlots(String category) {
        this.category = category;
    }
}
