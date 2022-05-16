package com.example.billigtlager;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {

    //Firebase authentication
    FirebaseAuth firebaseAuthentication;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_profile, container, false);
        View root =  inflater.inflate(R.layout.fragment_profile, container, false);

        //Initializations
        firebaseAuthentication = FirebaseAuth.getInstance();

        //Buttons
        Button btnLogin = root.findViewById(R.id.btnLogin);

        //Navigation
        btnLogin.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.profileFragment);
        });

    return root;
    }



    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser user = firebaseAuthentication.getCurrentUser();

        if (user == null) {
            startActivity(new Intent());
        }
    }
}