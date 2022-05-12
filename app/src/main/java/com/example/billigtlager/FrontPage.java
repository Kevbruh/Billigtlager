package com.example.billigtlager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FrontPage extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    Button goToBookRoomPage = findViewById(R.id.fpbtnBookRoom);

    goToBookRoomPage.setOnClickListener(view -> {
        Toast.makeText(this, "hej", Toast.LENGTH_LONG);
    });
    }

}
