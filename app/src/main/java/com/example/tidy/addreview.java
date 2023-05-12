package com.example.tidy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tidy.database.Rate;
import com.example.tidy.database.dataHandler;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class addreview extends AppCompatActivity {
    TextView name;
    TextInputLayout review;
    TextInputEditText editreview;
    dataHandler dataHandler= new dataHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addreview);
        name = findViewById(R.id.name);
        review = findViewById(R.id.review);
        editreview=findViewById(R.id.editreview);
        editData();

        //database
        dataHandler.openDB();
    }

    private void editData() {
        if (getIntent().getBundleExtra("userdata") != null) {
            Bundle bundle = getIntent().getBundleExtra("userdata");
            name.setText(bundle.getString("name"));
        }
    }


    public void add_review(View view){
        String Name = name.getText().toString();
        String Review = review.getEditText().getText().toString().trim();


        if (!validReview()) {
            return;
        }


        Rate rate = new Rate(Name, Review);
        try {
            dataHandler.Review_Create(rate);
            Toast.makeText(getApplicationContext(), "Review Submitted.", Toast.LENGTH_SHORT).show();
            editreview.setText("");
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }
    }

    //nic validation
    private boolean validReview() {
        String Review = review.getEditText().getText().toString().trim();

        if (Review.isEmpty()) {
            review.setError("Review is Empty.");
            return false;
        } else {
            review.setError(null);
            return true;
        }

    }
}