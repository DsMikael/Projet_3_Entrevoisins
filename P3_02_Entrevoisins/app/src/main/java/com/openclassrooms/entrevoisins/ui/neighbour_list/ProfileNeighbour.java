package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileNeighbour extends AppCompatActivity {


    @BindView(R.id.avatar)
    ImageView avatar;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.firstname)
    TextView firstname;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.phoneNumber)
    TextView phoneNumber;
    @BindView(R.id.website)
    TextView website;
    @BindView(R.id.aboutme)
    TextView aboutme;
    @BindView(R.id.add_fav_neighbour)
    FloatingActionButton fab;

    private final NeighbourApiService mApiService = DI.getNeighbourApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Neighbour neighbour = (Neighbour) i.getSerializableExtra("neighbour");

        Glide.with(this).load(neighbour.getAvatarUrl()).into(avatar);
        name.setText(neighbour.getName());
        firstname.setText(neighbour.getName());
        address.setText(neighbour.getAddress());
        phoneNumber.setText(neighbour.getPhoneNumber());
        website.setText("www.facebook.fr/" + neighbour.getName());
        aboutme.setText(neighbour.getAboutMe());

        if(neighbour.isFavorite()){
            fab.setImageResource(R.drawable.ic_star_white_24dp);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(neighbour.isFavorite()){
                    fab.setImageResource(R.drawable.ic_star_border_white_24dp);
                }else{
                    fab.setImageResource(R.drawable.ic_star_white_24dp);
                }
                mApiService.addFavoriteNeighbour(neighbour);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }



    public static void navigate(Context context, Neighbour neighbour) {
        Intent intent = new Intent(context, ProfileNeighbour.class);
        intent.putExtra("neighbour", neighbour);
        ActivityCompat.startActivity(context, intent, null);
    }

}