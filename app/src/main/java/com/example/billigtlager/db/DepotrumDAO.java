package com.example.billigtlager.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DepotrumDAO {

   @Query("SELECT * FROM depotrum")
   public List<Depotrum> getAllDepotrum();


   @Insert
   public void addDepotrum(Depotrum depotrum);


    @Delete
    void delete(Depotrum depotrum);

}
