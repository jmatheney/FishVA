package com.example.fishva;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.lifecycle.ViewModelProviders;
import com.example.fishva.viewModel.UserViewModel;
import com.example.fishva.entities.User;
import android.content.SharedPreferences;
import android.util.Log;

public class createAccount extends AppCompatActivity {

    Button createAccountButton;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        /*CheckBox cb = (CheckBox) findViewById(R.id.createAcctCheckBox);
        boolean isChecked = cb.isChecked();
        cb.setChecked(isChecked);
        sharedPref.edit().putBoolean(getString(R.string.prefStayLoggedInKey), cb.isChecked()).apply();
        sharedPref.getBoolean(getString(R.string.prefStayLoggedInKey), false);*/

        createAccountButton = (Button) findViewById(R.id.createButton);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

    }

    public void openHome() {
        EditText userNameET = findViewById(R.id.createAcctUsername);
        String username = userNameET.getText().toString();
        String TAG = "CREATEACCOUNT";
        Log.i(TAG, "Username: " + username);

        EditText passwordET = findViewById(R.id.createAcctPassword);
        String password = passwordET.getText().toString();
        Log.i(TAG, "Password: " + password);

        User user = new User(0, username, password, "");
        long id = userViewModel.insert(user);
        Log.d(TAG, "userid: " + id);

        /*SharedPreferences sharedPref = getSharedPreferences(
            getString(R.string.fishVASharedPreferences), Context.MODE_PRIVATE);
        sharedPref.edit().putString(getString(R.string.prefCurrentUserUsernameKey), user.getUser().username).apply();*/
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}
