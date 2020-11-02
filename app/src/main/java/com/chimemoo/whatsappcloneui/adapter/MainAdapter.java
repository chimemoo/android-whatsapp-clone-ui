package com.chimemoo.whatsappcloneui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.chimemoo.whatsappcloneui.fragment.CallFragment;
import com.chimemoo.whatsappcloneui.fragment.ChatFragment;
import com.chimemoo.whatsappcloneui.fragment.StatusFragment;

public class MainAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;

    public MainAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ChatFragment chatFragment = new ChatFragment();
                return chatFragment;
            case 1:
                StatusFragment statusFragment = new StatusFragment();
                return statusFragment;
            case 2:
                CallFragment callFragment = new CallFragment();
                return callFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
