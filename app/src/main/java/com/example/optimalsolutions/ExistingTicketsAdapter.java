package com.example.optimalsolutions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExistingTicketsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<TicketsData> mDataList;
    private ExistingTicketItemClickListener mListener;

    public ExistingTicketsAdapter(Context context, ArrayList<TicketsData> dataList, ExistingTicketItemClickListener listener) {
        mContext = context;
        mDataList = dataList;
        mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExistingTicketItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.existing_ticket_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ExistingTicketItemViewHolder existingTicketItemViewHolder = (ExistingTicketItemViewHolder) holder;
        existingTicketItemViewHolder.bind(mDataList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private class ExistingTicketItemViewHolder extends RecyclerView.ViewHolder {
        TextView existingTicketTitle;

        ExistingTicketItemViewHolder(@NonNull View itemView) {
            super(itemView);
            existingTicketTitle = itemView.findViewById(R.id.et_list_item_title_text);
        }

        public void bind(TicketsData item, ExistingTicketItemClickListener listener) {
            existingTicketTitle.setText(item.equipmentName);
            itemView.setOnClickListener(v -> listener.onClick(item));
        }
    }
}
