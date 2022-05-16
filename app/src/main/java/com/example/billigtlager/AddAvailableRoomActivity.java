package com.example.billigtlager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.billigtlager.db.AppDatabase;
import com.example.billigtlager.db.Depotrum;

public class AddAvailableRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_available_room);

        EditText RumNrInput = findViewById(R.id.RumNrInput);
        EditText KM2Input = findViewById(R.id.KM2Input);
        EditText PriceInput = findViewById(R.id.PriceInput);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewRoom(RumNrInput.getText().toString(), KM2Input.getText().toString(), PriceInput.getText().toString());
            }
        }));


        }
    private void saveNewRoom(String rumNr, String km2, String price){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        Depotrum depotrum = new Depotrum();
        depotrum.rumNr = rumNr;
        depotrum.km2 = km2;
        depotrum.price = price;
        db.depotrumDAO().insertDepotrum();

        finish();

    }
}