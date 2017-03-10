package com.example.alc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Developer {
    @SerializedName("items")
    @Expose
    public List<ItemJSON> items;

    public List<ItemJSON> getItems() {
        return items;
    }

    public void setItems(List<ItemJSON> items) {
        this.items = items;
    }
}
