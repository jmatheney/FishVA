package com.example.fishva.repositories;

import android.app.Application;
import android.os.AsyncTask;
import com.example.fishva.dao.UserDao;
import com.example.fishva.entities.User;
import com.example.fishva.db.FishVADatabase;
import androidx.lifecycle.LiveData;
import java.util.List;

public class UserRepository {

    private UserDao userDao;
    User user;

    public UserRepository(Application application) {
        FishVADatabase db = FishVADatabase.getDatabase(application);
        userDao = db.userDao();
    }

    public long insert(User user) {
        return userDao.insert(user);
    }

    public void update(User... users) {
        new UpdateUserAsyncTask(userDao).execute(users);
    }

    public void delete(User... users) {
        new DeleteUserAsyncTask(userDao).execute(users);
    }

    public LiveData<List<User>> loadAllByIds(int[] userIds) {
        return userDao.loadAllByIds(userIds);
    }

    public LiveData<List<User>> getAll() {
        return userDao.getAll();
    }

    public User getUser() {
        return user;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }



    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        private DeleteUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        private UpdateUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users);
            return null;
        }
    }

}
