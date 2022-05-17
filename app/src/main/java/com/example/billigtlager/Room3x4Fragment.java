package com.example.billigtlager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.billigtlager.db.Depotrum;

import java.util.List;

public class Room3x4Fragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    DepotrumListAdapter depotrumListAdapter;
    public Room3x4Fragment(){

    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room3x4, container, false);
            recyclerView = view.findViewById(R.id.recyclerView3_4);
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
        List<Depotrum> list = MainActivity.appDatabase.depotrumDAO().getAllDepotrum();

        depotrumListAdapter = new DepotrumListAdapter(list);
        recyclerView.setAdapter(depotrumListAdapter);

        return view;
    }
}