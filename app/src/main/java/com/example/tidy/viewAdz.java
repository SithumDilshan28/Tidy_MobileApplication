package com.example.tidy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.tidy.adapter.ApplyAdapter;
import com.example.tidy.database.adz;
import com.example.tidy.database.dbConnector;

import java.util.ArrayList;

public class viewAdz extends AppCompatActivity {
    dbConnector db;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    ApplyAdapter constructionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_adz);
        recyclerView = findViewById(R.id.rv);
        db = new dbConnector(this);
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    private void displayData() {
        sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Adz", null);
        ArrayList<adz> adds = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String room = cursor.getString(1);
            String bathroom = cursor.getString(2);
            String kitchen = cursor.getString(3);
            String story = cursor.getString(4);
            String flooring = cursor.getString(5);
            String address = cursor.getString(6);
            String price = cursor.getString(7);
            byte[] img = cursor.getBlob(8);


            adds.add(new adz(id, room, bathroom, kitchen, story, flooring, address, price, img));
        }
        cursor.close();
        constructionAdapter = new ApplyAdapter(this, adds, sqLiteDatabase, R.layout.singledatafor_adds);
        recyclerView.setAdapter(constructionAdapter);
    }
}