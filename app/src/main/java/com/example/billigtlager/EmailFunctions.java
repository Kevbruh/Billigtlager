package com.example.billigtlager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EmailFunctions extends AppCompatActivity {

    MainActivity main;



    public void email(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@billigtlager.dk"});
        intent.putExtra(Intent.EXTRA_TEXT,main.etSubject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,main.etMessage.getText().toString());
        startActivity(intent);
    }
}
