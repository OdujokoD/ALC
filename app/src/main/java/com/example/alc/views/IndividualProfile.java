package com.example.alc.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alc.R;
import com.squareup.picasso.Picasso;

public class IndividualProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_profile);

        final Intent intent = getIntent();

        final String name = intent.getStringExtra("User name");
        final String profileLink = intent.getStringExtra("Profile URL");
        final String pictureLink = intent.getStringExtra("Profile photo");

        ImageView userImage = (ImageView)findViewById(R.id.f_image);
        Picasso.with(getApplicationContext())
                .load(pictureLink)
                .into(userImage);

        TextView userName = (TextView)findViewById(R.id.f_name);
        userName.setText(name);

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

    }
}
