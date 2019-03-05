package com.example.fishva.entities;

public enum Brightness {

    LOW("low"), MEDIUM("medium"), HIGH("high");

    private String level;

    Brightness(String level) {
        this.level = level;
    }
}
