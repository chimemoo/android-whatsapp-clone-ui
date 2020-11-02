package com.chimemoo.whatsappcloneui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chimemoo.whatsappcloneui.R;
import com.chimemoo.whatsappcloneui.adapter.StatusAdapter;
import com.chimemoo.whatsappcloneui.data.StatusData;
import com.chimemoo.whatsappcloneui.model.StatusModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatusFragment extends Fragment {

    private RecyclerView rvStatus;
    private View mView;
    private ArrayList<StatusModel> listActiveStatus = new ArrayList<>();

    public StatusFragment() {
        listActiveStatus.addAll(StatusData.getListDataActive());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_status, container, false);
        rvStatus = mView.findViewById(R.id.rv_status_list);

        StatusAdapter statusAdapter = new StatusAdapter(listActiveStatus);

        rvStatus.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvStatus.setHasFixedSize(true);
        rvStatus.setAdapter(statusAdapter);

        // Inflate the layout for this fragment
        return mView;
    }
}
