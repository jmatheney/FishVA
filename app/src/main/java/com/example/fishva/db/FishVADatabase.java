package com.example.fishva.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import com.example.fishva.entities.User;
import com.example.fishva.dao.UserDao;
import com.example.fishva.entities.Settings;
import com.example.fishva.dao.SettingsDao;
import com.example.fishva.entities.Catch;
import com.example.fishva.dao.CatchDao;
import com.example.fishva.entities.Species;
import com.example.fishva.dao.SpeciesDao;

@Database(entities = {User.class, Settings.class, Catch.class, Species.class},
        version = 1, exportSchema = false)
public abstract class FishVADatabase extends RoomDatabase {
    // include abstract methods for ALL Dao interfaces
    public abstract UserDao userDao();
    public abstract SettingsDao settingsDao();
    public abstract CatchDao catchDao();
    public abstract SpeciesDao speciesDao();
    // provide access to a single instance of the class
    private static FishVADatabase INSTANCE;
    public static FishVADatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FishVADatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FishVADatabase.class, "fishva_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
