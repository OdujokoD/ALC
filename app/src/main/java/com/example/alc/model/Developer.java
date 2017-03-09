package com.example.alc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Developer {
    @SerializedName("total_count")
    @Expose
    public int total_count;
    @SerializedName("incomplete_results")
    @Expose
    public boolean incomplete_results;
    @SerializedName("items")
    @Expose
    public List<ItemJSON> items;

    public int getTotalCounts() {
        return total_count;
    }

    public void setTotalCounts(int total_count) {
        this.total_count = total_count;
    }

    public boolean getIncompleteResult() {
        return incomplete_results;
    }

    public void setIncompleteResult(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<ItemJSON> getItems() {
        return items;
    }

    public void setItems(List<ItemJSON> items) {
        this.items = items;
    }
}
