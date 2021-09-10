package com.example.interntask.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "Country_Flag")
    public String flag;

    @ColumnInfo(name = "Country_Name")
    public String name;

    @ColumnInfo(name = "Country_Capital")
    public String capital;

    @ColumnInfo(name = "Country_Region")
    public String region;

    @ColumnInfo(name = "Country_SubRegion")
    public String subRegion;

    @ColumnInfo(name = "Country_Population")
    public String population;
}
