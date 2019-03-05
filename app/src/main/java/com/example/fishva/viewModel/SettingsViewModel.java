package com.example.fishva.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.fishva.entities.Settings;
import java.util.List;
import androidx.lifecycle.LiveData;
import android.app.Application;
import com.example.fishva.repositories.SettingsRepository;

public class SettingsViewModel extends ViewModel {
    private SettingsRepository settingsRepository;
    private LiveData<List<Settings>> allSettings;
    private Settings settings;
    private LiveData<List<Settings>> loadAll;
    int[] userIds;
    int userId;
    private Settings findByUserId;
    public SettingsViewModel(Application application) {
        //super(application);
        settingsRepository = new SettingsRepository(application);
        allSettings = settingsRepository.getAll();
        settings = settingsRepository.getSettings();
        loadAll = settingsRepository.loadAllByIds(userIds);
        findByUserId = settingsRepository.findByUserId(userId);
    }

    LiveData<List<Settings>> getAll() {
        return allSettings;
    }

    Settings getSettings() {
        return settings;
    }

    LiveData<List<Settings>> loadAllByIds(int[] userIds) {
        return loadAll;
    }

    public Settings findByUserId(int userId) {
        return findByUserId;
    }

    public void insert(Settings settings) {
        settingsRepository.insert(settings);
    }

    public void update(Settings settings) {
        settingsRepository.update(settings);
    }

    public void delete(Settings settings) {
        settingsRepository.delete(settings);
    }
}
