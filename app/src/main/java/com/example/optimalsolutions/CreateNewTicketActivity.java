package com.example.optimalsolutions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CreateNewTicketActivity extends AppCompatActivity implements CreateNewTicketChatOptionListener{

    private RecyclerView mRecyclerView;
    private ArrayList<ChatData> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_ticket);

        populateData();

        mRecyclerView = findViewById(R.id.createNewTicketRecyclerView);
        mRecyclerView.setAdapter(new CreateNewTicketAdapter(this, mDataList, this ));
    }

    private void populateData() {
        mDataList.add(new ChatData(true, "Hi", ChatData.CHAT_TYPE.TEXT));
        mDataList.add(new ChatData(false, "Hola", ChatData.CHAT_TYPE.TEXT));
        mDataList.add(new ChatData(true, "Whats up", ChatData.CHAT_TYPE.TEXT));
        mDataList.add(new ChatData(false, "I am good", ChatData.CHAT_TYPE.TEXT));
        mDataList.add(new ChatData(true, "How are you doing", ChatData.CHAT_TYPE.TEXT));
        mDataList.add(new ChatData(false, "How are you doing How are you doing How are you doing How are you doing How are you doing How are you doing How are you doing How are you doing How are you doing", ChatData.CHAT_TYPE.TEXT));

        ArrayList<String>  options = new ArrayList<>();
        options.add("Turn on light");
        options.add("Turn off light");
        options.add("Turn something light");
        ChatData chatData = new ChatData(false, "Hi", ChatData.CHAT_TYPE.TEXT);
        chatData.options = options;
        chatData.chatType = ChatData.CHAT_TYPE.MULTISELECT;
        mDataList.add(chatData);
    }
}