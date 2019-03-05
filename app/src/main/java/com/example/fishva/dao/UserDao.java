package com.example.fishva.dao;

import com.example.fishva.entities.User;

import androidx.room.PrimaryKey;
import androidx.room.Insert;
import androidx.room.Delete;
import androidx.room.Update;
import androidx.room.Query;
import androidx.room.Dao;
import androidx.lifecycle.LiveData;
import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM User WHERE id IN (:userIds)")
    LiveData<List<User>> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM User WHERE username = :username LIMIT 1")
    User findByUsername(String username);

    @Insert
    long insert(User user);

    @Delete
    void delete(User...users);

    @Update
    void update(User...users);
}

