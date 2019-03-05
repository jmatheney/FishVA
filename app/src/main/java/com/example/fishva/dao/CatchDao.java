package com.example.fishva.dao;

import com.example.fishva.entities.Catch;

import androidx.room.PrimaryKey;
import androidx.room.Insert;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Dao;
import androidx.lifecycle.LiveData;
import androidx.room.Update;

import java.util.List;


@Dao
public interface CatchDao {
    @Query("SELECT * FROM catch")
    LiveData<List<Catch>> getAll();

    @Query("SELECT * FROM catch WHERE catchId IN (:catchIds)")
    LiveData<List<Catch>> loadAllByIds(int[] catchIds);

    @Query("SELECT * FROM catch WHERE catchId LIKE :catchId LIMIT 1")
    Catch findByCatchId(int catchId);

    @Insert
    void insertAll(Catch...caught);

    @Delete
    void delete(Catch...caught);

    @Update
    void update(Catch...caught);
}
