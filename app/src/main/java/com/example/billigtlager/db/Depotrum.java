package com.example.billigtlager.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Depotrum {

@PrimaryKey(autoGenerate = true)
    public int RoomID;

@ColumnInfo(name = "Room Number")
    public String rumNr;


    @ColumnInfo(name = "KM2")
    public String km2;


    @ColumnInfo(name = "Price")
    public String price;




}


