package com.example.billigtlager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.billigtlager.db.Depotrum;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_add_room#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_add_room extends Fragment {

    private EditText RumNrInput, KM2Input, PriceInput;
    private Button SaveButton;


    public Fragment_add_room() {


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_room, container, false);
        RumNrInput = view.findViewById(R.id.RumNrInput);
        KM2Input = view.findViewById(R.id.KM2Input);
        PriceInput = view.findViewById(R.id.PriceInput);
        SaveButton = view.findViewById(R.id.saveButton);
        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rumNr = Integer.parseInt(RumNrInput.getText().toString());
                String KM2 = KM2Input.getText().toString();
                String Price = PriceInput.getText().toString();

                Depotrum depotrum = new Depotrum();
                depotrum.setRumNr(rumNr);
                depotrum.setKm2(KM2);
                depotrum.setPrice(Price);
                MainActivity.appDatabase.depotrumDAO().addDepotrum(depotrum);
                Toast.makeText(getActivity(), "String Data succesfully saved", Toast.LENGTH_SHORT).show();
                RumNrInput.setText("");
                KM2Input.setText("");
                PriceInput.setText("");

            }
        });
        return view;

    }
}
