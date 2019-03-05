package com.example.fishva.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Index;

@Entity(indices = {@Index("owner")}, foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "owner"))
public class Catch {
    @PrimaryKey
    public int catchId;

    public String owner;
    public String time;
    public String date;
    public String location;
    public String species;
    public String length;
    public String weight;
    public String baitUsed;
    public String picture;

    public Catch(int catchId, String owner, String time, String date, String location, String species, String length, String weight, String baitUsed, String picture) {
        catchId= this.catchId;
        owner = this.owner;
        time = this.time;
        date = this.date;
        location = this.location;
        species = this.species;
        length = this.length;
        weight = this.weight;
        baitUsed = this.baitUsed;
        picture = this.picture;
        if(catchId == 0) {
            throw new NullPointerException("catch id is null");
        }
        if(owner == null) {
            throw new NullPointerException("owner is null");
        }
        if(time == null) {
            throw new NullPointerException("time is null");
        }
        if(date == null) {
            throw new NullPointerException("date is null");
        }
        if(location == null) {
            throw new NullPointerException("location is null");
        }
        if(length == null) {
            throw new NullPointerException("length is null");
        }
        if(weight == null) {
            throw new NullPointerException("weight is null");
        }
        if(baitUsed == null) {
            throw new NullPointerException("bait used is null");
        }
        if(picture == null) {
            throw new NullPointerException("picture is null");
        }
    }
}
