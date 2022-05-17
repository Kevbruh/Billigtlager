package com.example.billigtlager.db;




import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Depotrum.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {


public abstract DepotrumDAO depotrumDAO();



}
