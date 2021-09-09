package com.example.optimalsolutions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

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
                "Refigerator", //Title
                "Fridge not starting",
                "No cooling. No light in Refrigerator", // Description
                "Check with power socket", //Resolution
                "8th of Sept" //DateOfIssue
        );
        mDataList.add(data);

        data = new TicketsData(
                "Microwave Oven", //Title
                "Items not heating",
                "No heating. only light lits up when turned on", // Description
                "Engineer replaced the Magnetron", //Resolution
                "18th of Jan" //DateOfIssue
        );
        mDataList.add(data);
        data = new TicketsData(
                "Smart TV", //Title
                "Internet not working",
                "Unable to connect to Internet", // Description
                "Wifi blocking IP address 192.168.42.1", //Resolution
                "10th of Aug" //DateOfIssue
        );
        mDataList.add(data);
    }

    @Override
    public void onClick(TicketsData item) {
        Intent intent = new Intent(this, Ticket1.class);
        intent.putExtra("bundle", (new Gson()).toJson(item));
        startActivity(intent);
    }
}