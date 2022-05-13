package com.example.billigtlager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class DepotFragment extends Fragment {

    Button door1, door2, door3, door4;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View FragmentDepot = inflater.inflate(R.layout.fragment_depot, container, false);


        door1 = (Button) FragmentDepot.findViewById(R.id.Door1);
        door2 = (Button) FragmentDepot.findViewById(R.id.Door2);
        door3 = (Button) FragmentDepot.findViewById(R.id.Door3);
        door4 = (Button) FragmentDepot.findViewById(R.id.Door4);

        door1.setOnClickListener(v -> {
            Intent textIntent = new Intent(Intent.ACTION_SEND);
                textIntent.setData(Uri.parse("D1" +24977234));
                Toast.makeText(getActivity(),"Dør 1 er nu åben", Toast.LENGTH_LONG).show();
        });
        door2.setOnClickListener(v -> {
            Intent textIntent = new Intent(Intent.ACTION_SEND);
            textIntent.setData(Uri.parse("D2" +24977234));
            Toast.makeText(getActivity(),"Dør 2 er nu åben", Toast.LENGTH_LONG).show();
        });
        door3.setOnClickListener(v -> {
            Intent textIntent = new Intent(Intent.ACTION_SEND);
            textIntent.setData(Uri.parse("D1" +24977234));
            Toast.makeText(getActivity(),"Dør 3 er nu åben", Toast.LENGTH_LONG).show();
        });
        door4.setOnClickListener(v -> {
            Intent textIntent = new Intent(Intent.ACTION_SEND);
            textIntent.setData(Uri.parse("D4" +24977234));
            Toast.makeText(getActivity(),"Dør 1 er nu åben", Toast.LENGTH_LONG).show();
        });

        return FragmentDepot;
    }
}