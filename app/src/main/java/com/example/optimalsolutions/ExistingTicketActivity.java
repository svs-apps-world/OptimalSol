package com.example.optimalsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExistingTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_ticket);
    }

    public void onTicket1Click(View view) {
        startActivity(new Intent(this, Ticket1.class));
    }
}