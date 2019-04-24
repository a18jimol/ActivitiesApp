package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MountainDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountaindetails);

        Intent intent = getIntent();
        String mountain1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView headerView = findViewById(R.id.textView15);
        headerView.setText(mountain1);
    }
}
