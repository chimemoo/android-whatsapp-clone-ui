package com.chimemoo.whatsappcloneui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chimemoo.whatsappcloneui.R;
import com.chimemoo.whatsappcloneui.model.ChatModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ListViewHolder> {
    private ArrayList<ChatModel> listChat;
    private ClickInterface mClickInterface;

    // Interface fot clicked chat
    public interface ClickInterface {
        void clickEventOne(Object obj);
    }

    public void setClickInterface(ClickInterface clickInterface){
        mClickInterface = clickInterface;
    }

    private class FirstClickListener implements View.OnClickListener {
        private int mPosition;
        private boolean mClickable;

        void setPosition(int position) { mPosition = position; }
        void setClickable(boolean clickable) { mClickable = clickable; }

        @Override
        public void onClick(View v) {
            if(mClickable) {
                mClickInterface.clickEventOne(listChat.get(mPosition));
            }
        }
    }

    // Constuctor to set chat list
    public ChatAdapter(ArrayList<ChatModel> listChat) {
        this.listChat = listChat;
    }

    @NonNull
    @Override
    public ChatAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_chat, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ChatAdapter.ListViewHolder holder, int position) {
        final ChatModel chatModel = listChat.get(position);

        Glide.with(holder.itemView.getContext())
                .load(chatModel.getPicture())
                .apply(new RequestOptions().override(100,100))
                .into(holder.civProfile);

        holder.tvName.setText(chatModel.getName());
        holder.tvLastMessage.setText(chatModel.getLastMessage());
        holder.tvTime.setText(chatModel.getTime());
        holder.firstClickListener.setClickable(true);
        holder.firstClickListener.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return listChat.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llChat;
        TextView tvName, tvLastMessage, tvTime;
        CircleImageView civProfile;

        FirstClickListener firstClickListener;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            llChat = itemView.findViewById(R.id.ll_chat);
            tvName = itemView.findViewById(R.id.tv_name_user);
            tvLastMessage = itemView.findViewById(R.id.tv_last_message);
            tvTime = itemView.findViewById(R.id.tv_time);
            civProfile = itemView.findViewById(R.id.civ_profile);

            firstClickListener = new FirstClickListener();
            llChat.setOnClickListener(firstClickListener);
        }
    }


}
