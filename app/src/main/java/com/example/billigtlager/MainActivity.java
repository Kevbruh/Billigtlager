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
    EmailFunction emailFunction;

    FloatingActionButton fabDialling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

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
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    public void openDoors(View view) {
        doorSystem.openDoorsInNaestved(view);
    }

    public void Main_menu(Menu menu) { }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.front_page:
                setContentView(R.layout.front_page);
                break;

            case R.id.open_door:
                setContentView(R.layout.open_door);
                break;
            case R.id.contact_page:
                Intent i = new Intent(this, ContactActivity.class);
                startActivity(i);
                break;
            case R.id.book_room:
                setContentView(R.layout.book_room);
                break;

            case R.id.about_page:
                setContentView(R.layout.about_us);
                break;

            case R.id.Rum3_4:
                setContentView(R.layout.rum3_4);
                break;

        }

                return super.onOptionsItemSelected(item);
        }

        public void sendEmail(View view) {
        emailFunction.email(view);
        }
}