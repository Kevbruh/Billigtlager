package com.example.billigtlager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText etTo, etSubject, etMessage, etPhone, etName;
    Button btSend, door1, door2, door3, door4;

    DoorSystem doorSystem;

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
        door1 = findViewById(R.id.Door1);
        door2 = findViewById(R.id.Door2);
        door3 = findViewById(R.id.Door3);
        door4 = findViewById(R.id.Door4);

        //FAB
        fabDialling = findViewById(R.id.FAB_dial);

        //Toolbar


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        btSend.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@billigtlager.dk"});
            intent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());
            startActivity(intent);

        });

        fabDialling.setOnClickListener(view -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel" + 20781218));
            startActivity(callIntent);
        });

    }



    public void openDoors(View view) {
        doorSystem.openDoorsInNaestved(view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if(itemId == R.id.front_page){
            Toast.makeText(this, "Front page", Toast.LENGTH_SHORT).show();
        } else if(itemId == R.id.open_door){
            Toast.makeText(this, "Open door", Toast.LENGTH_SHORT).show();
        }
        else if(itemId == R.id.contact_page){
            Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();
        }
        else if(itemId == R.id.about_page){
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }
}