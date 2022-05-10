package com.example.billigtlager;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

public class DoorSystem extends MainActivity {


    public void openDoorsInNaestved(View view) {
        int id = view.getId();
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        if (id == R.id.Door1) {
            textIntent.setData(Uri.parse("D1" +24977234));
            Toast.makeText(this, "Dør 1 blev åbnet", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.Door2) {
            textIntent.setData(Uri.parse("D2" +24977234));
            Toast.makeText(this, "Dør 2 blev åbnet", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.Door3) {
            textIntent.setData(Uri.parse("D3" +24977234));
            Toast.makeText(this, "Dør 3 blev åbnet", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.Door4) {
            textIntent.setData(Uri.parse("D4" +24977234));
            Toast.makeText(this, "Dør 4 blev åbnet", Toast.LENGTH_SHORT).show();
        }
    }

}
