package com.example.alc.network;

import com.example.alc.model.Developer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConnectionService {
    @GET("search/users?q=language:java")
    Call<Developer> getDevelopers();
}
