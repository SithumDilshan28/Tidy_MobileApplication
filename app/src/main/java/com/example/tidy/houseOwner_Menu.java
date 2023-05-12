package com.example.tidy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.tidy.fragments.login;

public class houseOwner_Menu extends AppCompatActivity implements View.OnClickListener {

    private CardView addAdz, viewCleaner, requests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_owner_menu);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        }

        addAdz = findViewById(R.id.addAdz);
        viewCleaner = findViewById(R.id.cleaners);
        requests = findViewById(R.id.request);

        addAdz.setOnClickListener(this);
        viewCleaner.setOnClickListener(this);
        requests.setOnClickListener(this);

    }

    public void onClick (View view) {

        Intent i;

        switch (view.getId()){

            case R.id.addAdz:
                i = new Intent(houseOwner_Menu.this, addAdz.class);
                startActivity(i);
                break;

            case R.id.cleaners:
                i = new Intent(houseOwner_Menu.this, viewCleaners.class);
                startActivity(i);
                break;
            case R.id.request:
                i = new Intent(houseOwner_Menu.this, requests.class);
                startActivity(i);
                break;

            default:
                break;
        }

        }

    public void logout_houseOwner(View view) {

        Intent intent = new Intent(houseOwner_Menu.this,MainPage.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {

    }

}
