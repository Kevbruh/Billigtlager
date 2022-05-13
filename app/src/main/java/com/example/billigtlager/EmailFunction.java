package com.example.billigtlager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EmailFunction extends AppCompatActivity {

    MainActivity main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contact);

        Button sendEmail = findViewById(R.id.bt_send);

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@billigtlager.dk"});
                intent.putExtra(Intent.EXTRA_SUBJECT, main.etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, main.etMessage.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, main.etName.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, main.etPhone.getText().toString());
                startActivity(intent);
            }
        });
    }
}
