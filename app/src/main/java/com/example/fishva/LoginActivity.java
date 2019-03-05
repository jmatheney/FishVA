package com.example.fishva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.Observer;
import java.util.List;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import com.example.fishva.db.FishVADatabase;
import com.example.fishva.entities.User;
import com.example.fishva.viewModel.UserViewModel;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.CheckBox;
import android.util.Log;

public class LoginActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    String TAG = "CREATEACCOUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        /*CheckBox cb = (CheckBox) findViewById(R.id.loginCheckBox);
        boolean isChecked = cb.isChecked();
        cb.setChecked(isChecked);
        sharedPref.edit().putBoolean(getString(R.string.prefStayLoggedInKey), cb.isChecked()).apply();
        sharedPref.getBoolean(getString(R.string.prefStayLoggedInKey), false);*/

        userViewModel.getAll().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for (User user: users) {
                    Log.d(TAG, "user: " + user.username);
                }
            }
        });

    }

    public void openHome(View v) {
        EditText userNameET = findViewById(R.id.loginUsername);
        String username = userNameET.getText().toString();
        EditText passwordET = findViewById(R.id.loginPassword);
        String password = passwordET.getText().toString();
        Log.d(TAG, "attempting to get user by username: " + username);

        User user = userViewModel.findByUsername(username);

        if(user != null) {
            Log.d(TAG, "user is not null");
            if (user.password.equals(password)) {
                Intent intent = new Intent(this, home.class);
                startActivity(intent);
                finish();
            }
        }
        else {
            Log.d(TAG, "user is null");

            userNameET.getText().clear();
            passwordET.getText().clear();
        }
    }

    public void openCreateAccount(View v) {
        Intent intent = new Intent(this, createAccount.class);
        startActivity(intent);
    }
}
