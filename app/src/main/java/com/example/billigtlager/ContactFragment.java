package com.example.billigtlager;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ContactFragment extends Fragment {
    EditText etSubject, etMessage, etPhone, etName;

    Button send;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View Fragmentcontact = inflater.inflate(R.layout.fragment_contact, container, false);
        etSubject = (EditText) Fragmentcontact.findViewById(R.id.ET_subject);
        etMessage = (EditText) Fragmentcontact.findViewById(R.id.ET_message);
        etPhone = (EditText) Fragmentcontact.findViewById(R.id.ET_phone);
        etName = (EditText) Fragmentcontact.findViewById(R.id.ET_name);
        send = (Button) Fragmentcontact.findViewById(R.id.bt_send);

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