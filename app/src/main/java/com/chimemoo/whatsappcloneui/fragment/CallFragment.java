package com.chimemoo.whatsappcloneui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chimemoo.whatsappcloneui.R;
import com.chimemoo.whatsappcloneui.adapter.CallAdapter;
import com.chimemoo.whatsappcloneui.data.CallData;
import com.chimemoo.whatsappcloneui.decorator.SimpleDivider;
import com.chimemoo.whatsappcloneui.model.CallModel;
import com.chimemoo.whatsappcloneui.model.ChatModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {

    RecyclerView rvCall;
    private View mView;
    private ArrayList<CallModel> list = new ArrayList<>();

    public CallFragment() {
       list.addAll(CallData.getListData());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_call, container, false);

        rvCall = mView.findViewById(R.id.rv_call_list);

        CallAdapter callAdapter = new CallAdapter(list);
        rvCall.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCall.setHasFixedSize(true);
        rvCall.setAdapter(callAdapter);
        rvCall.addItemDecoration(new SimpleDivider(mView.getContext()));

        return mView;
    }
}
