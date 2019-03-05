package com.example.fishva.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Index;
import androidx.annotation.NonNull;

@Entity(indices = {@Index(value = {"username"}, unique = true),
        @Index(value = {"email"}, unique = true)})
public class User {
    @PrimaryKey (autoGenerate = true)
    public int id;
    public String username;
    public String email;
    public String password;

    public User(int id, @NonNull String username, @NonNull String password, String email) {
        //id = this.id;
        username = this.username;
        email = this.email;
        password = this.password;

        /*if(email == null) {
            throw new NullPointerException("email is Null");
        }
        if(!email.contains("@") && !email.contains(".")) {
            throw new IllegalArgumentException("invalid email (does not contain . or @" +
                    " symbol)");
        }*/
        /*if(!(!password.equals(password.toLowerCase()))) {
            throw new IllegalArgumentException("password does not contain an uppercase letter");
        }
        if(password.length() < 8) {
            throw new IllegalArgumentException("password must be at least 8 characters");
        }*/
    }

}
