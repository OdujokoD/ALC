package com.example.alc.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alc.R;
import com.example.alc.model.Individual;
import com.example.alc.network.Connection;
import com.example.alc.network.ConnectionService;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndividualProfile extends AppCompatActivity {

    private TextView fullname;
    private TextView followers;
    private TextView following;
    private TextView repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_profile);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_1);
        setSupportActionBar(toolbar);*/

        final Intent intent = getIntent();
        final String name = intent.getStringExtra("User name");
        final String profileLink = intent.getStringExtra("Profile URL");
        final String pictureLink = intent.getStringExtra("Profile photo");

        ConnectionService service = Connection.retrofit.create(ConnectionService.class);
        service.getIndividual(name)
                .enqueue(new Callback<Individual>() {
                    @Override
                    public void onResponse(Call<Individual> call, Response<Individual> response) {
                        Log.d("Individual ", response.body().getName());
                        populateSubView(response.body());
                    }

                    @Override
                    public void onFailure(Call<Individual> call, Throwable t) {
                        Log.d("LOG_TAG", t.toString());
                    }
                });

        ImageView userImage = (ImageView)findViewById(R.id.f_image);
        Picasso.with(getApplicationContext())
                .load(pictureLink)
                .into(userImage);

        TextView userName = (TextView)findViewById(R.id.f_name);
        userName.setText("@" + name);

        TextView profileUrl = (TextView)findViewById(R.id.f_url);
        profileUrl.setText(profileLink);

        profileUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(profileLink);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        Button shareBtn = (Button)findViewById(R.id.share_btn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder intentText = new StringBuilder();
                intentText.append("Check out this awesome developer @");
                intentText.append(name);
                intentText.append(", ");
                intentText.append(profileLink);

                Intent shareProfile = new Intent();
                shareProfile.setAction(Intent.ACTION_SEND);
                shareProfile.putExtra(Intent.EXTRA_TEXT, intentText.toString());
                shareProfile.setType("text/plain");
                startActivity(Intent.createChooser(shareProfile, getResources().getText(R.string.share)));
            }
        });

        fullname = (TextView)findViewById(R.id.full_name);
        followers = (TextView)findViewById(R.id.followers);
        following = (TextView)findViewById(R.id.following);
        repos = (TextView)findViewById(R.id.repos);

    }

    private void populateSubView(Individual individual){
        fullname.setText(individual.getName());
        followers.setText(individual.getFollowers());
        following.setText(individual.getFollowing());
        repos.setText(individual.getPublicRepos());
    }
}
