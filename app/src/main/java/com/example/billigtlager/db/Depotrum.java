package com.example.billigtlager.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Depotrum {


    @PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "Room Number")
    public int rumNr;


    public String getKm2() {
        return km2;
    }

    public void setKm2(String km2) {
        this.km2 = km2;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @ColumnInfo(name = "KM2")
    public String km2;


    @ColumnInfo(name = "Price")
    public String price;


    public int getRumNr() {
        return rumNr;
    }

    public void setRumNr(int rumNr) {
        rumNr = rumNr;
    }
}


