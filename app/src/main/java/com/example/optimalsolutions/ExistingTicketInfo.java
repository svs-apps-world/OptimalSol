package com.example.optimalsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class ExistingTicketInfo extends AppCompatActivity {

    private TicketsData mTicketData;
    private TextView mEquipmentValue;
    private TextView mIssueValue;
    private TextView mDateOfIssueValue;
    private TextView mDescriptionValue;
    private TextView mResolutionValue;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_ticket_info);
        String json = getIntent().getStringExtra("bundle");
        mTicketData = new Gson().fromJson(json, TicketsData.class);
        mEquipmentValue = findViewById(R.id.equipmentValue);
        mIssueValue = findViewById(R.id.issueValue);
        mDateOfIssueValue = findViewById(R.id.dateOfIssueValue);
        mDescriptionValue = findViewById(R.id.descriptionValue);
        mResolutionValue = findViewById(R.id.resolutionValue);
        populateData();
    }

    private void populateData() {
        mEquipmentValue.setText(mTicketData.equipmentName);
        mIssueValue.setText(mTicketData.issue);
        mDateOfIssueValue.setText(mTicketData.dateOfIssue);
        mDescriptionValue.setText(mTicketData.description);
        mResolutionValue.setText(mTicketData.resolution);
    }

}