package com.example.tidy.database;

public class adz {

    private int id;
    private String rooms;
    private String bathrooms;
    private String flooring;
    private String storeys;
    private String location;
    private String contact;
    private String prices;
    private byte[]img;

    public adz(int id, String rooms, String bathrooms, String flooring, String storeys, String location, String contact, String prices, byte[] img) {
        this.id = id;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.flooring = flooring;
        this.storeys = storeys;
        this.location = location;
        this.contact = contact;
        this.prices = prices;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public String getStoreys() {
        return storeys;
    }

    public void setStoreys(String storeys) {
        this.storeys = storeys;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
