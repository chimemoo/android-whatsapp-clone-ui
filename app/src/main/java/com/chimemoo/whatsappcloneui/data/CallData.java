package com.chimemoo.whatsappcloneui.data;

import com.chimemoo.whatsappcloneui.R;
import com.chimemoo.whatsappcloneui.model.CallModel;
import com.chimemoo.whatsappcloneui.model.ChatModel;

import java.util.ArrayList;

public class CallData {

    public static String[] name = {
            "Hudson",
            "Emily",
            "Jack",
            "Sparrow"
    };

    public static String[] time = {
            "Hari ini 14.00",
            "Hari ini 12.32",
            "Kemarin 13.12",
            "Hari ini 15.00"
    };

    public static String[] inOut = {
            "in",
            "in",
            "out",
            "in"
    };

    public static String[] type = {
            "video",
            "normal",
            "video",
            "normal"
    };

    public static boolean[] received= {
            false,
            false,
            true,
            true
    };

    private static int[] picture = {
            R.drawable.photo_user_1,
            R.drawable.photo_user_2,
            R.drawable.photo_user_3,
            R.drawable.photo_user_1
    };

    public static ArrayList<CallModel> getListData(){
        ArrayList<CallModel> list = new ArrayList<>();
        for (int position = 0; position < name.length; position++){
            CallModel callModel = new CallModel();
            callModel.setId(position);
            callModel.setCallType(type[position]);
            callModel.setInOut(inOut[position]);
            callModel.setName(name[position]);
            callModel.setPicture(picture[position]);
            callModel.setStatus(received[position]);
            callModel.setTime(time[position]);
            list.add(callModel);
        }
        return list;
    }

}
