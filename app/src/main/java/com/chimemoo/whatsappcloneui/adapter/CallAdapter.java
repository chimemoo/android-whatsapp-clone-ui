package com.chimemoo.whatsappcloneui.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chimemoo.whatsappcloneui.R;
import com.chimemoo.whatsappcloneui.model.CallModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.ListViewHolder> {
    private ArrayList<CallModel> listCall;

    public CallAdapter(ArrayList<CallModel> listCall) {
        this.listCall = listCall;
    }

    @NonNull
    @Override
    public CallAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_call, parent, false);
        return new CallAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallAdapter.ListViewHolder holder, int position) {
        CallModel callData = listCall.get(position);

        Glide.with(holder.itemView.getContext())
                .load(callData.getPicture())
                .apply(new RequestOptions().override(100,100))
                .into(holder.civProfileImage);

        holder.tvNameUser.setText(callData.getName());
        holder.tvTime.setText(callData.getTime());

        if(callData.getInOut().equals("out")){
            holder.ivInOut.setBackgroundResource(R.drawable.ic_call_made);
        }

        if(!callData.isStatus()) {
            if(callData.getInOut().equals("out")){
                holder.ivInOut.setBackgroundResource(R.drawable.ic_call_made_red);
            } else {
                holder.ivInOut.setBackgroundResource(R.drawable.ic_call_received_red);
            }
        }

        if(callData.getCallType().equals("video")){
            holder.ivCallType.setBackgroundResource(R.drawable.ic_videocam);
        } else {
            holder.ivCallType.setBackgroundResource(R.drawable.ic_call);
        }

    }

    @Override
    public int getItemCount() {
        return listCall.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civProfileImage;
        TextView tvNameUser, tvTime;
        ImageView ivInOut, ivCallType;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            civProfileImage = itemView.findViewById(R.id.civ_profile_call);
            tvNameUser = itemView.findViewById(R.id.tv_name_user);
            tvTime = itemView.findViewById(R.id.tv_time);
            ivInOut = itemView.findViewById(R.id.iv_inout);
            ivCallType = itemView.findViewById(R.id.iv_call_type);
        }
    }
}
