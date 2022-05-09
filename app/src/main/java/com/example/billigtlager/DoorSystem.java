package com.example.billigtlager;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class DoorSystem extends MainActivity {


    public void openDoors(View view) {
        int id = view.getId();
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        if (id == R.id.Door1) {
            textIntent.setData(Uri.parse("D1" +24977234));
        } else if (id == R.id.Door2) {
            textIntent.setData(Uri.parse("D2" +24977234));
        } else if (id == R.id.Door3) {
            textIntent.setData(Uri.parse("D3" +24977234));
        } else if (id == R.id.Door4) {
            textIntent.setData(Uri.parse("D4" +24977234));
        }
    }
}
