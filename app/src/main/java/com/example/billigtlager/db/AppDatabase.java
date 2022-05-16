package com.example.billigtlager.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Depotrum.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {


public abstract DepotrumDAO depotrumDAO();

private static  AppDatabase INSTANCE;

public static AppDatabase getDbInstance (Context context){

    if(INSTANCE == null) {
        INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Depotrum database")
        .allowMainThreadQueries()
                .build();
    }
return INSTANCE;
}

}
