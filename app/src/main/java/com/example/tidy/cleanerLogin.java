package com.example.tidy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tidy.database.dataHandler;
import com.google.android.material.textfield.TextInputLayout;

public class cleanerLogin extends AppCompatActivity {

    TextView Signup;

    TextInputLayout email,password;
    com.example.tidy.database.dataHandler dataHandler = new dataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaner_login);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

        Signup=findViewById(R.id.textView5);

        email=findViewById(R.id.Username);

        password=findViewById(R.id.password);

        dataHandler.openDB();


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cleanerLogin.this, cleanerSignup.class);
                startActivity(intent);
            }
        });

    }

    //Email validation
    private boolean validEmail() {
        String Email = email.getEditText().getText().toString().trim();


        if (Email.isEmpty()) {
            email.setError("Email is Empty.");
            return false;
        }  else {
            email.setError(null);
            return true;
        }

    }

    //Password validation
    private boolean validPassword() {
        String Password = password.getEditText().getText().toString().trim();

        if (Password.isEmpty()) {
            password.setError("Password is Empty.");
            return false;
        } else {
            password.setError(null);
            return true;
        }

    }

    public void cleaner_Login (View view){

        String Email = email.getEditText().getText().toString().trim();
        String Password = password.getEditText().getText().toString().trim();

        if (!validEmail()  | !validPassword() ) {
            return;
        }

        Boolean checkLoginCleaner = dataHandler.checkLoginCleaner(Email, Password);
        if (checkLoginCleaner == true) {
            Toast.makeText(getApplicationContext(), "Logging Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(cleanerLogin.this, cleaner_Menu.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Logging Failed.", Toast.LENGTH_SHORT).show();
        }
    }
}