package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfilActivity extends AppCompatActivity {

    @BindView(R.id.profil)
    ImageView profil;
    @BindView(R.id.apName)
    TextView name;
    @BindView(R.id.apAddress)
    TextView address;
    @BindView(R.id.apName2)
    TextView name2;
    @BindView(R.id.apPhone)
    TextView phoneNumber;
    @BindView(R.id.apDescription)
    TextView description;
    @BindView(R.id.apSite)
    TextView site;
    @BindView(R.id.apButton)
    FloatingActionButton button;
    private NeighbourApiService mApiService;
    private Neighbour mNeighbour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        ButterKnife.bind(this);
        Bundle data = getIntent().getExtras();
        mNeighbour = (Neighbour) data.getParcelable("neighbour");
        mApiService = DI.getNeighbourApiService();
        neighbourInfo();

    }

    //Update design
    public void neighbourInfo() {

        name.setText(mNeighbour.getName());
        Glide.with(this)
                .load(mNeighbour.getAvatarUrl())
                .into(profil);
        address.setText(mNeighbour.getAddress());
        name2.setText(mNeighbour.getName());
        phoneNumber.setText(mNeighbour.getPhoneNumber());
        description.setText(mNeighbour.getAboutMe());
        site.setText("www.facebook.fr/" + mNeighbour.getName());
        if (mNeighbour.getIsFavorite()) {
            button.setImageResource(R.drawable.ic_star_white_24dp);
        }

    }


    @OnClick(R.id.apButton)
    void favoriteButton() {

        if (mNeighbour.getIsFavorite()) {
            button.setImageResource(R.drawable.ic_star_border_white_24dp);
        } else {
            button.setImageResource(R.drawable.ic_star_white_24dp);

        }
        mApiService.setFavoriteNeighbour(mNeighbour);


    }

    @OnClick(R.id.apBack)
    void close() {
        finish();
    }

}

