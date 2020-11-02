package com.chimemoo.whatsappcloneui.data;

import com.chimemoo.whatsappcloneui.R;
import com.chimemoo.whatsappcloneui.model.StatusModel;

import java.util.ArrayList;

public class StatusData {

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

    public static boolean[] type = {
            true,
            true,
            false,
            false
    };

    private static int[] picture = {
            R.drawable.photo_user_1,
            R.drawable.photo_user_2,
            R.drawable.photo_user_3,
            R.drawable.photo_user_1
    };

    public static ArrayList<StatusModel> getListDataActive(){
        ArrayList<StatusModel> list = new ArrayList<>();
        for (int position = 0; position < name.length; position++){
            if(type[position]){
                StatusModel status = new StatusModel();
                status.setId(position);
                status.setName(name[position]);
                status.setPicture(picture[position]);
                status.setTime(time[position]);
                status.setType(type[position]);

                list.add(status);
            }
        }
        return list;
    }

    public static ArrayList<StatusModel> getListDataNoActive(){
        ArrayList<StatusModel> list = new ArrayList<>();
        for (int position = 0; position < name.length; position++){
            if(type[position] == false){
                StatusModel status = new StatusModel();
                status.setId(position);
                status.setName(name[position]);
                status.setPicture(picture[position]);
                status.setTime(time[position]);
                status.setType(type[position]);

                list.add(status);
            }
        }
        return list;
    }

}
