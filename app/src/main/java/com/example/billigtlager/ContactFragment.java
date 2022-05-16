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
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ContactFragment extends Fragment {
    EditText etSubject, etMessage, etPhone, etName;

    Button send;

    FloatingActionButton call;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View Fragmentcontact = inflater.inflate(R.layout.fragment_contact, container, false);
        // EditText
        etSubject = Fragmentcontact.findViewById(R.id.ET_subject);
        etMessage = Fragmentcontact.findViewById(R.id.ET_message);
        etPhone = Fragmentcontact.findViewById(R.id.ET_phone);
        etName = Fragmentcontact.findViewById(R.id.ET_name);
        //Button
        send = Fragmentcontact.findViewById(R.id.bt_send);
        //FAB
        call = Fragmentcontact.findViewById(R.id.FAB_dial);

        call.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:20781218"));
            startActivity(intent);
        });

        send.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@billigtlager.dk"});
            intent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());

            startActivity(intent);
        });

        return Fragmentcontact;
    }
}