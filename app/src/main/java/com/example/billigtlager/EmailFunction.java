package com.example.billigtlager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EmailFunction extends AppCompatActivity {

    EditText etSubject, etMessage, etPhone, etName;

    Button sendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contact);

        //EditText find id
        etSubject = findViewById(R.id.ET_subject);
        etMessage = findViewById(R.id.ET_message);
        etPhone = findViewById(R.id.ET_phone);
        etName = findViewById(R.id.ET_name);

        // Button find id
        sendEmail = findViewById(R.id.bt_send);

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@billigtlager.dk"});
                intent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, "Vh. " + etName.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, etPhone.getText().toString());
                startActivity(intent);
            }
        });
    }
}
