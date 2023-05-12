package com.example.tidy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class cleaner_Menu extends AppCompatActivity implements View.OnClickListener {

    private CardView viewAdz, reviewAdz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaner_menu);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        }

        viewAdz = findViewById(R.id.viewAdz);
        reviewAdz = findViewById(R.id.review);

        viewAdz.setOnClickListener(this);
        reviewAdz.setOnClickListener(this);

    }

    public void onClick (View view) {

        Intent i;

        switch (view.getId()){

            case R.id.viewAdz:
                i = new Intent(cleaner_Menu.this, viewAdz.class);
                startActivity(i);
                break;

            case R.id.review:
                i = new Intent(cleaner_Menu.this, review_Cleaner.class);
                startActivity(i);
                break;

            default:
                break;
        }

    }

    public void logout_cleaner(View view) {

        Intent intent = new Intent(cleaner_Menu.this,MainPage.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}