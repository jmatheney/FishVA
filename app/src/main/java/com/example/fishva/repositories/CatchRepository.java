package com.example.fishva.repositories;

import android.app.Application;
import android.os.AsyncTask;
import com.example.fishva.dao.CatchDao;
import com.example.fishva.entities.Catch;
import com.example.fishva.db.FishVADatabase;
import androidx.lifecycle.LiveData;
import java.util.List;

public class CatchRepository {

    private CatchDao catchDao;
    Catch caught;

    public CatchRepository(Application application) {
        FishVADatabase db = FishVADatabase.getDatabase(application);
        catchDao = db.catchDao();
    }

    public void insert(Catch... caught) {
        new InsertUserAsyncTask(catchDao).execute(caught);
    }

    public void update(Catch... caught) {
        new UpdateUserAsyncTask(catchDao).execute(caught);
    }

    public void delete(Catch... caught) {
        new DeleteUserAsyncTask(catchDao).execute(caught);
    }

    public LiveData<List<Catch>> loadAllByIds(int[] catchIds) {
        return catchDao.loadAllByIds(catchIds);
    }

    public LiveData<List<Catch>> getAll() {
        return catchDao.getAll();
    }

    public Catch getCatch() {
        return caught;
    }

    public Catch findByCatchId(int catchId) {
        return catchDao.findByCatchId(catchId);
    }

    private static class InsertUserAsyncTask extends AsyncTask<Catch, Void, Void> {
        private CatchDao catchDao;

        private InsertUserAsyncTask(CatchDao catchDao) {
            this.catchDao = catchDao;
        }

        @Override
        protected Void doInBackground(Catch... caught) {
            catchDao.insertAll(caught);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<Catch, Void, Void> {
        private CatchDao catchDao;

        private DeleteUserAsyncTask(CatchDao catchDao) {
            this.catchDao = catchDao;
        }

        @Override
        protected Void doInBackground(Catch... caught) {
            catchDao.delete(caught);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<Catch, Void, Void> {
        private CatchDao catchDao;

        private UpdateUserAsyncTask(CatchDao catchDao) {
            this.catchDao = catchDao;
        }

        @Override
        protected Void doInBackground(Catch... caught) {
            catchDao.update(caught);
            return null;
        }
    }
}