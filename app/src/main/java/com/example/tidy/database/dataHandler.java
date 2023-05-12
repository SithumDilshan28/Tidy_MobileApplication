package com.example.tidy.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.ByteArrayOutputStream;

public class dataHandler {

    private Context con;
    private dbConnector dbCon;
    private SQLiteDatabase db;
    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInBytes;

    public dataHandler(Context con) {
        this.con = con;
    }

    public void openDB() {
        this.dbCon = new dbConnector(con);
        this.db = dbCon.getWritableDatabase();
    }

    //HouseOwner
    public void HouseOwner_Create(houseOwner houseOwner) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("FullName", houseOwner.getFullName());
        contentValues.put("NIC", houseOwner.getNIC());
        contentValues.put("Address", houseOwner.getAddress());
        contentValues.put("Mobile", houseOwner.getMobile());
        contentValues.put("Email", houseOwner.getEmail());
        contentValues.put("Password", houseOwner.getPassword());
        contentValues.put("Confirm_Password", houseOwner.getConfirm_Password());
        db.insert("HouseOwner", null, contentValues);
    }

    //Cleaner
    public void Cleaner_Create(cleaner cleaner) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("FullName", cleaner.getFullName());
        contentValues.put("NIC", cleaner.getNIC());
        contentValues.put("Address", cleaner.getAddress());
        contentValues.put("Mobile", cleaner.getMobile());
        contentValues.put("Email", cleaner.getEmail());
        contentValues.put("Password", cleaner.getPassword());
        contentValues.put("Confirm_Password", cleaner.getConfirm_Password());
        db.insert("cleaner", null, contentValues);
    }


    //Review Ads
    public void Review_Create(Rate rate) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", rate.getName());
        contentValues.put("Review", rate.getReview());
        db.insert("Review", null, contentValues);
    }

    //Apply Job
    public void ApplyJob_Create(Apply apply) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Address", apply.getAddress());
        contentValues.put("Price", apply.getPrice());
        contentValues.put("Name", apply.getName());
        db.insert("ApplyJob", null, contentValues);
    }

    //Review Cleaner
    public void AddReview_Create(AddReview rate) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Review", rate.getReview());
        db.insert("AddReview", null, contentValues);
    }

    //Check Login Record Database Customer
    public boolean checkLogin(String email, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM HouseOwner  WHERE Email=? and Password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //Check Login Record Database Customer
    public boolean checkLoginCleaner(String email, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM cleaner  WHERE Email=? and Password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
