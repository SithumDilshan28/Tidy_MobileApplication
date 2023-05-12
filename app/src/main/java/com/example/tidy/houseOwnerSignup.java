package com.example.tidy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.tidy.database.dataHandler;
import com.example.tidy.database.houseOwner;
import com.google.android.material.textfield.TextInputLayout;

public class houseOwnerSignup extends AppCompatActivity {

    TextInputLayout fullName,Nic,Address,Mobile,Email,Password,Confirm_Password;
    dataHandler dataHandler = new dataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_owner_signup);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        }

        fullName = findViewById(R.id.FullName);
        Nic = findViewById(R.id.NIC);
        Address = findViewById(R.id.Address);
        Mobile = findViewById(R.id.Mobile);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Confirm_Password = findViewById(R.id.Confirm_Password);

        dataHandler.openDB();

    }

    //name validation
    private boolean validName() {
        String fname = fullName.getEditText().getText().toString().trim();


        if (fname.isEmpty()) {
            fullName.setError("Name is Empty.");
            return false;
        }  else {
            fullName.setError(null);
            return true;
        }

    }

    //nic validation
    private boolean validNic() {
        String nic = Nic.getEditText().getText().toString().trim();

        if (nic.isEmpty()) {
            Nic.setError("Nic is Empty.");
            return false;
        } else {
            Nic.setError(null);
            return true;
        }

    }

    //Address validation
    private boolean validAddress() {
        String address = Address.getEditText().getText().toString().trim();

        if (address.isEmpty()) {
            Address.setError("Address is Empty.");
            return false;
        } else {
            Address.setError(null);
            return true;
        }

    }

    //Mobile validation
    private boolean validMobile() {
        String mobile = Mobile.getEditText().getText().toString().trim();

        if (mobile.isEmpty()) {
            Mobile.setError("Mobile is Empty.");
            return false;
        } else {
            Mobile.setError(null);
            return true;
        }

    }


    //Email validation
    private boolean validEmail() {
        String email = Email.getEditText().getText().toString().trim();

        if (email.isEmpty()) {
            Email.setError("Email is Empty.");
            return false;
        } else {
            Email.setError(null);
            return true;
        }

    }


    //password validation
    private boolean validPassword() {
        String pass = Password.getEditText().getText().toString().trim();
        String cpass = Confirm_Password.getEditText().getText().toString().trim();


        if (pass.isEmpty()) {
            Password.setError("Password is Empty.");
            return false;
        } else if (!pass.matches(cpass)) {
            Password.setError("Please Use same Password");
            return false;
        } else {
            Password.setError(null);
            return true;
        }

    }

    //confirm password validation
    private boolean validCPassword() {
        String cpass = Confirm_Password.getEditText().getText().toString().trim();
        String pass = Password.getEditText().getText().toString().trim();

        if (cpass.isEmpty()) {
            Confirm_Password.setError("Confirm Password is Empty.");
            return false;
        } else if (!pass.matches(cpass)) {
            Confirm_Password.setError("Please Use same Password");
            return false;
        } else {
            Confirm_Password.setError(null);
            return true;
        }

    }

    public void houseOwner (View view) {
        String Name = fullName.getEditText().getText().toString().trim();
        String nic = Nic.getEditText().getText().toString().trim();
        String address = Address.getEditText().getText().toString().trim();
        String mobile = Mobile.getEditText().getText().toString().trim();
        String email = Email.getEditText().getText().toString().trim();
        String password = Password.getEditText().getText().toString().trim();
        String C_Password = Confirm_Password.getEditText().getText().toString().trim();

        if (!validEmail() |!validName() | !validNic() | !validAddress () | !validMobile()  | !validPassword() | !validCPassword()) {
            return;
        }


        houseOwner houseOwner = new houseOwner (Name, nic, address, mobile, email, password,C_Password);

        try {
            dataHandler.HouseOwner_Create(houseOwner);
            Toast.makeText(getApplicationContext(), "Successfully Registered.", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(houseOwnerSignup.this,houseOwnerLogin.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }
    }

}

