package com.example.tidy.database;

public class Rate {
    private int Id;
    private String Name;
    private String Review;

    public Rate(int id, String name, String review) {
        Id = id;
        Name = name;
        Review = review;
    }

    public Rate(String name, String review) {
        Name = name;
        Review = review;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }
}
