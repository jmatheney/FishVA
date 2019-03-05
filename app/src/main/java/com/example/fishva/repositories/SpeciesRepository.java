package com.example.fishva.repositories;

import android.app.Application;
import android.os.AsyncTask;
import com.example.fishva.dao.SpeciesDao;
import com.example.fishva.entities.Species;
import com.example.fishva.db.FishVADatabase;
import androidx.lifecycle.LiveData;
import java.util.List;

public class SpeciesRepository {

    private SpeciesDao speciesDao;
    Species species;

    public SpeciesRepository(Application application) {
        FishVADatabase db = FishVADatabase.getDatabase(application);
        speciesDao = db.speciesDao();
    }

    public void insert(Species... species) {
        new InsertUserAsyncTask(speciesDao).execute(species);
    }

    public void update(Species... species) {
        new UpdateUserAsyncTask(speciesDao).execute(species);
    }

    public void delete(Species... species) {
        new DeleteUserAsyncTask(speciesDao).execute(species);
    }

    public LiveData<List<Species>> loadAllBySpeciesIds(int[] speciesIds) {
        return speciesDao.loadAllBySpeciesIds(speciesIds);
    }

    public LiveData<List<Species>> getAll() {
        return speciesDao.getAll();
    }

    public Species getSpecies() {
        return species;
    }

    public Species findBySpeciesId(int speciesId) {
        return speciesDao.findBySpeciesId(speciesId);
    }

    private static class InsertUserAsyncTask extends AsyncTask<Species, Void, Void> {
        private SpeciesDao speciesDao;

        private InsertUserAsyncTask(SpeciesDao speciesDao) {
            this.speciesDao = speciesDao;
        }

        @Override
        protected Void doInBackground(Species... species) {
            speciesDao.insertAll(species);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<Species, Void, Void> {
        private SpeciesDao speciesDao;

        private DeleteUserAsyncTask(SpeciesDao speciesDao) {
            this.speciesDao = speciesDao;
        }

        @Override
        protected Void doInBackground(Species... species) {
            speciesDao.delete(species);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<Species, Void, Void> {
        private SpeciesDao speciesDao;

        private UpdateUserAsyncTask(SpeciesDao speciesDao) {
            this.speciesDao = speciesDao;
        }

        @Override
        protected Void doInBackground(Species... species) {
            speciesDao.update(species);
            return null;
        }
    }
}
