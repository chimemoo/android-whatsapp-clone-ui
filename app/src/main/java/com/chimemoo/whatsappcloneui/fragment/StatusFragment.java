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

    private RecyclerView rvStatusActive, rvStatusNoActive;
    private View mView;
    private ArrayList<StatusModel> listActiveStatus = new ArrayList<>();
    private ArrayList<StatusModel> listNoActiveStatus = new ArrayList<>();

    public StatusFragment() {
        listActiveStatus.addAll(StatusData.getListDataActive());
        listNoActiveStatus.addAll(StatusData.getListDataNoActive());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_status, container, false);

        setStatusActive();

        setStatusNoActive();

        // Inflate the layout for this fragment
        return mView;
    }

    private void setStatusActive(){
        rvStatusActive = mView.findViewById(R.id.rv_status_list);

        StatusAdapter statusAdapter = new StatusAdapter(listActiveStatus);

        rvStatusActive.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvStatusActive.setHasFixedSize(true);
        rvStatusActive.setAdapter(statusAdapter);
    }

    private void setStatusNoActive(){
        rvStatusNoActive = mView.findViewById(R.id.rv_status_list_noactive);

        StatusAdapter statusAdapter = new StatusAdapter(listNoActiveStatus);

        rvStatusNoActive.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvStatusNoActive.setHasFixedSize(true);
        rvStatusNoActive.setAdapter(statusAdapter);
    }
}
