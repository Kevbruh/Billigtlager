package com.example.billigtlager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BookDepotFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_depot, container, false);

        Button button_3x4 = root.findViewById(R.id.Rum3_4);
        Button button_5x6 = root.findViewById(R.id.Rum5_6);
        Button button_7x8 = root.findViewById(R.id.Rum7_8);
        Button button_9x10 = root.findViewById(R.id.Rum9_10);
        Button button_15x20 = root.findViewById(R.id.Rum15_20);

        button_3x4.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.room3x4Fragment);
        });

        button_5x6.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.room5x6Fragment);
        });

        button_7x8.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.room7x8Fragment);
        });

        button_9x10.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.room9x10Fragment);
        });

        button_15x20.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.room15x20Fragment);
        });

        return root;
    }
}