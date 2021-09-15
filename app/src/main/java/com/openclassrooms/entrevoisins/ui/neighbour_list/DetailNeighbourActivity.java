package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailNeighbourActivity extends AppCompatActivity {


    boolean favorite;
    @BindView(R.id.detailavatar)
    ImageView detailavatar;
    @BindView(R.id.detailnamepicture)
    TextView namePicture;
    @BindView(R.id.detailname)
    TextView detailname;
    @BindView(R.id.detailphone)
    TextView phone;
    @BindView(R.id.detailaddress)
    TextView address;
    @BindView(R.id.detailsocial)
    TextView social;
    @BindView(R.id.detailaboutme)
    TextView aboutMe;
    @BindView(R.id.fabAddfavorite)
    FloatingActionButton fabAddFavorite;
    @BindView(R.id.detailback)
    ImageButton detailBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);
        Intent intentDetail = getIntent();
        detailname.setText(intentDetail.getStringExtra(
                "Name"));
        namePicture.setText(intentDetail.getStringExtra(
                "Name"));
        phone.setText(intentDetail.getStringExtra(
                "Phone"));
        aboutMe.setText(intentDetail.getStringExtra(
                "AboutMe"));
        social.setText(intentDetail.getStringExtra(
                "Social"));
        address.setText(intentDetail.getStringExtra(
                "Adress"));
        Glide.with(DetailNeighbourActivity.this)
                .load(intentDetail.getStringExtra(
                        "AvatarUrl"))
                .centerCrop()
                .into(detailavatar);

        if (intentDetail.getBooleanExtra("favorite",true)) {
            fabAddFavorite.setImageResource(R.drawable.ic_star_white_24dp);
            fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));

        } else {
            fabAddFavorite.setImageResource(R.drawable.ic_star_border_white_24dp);
            fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));
        }
    }

    @OnClick(R.id.detailback)
    void returnBack() {
        finish();

    }

    @OnClick(R.id.fabAddfavorite)

    public void fabAddFavorite() {
        favorite = !favorite;
        if (favorite) {
            fabAddFavorite.setImageResource(R.drawable.ic_star_white_24dp);
            fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));

        }
        else {
            fabAddFavorite.setImageResource(R.drawable.ic_star_border_white_24dp);
            fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));
        }


    }

    public static Intent navigate (Context context, Neighbour neighbour){
        Intent intentDetailNeighbourActivity = new Intent (context, DetailNeighbourActivity.class);
        intentDetailNeighbourActivity.putExtra("EXTRA_NEIGHBOUR",Neighbour.class);
        intentDetailNeighbourActivity.putExtra("Name", neighbour.getName());
        intentDetailNeighbourActivity.putExtra("Phone", neighbour.getPhoneNumber());
        intentDetailNeighbourActivity.putExtra("Adress", neighbour.getAddress());
        intentDetailNeighbourActivity.putExtra("Social", neighbour.getSocial());
        intentDetailNeighbourActivity.putExtra("AboutMe", neighbour.getAboutMe());
        intentDetailNeighbourActivity.putExtra("AvatarUrl", neighbour.getAvatarUrl());
        intentDetailNeighbourActivity.putExtra("favorite", neighbour.isFavorite());
        return intentDetailNeighbourActivity;
    }
}

