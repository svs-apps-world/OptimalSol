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

        createTicketData();

        mRecyclerView.setAdapter(new ExistingTicketsAdapter(this, mDataList, this));
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
    }

    private void createTicketData() {
        TicketsData data = new TicketsData(
                "Refrigerator", //Title
                "Fridge not starting",
                "No cooling. No light in Refrigerator", // Description
                "Check with power socket", //Resolution
                "8th of Sept" //DateOfIssue
        );
        mDataList.add(data);

        data = new TicketsData(
                "FAN", //Title
                "Fridge not starting",
                "No cooling. No light in Refrigerator", // Description
                "Check with power socket", //Resolution
                "8th of Sept" //DateOfIssue
        );
        mDataList.add(data);
    }

    @Override
    public void onClick(TicketsData item) {
        startActivity(new Intent(this, Ticket1.class));
    }
}