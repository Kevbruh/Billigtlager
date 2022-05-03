package com.example.billigtlager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    EditText etTo, etSubject, etMessage, etPhone, etName;
    Button btSend;

    FloatingActionButton fabDialling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_page);

        //EditText
        etTo = findViewById(R.id.ET_to);
        etSubject = findViewById(R.id.ET_subject);
        etMessage = findViewById(R.id.ET_message);
        etPhone = findViewById(R.id.ET_phone);
        etName = findViewById(R.id.ET_name);

        //button
        btSend = findViewById(R.id.bt_send);

        //FAB
        fabDialling = findViewById(R.id.FAB_dial);


        btSend.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@billigtlager.dk"});
            intent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());
            startActivity(intent);
            Toast.makeText(this, "The Email was send", Toast.LENGTH_SHORT).show();;
        });

        fabDialling.setOnClickListener(view -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel" +20781218));
            startActivity(callIntent);

        });
    }
}