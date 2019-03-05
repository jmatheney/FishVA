package com.example.fishva.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Index;

@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "userId"))
public class Settings {
    @PrimaryKey
    public int userId;

    public String brightness;
    public String textSize;
    public String color;
    public String notifications;

    public Settings(int userId, String brightness, String textSize, String color, String notifications) {
        userId = this.userId;
        brightness = this.brightness;
        textSize = this.brightness;
        color = this.color;
        notifications = this.notifications;
        if(userId == 0) {
            throw new NullPointerException("id is null");
        }
        if(brightness == null) {
            throw new NullPointerException("brightness is null");
        }
        if(textSize == null) {
            throw new NullPointerException("textSize is null");
        }
        if(color == null) {
            throw new NullPointerException("color is null");
        }
        if(notifications == null) {
            throw new NullPointerException("notifications is null");
        }
    }
}
