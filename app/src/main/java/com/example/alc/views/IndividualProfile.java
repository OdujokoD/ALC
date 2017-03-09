package com.example.alc.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.alc.R;

public class IndividualProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_profile);

        Intent intent = getIntent();
        Log.d("User name", intent.getStringExtra("User name"));
        Log.d("Picture", intent.getStringExtra("Profile photo"));
        Log.d("Profile URL", intent.getStringExtra("Profile URL"));
    }
}
