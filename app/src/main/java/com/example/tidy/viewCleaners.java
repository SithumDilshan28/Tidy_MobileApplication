package com.example.tidy;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tidy.adapter.CleanerAdapter;
import com.example.tidy.database.cleaner;
import com.example.tidy.database.dbConnector;

import java.util.ArrayList;

public class viewCleaners extends AppCompatActivity {

    dbConnector db;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    CleanerAdapter cleanerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cleaners);
        recyclerView = findViewById(R.id.rv);
        db = new dbConnector(this);
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void displayData() {
        sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM cleaner", null);
        ArrayList<cleaner> workers = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id=cursor.getInt(0);
            String name = cursor.getString(1);
            String number = cursor.getString(2);
            String address = cursor.getString(3);
            String nic = cursor.getString(4);
            String email = cursor.getString(5);
            String password = cursor.getString(6);
            String c_passowrd = cursor.getString(7);


            workers.add(new cleaner( id,name,number,address, nic,email,password,c_passowrd));
        }
        cursor.close();
        cleanerAdapter = new CleanerAdapter(this, R.layout.singledatafor_cleaners, workers, sqLiteDatabase);
        recyclerView.setAdapter(cleanerAdapter);
    }
}