package com.example.billigtlager;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FrontPage extends AppCompatActivity {

    public void bookRoomButton(View view) {
        Intent intent = new Intent(this, BookRoom.class);
        startActivity(intent);
    }
}
