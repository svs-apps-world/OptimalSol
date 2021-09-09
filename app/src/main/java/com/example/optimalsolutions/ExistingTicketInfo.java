package com.example.optimalsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;

public class ExistingTicketInfo extends AppCompatActivity {

    private TicketsData mTicketData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_ticket_info);
        String json = getIntent().getStringExtra("bundle");
        mTicketData = new Gson().fromJson(json, TicketsData.class);
    }
}