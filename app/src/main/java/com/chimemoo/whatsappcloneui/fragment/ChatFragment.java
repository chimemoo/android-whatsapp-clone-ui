package com.chimemoo.whatsappcloneui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chimemoo.whatsappcloneui.R;
import com.chimemoo.whatsappcloneui.adapter.ChatAdapter;
import com.chimemoo.whatsappcloneui.data.ChatData;
import com.chimemoo.whatsappcloneui.decorator.SimpleDivider;
import com.chimemoo.whatsappcloneui.model.ChatModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    private RecyclerView rvChat;
    private View mView;
    private ArrayList<ChatModel> list = new ArrayList<>();

    public ChatFragment() {
        list.addAll(ChatData.getListData());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_chat, container, false);
        rvChat = mView.findViewById(R.id.rv_chat_list);
        ChatAdapter chatAdapter = new ChatAdapter(list);

        rvChat.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvChat.setHasFixedSize(true);
        rvChat.setAdapter(chatAdapter);
        rvChat.addItemDecoration(new SimpleDivider(mView.getContext()));

        chatAdapter.setClickInterface(new ChatAdapter.ClickInterface() {
            @Override
            public void clickEventOne(Object obj) {
                Toast.makeText(mView.getContext(), "Test",Toast.LENGTH_LONG).show();
            }
        });
        
        return mView;
    }
}
