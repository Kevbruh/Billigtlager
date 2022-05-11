package com.example.billigtlager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Toolbar;

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

        //Other things
        setSupportActionBar(toolbar);




    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public void openDoors(View view) {
        doorSystem.openDoorsInNaestved(view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // @Override
    // public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    //  switch (item.getItemId()) {
    //      case R.id.front_page:
    //          setContentView(R.layout.front_page);
    //          break;
    //      case R.id.open_door:
    //          setContentView(R.layout.open_door);
    //          break;
    //      case R.id.contact_page:
    //          setContentView(R.layout.contact_page);
    //          break;
    //      case R.id.about_us:
    //          setContentView(R.layout.about_us);
    //          break;
    //      case R.id.exit:
//
    //      }
    //  return super.onOptionsItemSelected(item);
    // }

}