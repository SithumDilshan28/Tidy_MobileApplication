package com.example.tidy;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tidy.adapter.ViewApplyAdapter;
import com.example.tidy.database.Apply;
import com.example.tidy.database.dbConnector;

import java.util.ArrayList;

public class requests extends AppCompatActivity {

    dbConnector db;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    ViewApplyAdapter constructionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        recyclerView = findViewById(R.id.rv);
        db = new dbConnector(this);
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    private void displayData() {
        sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from ApplyJob", null);
        ArrayList<Apply> adds = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String address = cursor.getString(1);
            String price = cursor.getString(2);
            String name = cursor.getString(3);

            adds.add(new Apply(id,address, price, name));
        }
        cursor.close();
        constructionAdapter = new ViewApplyAdapter(this, adds, sqLiteDatabase, R.layout.singledatafor_applyjob);
        recyclerView.setAdapter(constructionAdapter);
    }

    public void confirm(View view){
        Toast.makeText(getApplicationContext(),"Request Confirmed",Toast.LENGTH_SHORT).show();
    }
}