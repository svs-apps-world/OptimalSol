package com.example.optimalsolutions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class CreateNewTicketActivity extends AppCompatActivity implements CreateNewTicketChatOptionListener {

    private RecyclerView mRecyclerView;
    private CreateNewTicketAdapter mAdapter;
    private ArrayList<ChatData> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_ticket);

        populateData();

        mRecyclerView = findViewById(R.id.createNewTicketRecyclerView);
        mAdapter = new CreateNewTicketAdapter(this, mDataList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void populateData() {
        mDataList.add(new ChatData(true, "Hi\n How can I help you today", ChatData.CHAT_TYPE.TEXT));
        mDataList.add(new ChatData(false, "Please select the Equipment", ChatData.CHAT_TYPE.TEXT));
        //mDataList.add(new ChatData(true, "Whats up", ChatData.CHAT_TYPE.TEXT));
        //mDataList.add(new ChatData(false, "I am good", ChatData.CHAT_TYPE.TEXT));
        //mDataList.add(new ChatData(true, "How are you doing", ChatData.CHAT_TYPE.TEXT));
       // mDataList.add(new ChatData(false, "How are you doing How are you doing How are you doing How are you doing How are you doing How are you doing How are you doing How are you doing How are you doing", ChatData.CHAT_TYPE.TEXT));

        ArrayList<ChatData.Options> optionsData = new ArrayList<>();
        optionsData.add(new ChatData.Options("Refrigerator", getRefrigeratorOptions()));
        optionsData.add(new ChatData.Options("Microwave Oven", getMicrowaveOvenOptions()));
        optionsData.add(new ChatData.Options("Smart TV", getSmartTVOptions()));

        ChatData chatData = new ChatData(false, "Hi", ChatData.CHAT_TYPE.TEXT);
        chatData.options = optionsData;
        chatData.chatType = ChatData.CHAT_TYPE.MULTISELECT;
        mDataList.add(chatData);
    }

    private ArrayList<ChatData.Options> getRefrigeratorOptions() {
        ArrayList<ChatData.Options> refrigOptions = new ArrayList<>();

        ArrayList<ChatData.Options> solution1 = new ArrayList<>();
        solution1.add(new ChatData.Options("Check with the power cable if it is connected to the wall socket.", null));
        solution1.add(new ChatData.Options("Check if the Switch is On", null));
        solution1.add(new ChatData.Options("Check with the wall socket if it is getting power. ", null));
        ChatData.Options issue1 = new ChatData.Options("Dead no power", solution1);
        refrigOptions.add(issue1);

        ArrayList<ChatData.Options> solution2 = new ArrayList<>();
        solution2.add(new ChatData.Options("Check if the defrost button has  is pressed", null));
        solution2.add(new ChatData.Options("Check with the defrost indicator if it is lit up", null));
//        solution2.add(new ChatData.Options("Remove any barrier (if any) in the front of magnetron(the Siver plate) inside the oven. ", null));
        ChatData.Options issue2 = new ChatData.Options("Defrost not working", solution2);
        refrigOptions.add(issue2);

        ArrayList<ChatData.Options> solution3 = new ArrayList<>();
        solution3.add(new ChatData.Options("Check if the Fridge is turned on", null));
        solution3.add(new ChatData.Options("Check if the regulator has been set to adequate temprature", null));
        ChatData.Options issue3 = new ChatData.Options("Cooling not working", solution3);
        refrigOptions.add(issue3);


        return refrigOptions;
    }

    private ArrayList<ChatData.Options> getMicrowaveOvenOptions() {
        ArrayList<ChatData.Options> microwaveOptions = new ArrayList<>();

        ArrayList<ChatData.Options> solution1 = new ArrayList<>();
        solution1.add(new ChatData.Options("Check with the power cable if it is connected to the wall socket.  ", null));
        solution1.add(new ChatData.Options("Check if the Switch is On", null));
        solution1.add(new ChatData.Options("Check with the wall socket if it is getting power. ", null));
        ChatData.Options issue1 = new ChatData.Options("Oven not working ", solution1);
        microwaveOptions.add(issue1);

        ArrayList<ChatData.Options> solution2 = new ArrayList<>();
        solution2.add(new ChatData.Options("Check with the temperature regulator if its set to some temperature above zero degree ", null));
        solution2.add(new ChatData.Options("Check if the food is kept in glass utensils", null));
        solution2.add(new ChatData.Options("Remove any barrier (if any) in the front of magnetron(the Siver plate) inside the oven. ", null));
        ChatData.Options issue2 = new ChatData.Options("Food items are not heating", solution2);
        microwaveOptions.add(issue2);

        ArrayList<ChatData.Options> solution3 = new ArrayList<>();
        solution3.add(new ChatData.Options("Check if there is any barrier in front of bulb avoiding light to be emmited", null));
//        solution3.add(new ChatData.Options("Check if the food is kept in glass utensils", null));
//        solution3.add(new ChatData.Options("Remove any barrier (if any) in the front of magnetron(the Siver plate) inside the oven. ", null));
        ChatData.Options issue3 = new ChatData.Options("Light is not working", solution3);
        microwaveOptions.add(issue3);

        return microwaveOptions;
    }

    private ArrayList<ChatData.Options> getSmartTVOptions() {
        ArrayList<ChatData.Options> smartTVOptions = new ArrayList<>();

        ArrayList<ChatData.Options> solution1 = new ArrayList<>();
        solution1.add(new ChatData.Options("Check with the power cable if it is connected to the wall socket.", null));
        solution1.add(new ChatData.Options("Check if the Switch is On", null));
        solution1.add(new ChatData.Options("Check with the wall socket if it is getting power. ", null));
        ChatData.Options issue1 = new ChatData.Options("TV not working ", solution1);
        smartTVOptions.add(issue1);

        ArrayList<ChatData.Options> solution2 = new ArrayList<>();
        solution2.add(new ChatData.Options("Check if the Battery are inserted.", null));
        solution2.add(new ChatData.Options("Try swapping with new set of Battery", null));
        solution2.add(new ChatData.Options("Check if the infrared sensor is pointed towards the TV without any barriers in between", null));
        ChatData.Options issue2 = new ChatData.Options("Remote not working", solution2);
        smartTVOptions.add(issue2);

        ArrayList<ChatData.Options> solution3 = new ArrayList<>();
        solution3.add(new ChatData.Options("Check if the Internet is connected ", null));
        solution3.add(new ChatData.Options("Internet speed should be more than 2mbps", null));
        solution3.add(new ChatData.Options("Try running troubleshooter", null));
        ChatData.Options issue3 = new ChatData.Options("Streaming platform not working", solution3);
        smartTVOptions.add(issue3);

        return smartTVOptions;
    }

    @Override
    public void onOptionSelected(ChatData.Options option) {
        mDataList.add(new ChatData(true, option.header, ChatData.CHAT_TYPE.TEXT));
        mAdapter.notifyItemInserted(mDataList.size() - 1);
        mRecyclerView.scrollToPosition(mDataList.size() - 1);

        if (option.list != null) {
            mDataList.add(new ChatData(false, "Please select from following:", ChatData.CHAT_TYPE.TEXT));
            mAdapter.notifyItemInserted(mDataList.size() - 1);
//            mRecyclerView.scrollToPosition(mDataList.size() - 1);

            ChatData chatData = new ChatData(false, "Please select from following:", ChatData.CHAT_TYPE.TEXT);
            chatData.options = option.list;
            chatData.chatType = ChatData.CHAT_TYPE.MULTISELECT;
            mDataList.add(chatData);
            mAdapter.notifyItemInserted(mDataList.size() - 1);
            mRecyclerView.scrollToPosition(mDataList.size() - 1);
        } else {
            mDataList.add(new ChatData(true, "Awesome! You are all done!", ChatData.CHAT_TYPE.TEXT));
            mAdapter.notifyItemInserted(mDataList.size() - 1);
//            mRecyclerView.scrollToPosition(mDataList.size() - 1);

            mDataList.add(new ChatData(true, "", ChatData.CHAT_TYPE.MULTISELECT));
            mAdapter.notifyItemInserted(mDataList.size() - 1);
            mRecyclerView.scrollToPosition(mDataList.size() - 1);
        }
    }

    @Override
    public void onCreateManualTicketButtonClicked() {
        startActivity(new Intent(this, FaultReport.class));
    }
}