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
            Toast.makeText(getActivity(),"Tryk på send og dør 1 vil låse op", Toast.LENGTH_LONG).show();
            Intent textIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "24977234", null));
                textIntent.putExtra("sms_body", "D1");
                startActivity(textIntent);
        });
        door2.setOnClickListener(v -> {
            Toast.makeText(getActivity(),"Tryk på send og dør 2 vil låse op", Toast.LENGTH_LONG).show();
            Intent textIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "24977234", null));
            textIntent.putExtra("sms_body", "D2");
            startActivity(textIntent);
        });
        door3.setOnClickListener(v -> {
            Toast.makeText(getActivity(),"Tryk på send og dør 3 vil låse op", Toast.LENGTH_LONG).show();
            Intent textIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "24977234", null));
            textIntent.putExtra("sms_body", "D3");
            startActivity(textIntent);
        });
        door4.setOnClickListener(v -> {
            Toast.makeText(getActivity(),"Tryk på send og dør 4 vil låse op", Toast.LENGTH_LONG).show();
            Intent textIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "24977234", null));
            textIntent.putExtra("sms_body", "D4");
            startActivity(textIntent);
        });

        return FragmentDepot;
    }
}