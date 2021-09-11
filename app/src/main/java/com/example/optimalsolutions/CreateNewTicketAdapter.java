package com.example.optimalsolutions;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CreateNewTicketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<ChatData> mDataList;
    private CreateNewTicketChatOptionListener mListener;
    private int MY_TEXT_VIEW_TYPE = 0;
    private int MY_TEXT_OPTIONS_TYPE = 1;
    private int OTHER_PARTY_VIEW_TYPE = 2;
    private int OTHER_PARTY_OPTIONSVIEW_TYPE = 3;

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
        } else if (viewType == MY_TEXT_OPTIONS_TYPE) {
            return new CreateNewTicketAdapter.MyOptionsItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.chat_my_multi_select_list_item, parent, false));
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
            if (chatData.chatType.equals(ChatData.CHAT_TYPE.MULTISELECT)) {
                ((MyOptionsItemViewHolder) holder).bind(chatData, mListener);
            } else {
                ((MyTextItemViewHolder) holder).bind(chatData, mListener);
            }
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
            if (chatData.chatType.equals(ChatData.CHAT_TYPE.MULTISELECT)) {
                return MY_TEXT_OPTIONS_TYPE;
            } else {
                return MY_TEXT_VIEW_TYPE;
            }
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
        }
    }

    private class OtherPArtyOptionsItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;

        OtherPArtyOptionsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.chatMultiSelectLinearLayout);
        }

        public void bind(ChatData item, CreateNewTicketChatOptionListener listener) {
            linearLayout.removeAllViews();
            for (int i = 0; i < item.options.size(); i++) {
                Button button = new Button(itemView.getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                int margin = (int) itemView.getResources().getDimension(R.dimen.chat_option_button_margin);
                layoutParams.setMargins(margin, margin, margin, margin);
                button.setLayoutParams(layoutParams);
                button.setBackground(ContextCompat.getDrawable(itemView.getContext(), R.drawable.rounded_background_yellow));
                button.setAllCaps(false);
                button.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                button.setText(item.options.get(i).header);
                int padding = (int) itemView.getContext().getResources().getDimension(R.dimen.chat_option_button_padding);
                button.setPadding(padding, padding, padding, padding);
                int finalI = i;
                button.setOnClickListener(v -> listener.onOptionSelected(item.options.get(finalI)));
                linearLayout.addView(button);
            }
        }
    }

    private class MyOptionsItemViewHolder extends RecyclerView.ViewHolder {

        Button createManualTicketButton;

        public MyOptionsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            createManualTicketButton = itemView.findViewById(R.id.createManualTicketButton);
        }

        public void bind(ChatData item, CreateNewTicketChatOptionListener listener) {
            createManualTicketButton.setOnClickListener(v -> {
                listener.onCreateManualTicketButtonClicked();
            });
        }
    }
}
