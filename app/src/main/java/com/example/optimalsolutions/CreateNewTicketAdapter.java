package com.example.optimalsolutions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CreateNewTicketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<ChatData> mDataList;
    private CreateNewTicketChatOptionListener mListener;
    private int MY_TEXT_VIEW_TYPE = 0;
    private int OTHER_PARTY_VIEW_TYPE = 1;
    private int OTHER_PARTY_OPTIONSVIEW_TYPE = 2;

    public CreateNewTicketAdapter(Context mContext, ArrayList<ChatData> mDataList, CreateNewTicketChatOptionListener mListener) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MY_TEXT_VIEW_TYPE) {
            return new CreateNewTicketAdapter.MyTextItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.chat_my_text_list_item, parent, false));
        } else if (viewType == OTHER_PARTY_OPTIONSVIEW_TYPE) {
            return new CreateNewTicketAdapter.OtherPArtyOptionsItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.chat_other_party_multi_select_list_item, parent, false));
        } else {
            return new CreateNewTicketAdapter.OtherPArtyItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.chat_other_party_text_list_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatData chatData = mDataList.get(position);
        if (chatData.isMyText) {
            ((MyTextItemViewHolder) holder).bind(chatData, mListener);
        } else {
            if (chatData.chatType.equals(ChatData.CHAT_TYPE.MULTISELECT)) {
                ((OtherPArtyOptionsItemViewHolder) holder).bind(chatData, mListener);
            } else {
                ((OtherPArtyItemViewHolder) holder).bind(chatData, mListener);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        ChatData chatData = mDataList.get(position);
        if (chatData.isMyText) {
            return MY_TEXT_VIEW_TYPE;
        } else {
            if (chatData.chatType.equals(ChatData.CHAT_TYPE.MULTISELECT)) {
                return OTHER_PARTY_OPTIONSVIEW_TYPE;
            } else {
                return OTHER_PARTY_VIEW_TYPE;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private class MyTextItemViewHolder extends RecyclerView.ViewHolder {
        TextView chatText;

        MyTextItemViewHolder(@NonNull View itemView) {
            super(itemView);
            chatText = itemView.findViewById(R.id.chatText);
        }

        public void bind(ChatData item, CreateNewTicketChatOptionListener listener) {
            chatText.setText(item.chatText);
//            itemView.setOnClickListener(v -> listener.onClick(item));
        }
    }

    private class OtherPArtyItemViewHolder extends RecyclerView.ViewHolder {
        TextView chatText;

        OtherPArtyItemViewHolder(@NonNull View itemView) {
            super(itemView);
            chatText = itemView.findViewById(R.id.chatText);
        }

        public void bind(ChatData item, CreateNewTicketChatOptionListener listener) {
            chatText.setText(item.chatText);
//            itemView.setOnClickListener(v -> listener.onClick(item));
        }
    }

    private class OtherPArtyOptionsItemViewHolder extends RecyclerView.ViewHolder {
        Button option1;
        Button option2;
        Button option3;

        OtherPArtyOptionsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
        }

        public void bind(ChatData item, CreateNewTicketChatOptionListener listener) {
            if (item.options.size() > 2) {
                option1.setText(item.options.get(0));
                option2.setText(item.options.get(1));
                option3.setText(item.options.get(2));
            }
//            itemView.setOnClickListener(v -> listener.onClick(item));
        }
    }
}
