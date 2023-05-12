package com.example.tidy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tidy.database.Apply;
import com.example.tidy.database.dataHandler;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class applyJob extends AppCompatActivity {
    TextView address, price;
    TextInputLayout name;
    TextInputEditText editname;

    dataHandler dataHandler=new dataHandler(this);
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job);
        address = findViewById(R.id.address);
        price = findViewById(R.id.price);
        name = findViewById(R.id.name);
        editname=findViewById(R.id.editname);
        editData();

        //database
        dataHandler.openDB();
    }

    private void editData() {
        if (getIntent().getBundleExtra("userdata") != null) {
            Bundle bundle = getIntent().getBundleExtra("userdata");
            address.setText(bundle.getString("address"));
            price.setText(bundle.getString("price"));
        }
    }


    //name validation
    private boolean validName() {
        String Name = name.getEditText().getText().toString().trim();


        if (Name.isEmpty()) {
            name.setError("Name is Empty.");
            return false;
        } else {
            name.setError(null);
            return true;
        }

    }

    public void applyJob(View v) {
        String Address = address.getText().toString().trim();
        String Price = price.getText().toString().trim();
        String Name = name.getEditText().getText().toString().trim();

        if (!validName()) {
            return;
        }

        Apply apply = new Apply(id, Address, Price,Name);
        try {
            dataHandler.ApplyJob_Create(apply);
            Toast.makeText(getApplicationContext(), "Apply Submitted.", Toast.LENGTH_SHORT).show();
            editname.setText("");
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }
    }

}