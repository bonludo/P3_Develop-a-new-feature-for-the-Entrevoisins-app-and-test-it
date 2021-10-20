package com.openclassrooms.entrevoisins.ui.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourRepository;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("NonConstantResourceId")
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

    private static final String EXTRA_NEIGHBOUR = "EXTRA_NEIGHBOUR";
    private NeighbourRepository mApiService;

    public static Intent navigate(Context context, Neighbour neighbour) {
        Intent intentDetailNeighbourActivity = new Intent(context, DetailNeighbourActivity.class);
        intentDetailNeighbourActivity.putExtra(EXTRA_NEIGHBOUR, neighbour);
        return intentDetailNeighbourActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourRepository();
        getSupportActionBar().hide();
        Neighbour neighbour = (Neighbour) getIntent().getSerializableExtra(EXTRA_NEIGHBOUR);
        detailname.setText(neighbour.getName());
        namePicture.setText(neighbour.getName());
        phone.setText(neighbour.getPhoneNumber());
        aboutMe.setText(neighbour.getAboutMe());
        social.setText(neighbour.getSocial());
        address.setText(neighbour.getAddress());
        Glide.with(DetailNeighbourActivity.this)
                .load(neighbour.getAvatarUrl())
                .centerCrop()
                .into(detailavatar);

        favorite = neighbour.isFavorite() ;

        if (favorite) {
            fabAddFavorite.setImageResource(R.drawable.ic_star_white_24dp);
            fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));
        } else {
            fabAddFavorite.setImageResource(R.drawable.ic_star_border_white_24dp);
            fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));

        }

        fabAddFavorite.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                favorite = !favorite;

                if (favorite) {
                    fabAddFavorite.setImageResource(R.drawable.ic_star_white_24dp);
                    fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));
                     mApiService.setFavorite(neighbour,favorite);
                    Toast.makeText(DetailNeighbourActivity.this, "Add to Favorite", Toast.LENGTH_SHORT).show();
                } else {
                    fabAddFavorite.setImageResource(R.drawable.ic_star_border_white_24dp);
                    fabAddFavorite.setColorFilter(Color.parseColor("#FECB23"));
                    mApiService.setFavorite(neighbour,favorite);
                    Toast.makeText(DetailNeighbourActivity.this, "Remove on favorite", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @OnClick(R.id.detailback)
    void returnBack() {
        finish();

    }

}

