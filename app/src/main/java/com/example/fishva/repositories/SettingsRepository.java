package com.example.fishva.repositories;

import android.app.Application;
import android.os.AsyncTask;
import com.example.fishva.dao.SettingsDao;
import com.example.fishva.entities.Settings;
import com.example.fishva.db.FishVADatabase;
import androidx.lifecycle.LiveData;
import java.util.List;

public class SettingsRepository {

    private SettingsDao settingsDao;
    Settings settings;

    public SettingsRepository(Application application) {
        FishVADatabase db = FishVADatabase.getDatabase(application);
        settingsDao = db.settingsDao();
    }

    public void insert(Settings... settings) {
        new InsertUserAsyncTask(settingsDao).execute(settings);
    }

    public void update(Settings... settings) {
        new UpdateUserAsyncTask(settingsDao).execute(settings);
    }

    public void delete(Settings... settings) {
        new DeleteUserAsyncTask(settingsDao).execute(settings);
    }

    public LiveData<List<Settings>> loadAllByIds(int[] userIds) {
        return settingsDao.loadAllByIds(userIds);
    }

    public LiveData<List<Settings>> getAll() {
        return settingsDao.getAll();
    }

    public Settings getSettings() {
        return settings;
    }

    public Settings findByUserId(int userId) {
        return settingsDao.findByUserId(userId);
    }

    private static class InsertUserAsyncTask extends AsyncTask<Settings, Void, Void> {
        private SettingsDao settingsDao;

        private InsertUserAsyncTask(SettingsDao settingsDao) {
            this.settingsDao = settingsDao;
        }

        @Override
        protected Void doInBackground(Settings... settings) {
            settingsDao.insertAll(settings);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<Settings, Void, Void> {
        private SettingsDao settingsDao;

        private DeleteUserAsyncTask(SettingsDao settingsDao) {
            this.settingsDao = settingsDao;
        }

        @Override
        protected Void doInBackground(Settings... settings) {
            settingsDao.delete(settings);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<Settings, Void, Void> {
        private SettingsDao settingsDao;

        private UpdateUserAsyncTask(SettingsDao settingsDao) {
            this.settingsDao = settingsDao;
        }

        @Override
        protected Void doInBackground(Settings... settings) {
            settingsDao.update(settings);
            return null;
        }
    }
}
