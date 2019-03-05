package com.example.fishva.dao;

import com.example.fishva.entities.Settings;
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
public interface SettingsDao {
    @Query("SELECT * FROM Settings")
    LiveData<List<Settings>> getAll();

    @Query("SELECT * FROM Settings WHERE userId IN (:userIds)")
    LiveData<List<Settings>> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Settings WHERE userId LIKE :userId LIMIT 1")
    Settings findByUserId(int userId);

    @Insert
    void insertAll(Settings...settings);

    @Delete
    void delete(Settings...settings);

    @Update
    void update(Settings...settings);
}
