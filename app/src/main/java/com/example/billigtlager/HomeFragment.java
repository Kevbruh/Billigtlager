package com.example.billigtlager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button bookDepot = root.findViewById(R.id.fpbtnBookRoom);

        bookDepot.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.bookDepotFragment);
        });

        return root;
    }
}