package com.camila.app_harrypotter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    String name, specie, gender, house, birth, ancestry, patronus, alive, actor, img;
    TextView ch_name, ch_alive, ch_specie, ch_gender, ch_ancestry, ch_house, ch_patronus, ch_birth, ch_actor;
    CircleImageView ch_image;
    ImageView img_house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_character);

        name = getIntent().getStringExtra("NAME");
        specie = getIntent().getStringExtra("SPECIE");
        gender = getIntent().getStringExtra("GENDER");
        house = getIntent().getStringExtra("HOUSE");
        birth = getIntent().getStringExtra("BIRTH");
        ancestry = getIntent().getStringExtra("ANC");
        patronus = getIntent().getStringExtra("PATRONUS");
        alive = getIntent().getStringExtra("ALIVE");
        actor = getIntent().getStringExtra("ACTOR");
        img = getIntent().getStringExtra("IMAGE");

        ch_name = findViewById(R.id.ch_name);
        ch_alive = findViewById(R.id.ch_alive);
        ch_specie = findViewById(R.id.ch_specie);
        ch_gender = findViewById(R.id.ch_gender);
        ch_ancestry = findViewById(R.id.ch_ancestry);
        ch_house = findViewById(R.id.ch_house);
        ch_patronus = findViewById(R.id.ch_patronus);
        ch_birth = findViewById(R.id.ch_birth);
        ch_actor = findViewById(R.id.ch_actor);
        ch_image = findViewById(R.id.ch_image);
        img_house = findViewById(R.id.img_house);

        ch_name.setText(name);
        ch_specie.setText(specie);
        ch_gender.setText(gender);
        ch_house.setText(house);
        ch_birth.setText(birth);
        ch_ancestry.setText(ancestry);
        ch_patronus.setText(patronus);
        ch_actor.setText(actor);
        Glide.with(this).load(img).into(ch_image);

        if (alive.equalsIgnoreCase("true")){
            ch_alive.setText("Alive");
        }else{
            ch_alive.setText("Dead");
        }

        if (house.equalsIgnoreCase("gryffindor")){
            Glide.with(this).load(R.drawable.gryffindor).into(img_house);
        }else if (house.equalsIgnoreCase("slytherin")){
            Glide.with(this).load(R.drawable.slytherin).into(img_house);
        }else if (house.equalsIgnoreCase("hufflepuff")){
            Glide.with(this).load(R.drawable.hufflepuff).into(img_house);
        }else if (house.equalsIgnoreCase("ravenclaw")){
            Glide.with(this).load(R.drawable.ravenclaw).into(img_house);
        }else {
            Glide.with(this).load(R.drawable.hp).into(img_house);
        }
    }
}