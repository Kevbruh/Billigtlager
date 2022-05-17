package com.example.billigtlager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BookDepotFragment extends Fragment {


    Button button_3x4, button_5x6, button_7x8, button_9x10, button_15x20, button_AddRoom;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_depot, container, false);


         button_3x4 = root.findViewById(R.id.Rum3_4);
         button_5x6 = root.findViewById(R.id.Rum5_6);
         button_7x8 = root.findViewById(R.id.Rum7_8);
         button_9x10 = root.findViewById(R.id.Rum9_10);
         button_15x20 = root.findViewById(R.id.Rum15_20);
         button_AddRoom = root.findViewById(R.id.AddRoomButton);
        // button_AddRoom.setOnClickListener(this);

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

         button_AddRoom.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.fragment_add_room);
        });

 /*       button_AddRoom.setOnClickListener(v -> {

}


        });
*/
        return root;
    }

  //  @Override
   // public void onClick(View v){
     //   MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new AddAvailableRoomActivity(),null).addToBackStack(null).commit();


    }
