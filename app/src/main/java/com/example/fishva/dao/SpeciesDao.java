package com.example.fishva.dao;

import com.example.fishva.entities.Catch;
import com.example.fishva.entities.Species;
import com.example.fishva.entities.User;

import androidx.room.PrimaryKey;
import androidx.room.Insert;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Dao;
import androidx.lifecycle.LiveData;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SpeciesDao {
    @Query("SELECT * FROM Species")
    LiveData<List<Species>> getAll();

    @Query("SELECT * FROM Species WHERE speciesId IN (:speciesIds)")
    LiveData<List<Species>> loadAllBySpeciesIds(int[] speciesIds);

    @Query("SELECT * FROM Species WHERE speciesId LIKE :speciesId LIMIT 1")
    Species findBySpeciesId(int speciesId);

    @Insert
    void insertAll(Species...species);

    @Delete
    void delete(Species...species);

    @Update
    void update(Species...species);
}
