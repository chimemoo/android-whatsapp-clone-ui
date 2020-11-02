package com.chimemoo.whatsappcloneui.data;

import com.chimemoo.whatsappcloneui.R;
import com.chimemoo.whatsappcloneui.model.ChatModel;

import java.util.ArrayList;

public class ChatData {

    public static String[] name = {
            "Hudson",
            "Emily",
            "Jack",
            "Sparrow"
    };

    public static String[] time = {
            "14.00",
            "12.32",
            "13.12",
            "15.00"
    };

    public static String[] lastMessage = {
            "Hai!",
            "Hi there!",
            "Olla!",
            "Hi!"
    };

    private static int[] picture = {
            R.drawable.photo_user_1,
            R.drawable.photo_user_2,
            R.drawable.photo_user_3,
            R.drawable.photo_user_1
    };

    public static ArrayList<ChatModel> getListData(){
        ArrayList<ChatModel> list = new ArrayList<>();
        for (int position = 0; position < name.length; position++){
            ChatModel chatModel = new ChatModel();
            chatModel.setName(name[position]);
            chatModel.setLastMessage(lastMessage[position]);
            chatModel.setTime(time[position]);
            chatModel.setPicture(picture[position]);
            chatModel.setId(position);
            list.add(chatModel);
        }
        return list;
    }

}
