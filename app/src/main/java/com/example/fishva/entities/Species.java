package com.example.fishva.entities;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Ignore;
import android.graphics.Bitmap;

@Entity(indices = {@Index(value = {"speciesName"}, unique = true)})
public class Species {
    @PrimaryKey
    public int speciesId;

    public String speciesName;
    public String length;
    public String weight;
    public String habitat;
    public String diet;
    public String picture;

    public Species(int speciesId, String speciesName, String length, String weight, String habitat, String diet) {
        speciesId = this.speciesId;
        speciesName = this.speciesName;
        length = this.length;
        weight = this.weight;
        habitat = this.habitat;
        diet = this.diet;
        if (speciesId == 0) {
            throw new NullPointerException("species id is null");
        }
        if(speciesName == null) {
            throw new NullPointerException("species name is null");
        }
        if (length == null) {
            throw new NullPointerException("length is null");
        }
        if (weight == null) {
            throw new NullPointerException("weight is null");
        }
        if (habitat == null) {
            throw new NullPointerException("habitat is null");
        }
        if (diet == null) {
            throw new NullPointerException("diet is null");
        }
    }
}
