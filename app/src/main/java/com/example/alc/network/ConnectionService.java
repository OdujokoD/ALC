package com.example.alc.network;

import com.example.alc.model.Developer;
import com.example.alc.model.Individual;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConnectionService {
    @GET("search/users?q=language:java+location:lagos")
    Call<Developer> getDevelopers();

    @GET("/users/{username}")
    Call<Individual> getIndividual(@Path("username") String username);

}
