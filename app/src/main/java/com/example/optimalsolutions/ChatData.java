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

    public static class Options {
        public String header;
        public ArrayList<Options> list = null;

        public Options(String header, ArrayList<Options> list) {
            this.header = header;
            this.list = list;
        }
    }

    public boolean isMyText;
    public String chatText;
    public CHAT_TYPE chatType;
    public ArrayList<Options> options = null;

}
