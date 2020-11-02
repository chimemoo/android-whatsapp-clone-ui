package com.chimemoo.whatsappcloneui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chimemoo.whatsappcloneui.R;
import com.chimemoo.whatsappcloneui.model.StatusModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ListViewHolder> {

    private ArrayList<StatusModel> listStatus;

    public StatusAdapter(ArrayList<StatusModel> listStatus) {
        this.listStatus = listStatus;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_status, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final StatusModel statusModel = listStatus.get(position);

        Glide.with(holder.itemView.getContext())
                .load(statusModel.getPicture())
                .apply(new RequestOptions().override(100,100))
                .into(holder.civProfile);

        holder.tvName.setText(statusModel.getName());
        holder.tvDatePosted.setText(statusModel.getTime());
    }

    @Override
    public int getItemCount() {
        return listStatus.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llStatus;
        TextView tvName, tvDatePosted;
        CircleImageView civProfile;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            llStatus = itemView.findViewById(R.id.ll_status);
            tvName = itemView.findViewById(R.id.tv_name_user_status);
            tvDatePosted = itemView.findViewById(R.id.tv_date_posted);
            civProfile = itemView.findViewById(R.id.civ_profile_status);
        }
    }
}
