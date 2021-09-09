package com.example.optimalsolutions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ExistingTicketActivity extends AppCompatActivity implements ExistingTicketItemClickListener {

    private RecyclerView mRecyclerView;
    private ArrayList<TicketsData> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_ticket);

        mRecyclerView = findViewById(R.id.existingTicketsRecyclerView);

        for (int i = 0; i < 20; i++) {
            mDataList.add(new TicketsData("Ticket " + i));
        }
        mRecyclerView.setAdapter(new ExistingTicketsAdapter(this, mDataList, this));
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
    }

    @Override
    public void onClick(TicketsData item) {
        startActivity(new Intent(this, Ticket1.class));
    }
}