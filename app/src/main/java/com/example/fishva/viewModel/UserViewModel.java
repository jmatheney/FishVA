package com.example.fishva.viewModel;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.fishva.entities.User;
import java.util.List;
import androidx.lifecycle.LiveData;
import android.app.Application;
import com.example.fishva.repositories.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;

    public UserViewModel(Application application) {
            super(application);
            userRepository = new UserRepository(application);
            allUsers = userRepository.getAll();
    }

    public LiveData<List<User>> getAll() {
        return allUsers;
    }

    public LiveData<List<User>> loadAllByIds(int[] userIds) {
        return userRepository.loadAllByIds(userIds);
    }

    public User findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public long insert(User user) {
        return userRepository.insert(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
