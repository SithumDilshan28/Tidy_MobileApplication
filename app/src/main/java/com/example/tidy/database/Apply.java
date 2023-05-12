package com.example.tidy.database;

public class Apply {
    private String Address;
    private String Price;
    private String Name;

    public Apply(int id, String address, String price, String name) {
        Address = address;
        Price = price;
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
