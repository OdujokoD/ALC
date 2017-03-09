package com.example.alc.views;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.alc.R;
import com.example.alc.model.Developer;
import com.example.alc.model.ItemJSON;
import com.example.alc.network.Connection;
import com.example.alc.network.ConnectionService;
import com.example.alc.utility.RecyclerAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class UserActivity extends AppCompatActivity implements RecyclerAdapter.ClickListener {

    private LinearLayout linearLayout;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.user_list);
        recyclerView.setHasFixedSize(true);

        linearLayout = (LinearLayout)findViewById(R.id.activity_user);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        populateRecyclerView();
    }

    @Override
    public void itemClicked(View view, int position) {
        ItemJSON currentUser = recyclerAdapter.getUserByPos(position);
        Intent intent = new Intent(getApplicationContext(), IndividualProfile.class);
        intent.putExtra("User name", currentUser.getUserName());
        intent.putExtra("Profile URL", currentUser.getProfileUrl());
        intent.putExtra("Profile photo", currentUser.getProfilePhoto());
        startActivity(intent);
    }

    private void populateRecyclerView() {

        ConnectionService service = Connection.retrofit.create(ConnectionService.class);
        service.getDevelopers()
                .enqueue(new Callback<Developer>() {
                    @Override
                    public void onResponse(Call<Developer> call, Response<Developer> response) {
                        parseResult(response.body());
                    }

                    @Override
                    public void onFailure(Call<Developer> call, Throwable t) {
                        Snackbar snackbar = Snackbar
                                .make(linearLayout, "Data retrieval failed!", Snackbar.LENGTH_LONG);
                        snackbar.show();

                        Log.d("LOG_TAG", t.toString());
                    }
                });
    }

    private void parseResult(Developer items){
        List<ItemJSON> result = new ArrayList<>();

        for(ItemJSON item : items.getItems()){
            result.add(item);
        }

        loadUsers(result);

    }

    private void loadUsers(List<ItemJSON> developers) {
        recyclerAdapter = new RecyclerAdapter(getApplicationContext(), developers);
        recyclerAdapter.setClickListener(this);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
