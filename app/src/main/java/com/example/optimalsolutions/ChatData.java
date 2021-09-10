package com.example.optimalsolutions;

import java.util.ArrayList;

public class ChatData {

    public ChatData(boolean isMyText, String chatText, CHAT_TYPE chatType) {
        this.isMyText = isMyText;
        this.chatText = chatText;
        this.chatType = chatType;
    }

    public enum CHAT_TYPE {
        TEXT,
        MULTISELECT
    }

    public boolean isMyText;
    public String chatText;
    public CHAT_TYPE chatType;
    public ArrayList<String> options = new ArrayList<>();

}
