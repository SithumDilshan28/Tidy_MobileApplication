package com.example.tidy.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tidy.R;
import com.example.tidy.cleanerLogin;
import com.example.tidy.houseOwnerLogin;

public class login extends Fragment {
    Button houseOwner,cleaner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);

        houseOwner=view.findViewById(R.id.button3);
        cleaner=view.findViewById(R.id.button4);

        houseOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), houseOwnerLogin.class);
                startActivity(intent);
            }
        });


        cleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), cleanerLogin.class);
                startActivity(intent);
            }
        });

        return view;

    }
}