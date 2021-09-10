package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailNeighbourActivity extends AppCompatActivity {


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

    boolean favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);
        Intent x = getIntent();
        detailname.setText(x.getStringExtra(
                "Name"));
        namePicture.setText(x.getStringExtra(
                "Name"));
        phone.setText(x.getStringExtra(
                "Phone"));
        aboutMe.setText(x.getStringExtra(
                "AboutMe"));
        social.setText(x.getStringExtra(
                "Social"));
        address.setText(x.getStringExtra(
                "Adress"));
        Glide.with(DetailNeighbourActivity.this)
                .load(x.getStringExtra(
                        "AvatarUrl"))
                .centerCrop()
                .into(detailavatar);


        if (favorite = x.getBooleanExtra("favorite", true)) {
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

        public void fabAddFavorite () {
         favorite = !favorite;
           if (favorite) {
                fabAddFavorite.setImageResource(R.drawable.ic_star_white_24dp);
                fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));


            } else {
                fabAddFavorite.setImageResource(R.drawable.ic_star_border_white_24dp);
                fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));


            }
}
}

