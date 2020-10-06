package com.camila.app_harrypotter.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.camila.app_harrypotter.DetailActivity;
import com.camila.app_harrypotter.R;
import com.camila.app_harrypotter.model.Character;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterCharacter extends RecyclerView.Adapter<AdapterCharacter.CharacterHolder> {

    public Activity activity;
    public List<Character> list;
    public int activity_character;

    public AdapterCharacter(Activity activity, List<Character> list, int activity_character) {
        this.activity = activity;
        this.list = list;
        this.activity_character = activity_character;
    }

    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(activity_character,parent,false);

        return new CharacterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterHolder holder, int position) {
        Character character = list.get(position);
        holder.character_name.setText(character.name);
        Glide.with(activity).load(character.image).into(holder.character_img);
        holder.ch_alive = character.alive;
        holder.ch_specie = character.species;
        holder.ch_patronus = character.patronus;
        holder.ch_house = character.house;
        holder.ch_ancestry = character.ancestry;
        holder.ch_gender = character.gender;
        holder.ch_birth = character.dateOfBirth;
        holder.ch_actor = character.actor;
        holder.urlImage = character.image;
        if (character.house.equalsIgnoreCase("gryffindor")){
            Glide.with(activity).load(R.drawable.g).into(holder.ch_flag);
        }else if (character.house.equalsIgnoreCase("slytherin")){
            Glide.with(activity).load(R.drawable.s).into(holder.ch_flag);
        }else if (character.house.equalsIgnoreCase("hufflepuff")){
            Glide.with(activity).load(R.drawable.h).into(holder.ch_flag);
        }else if (character.house.equalsIgnoreCase("ravenclaw")){
            Glide.with(activity).load(R.drawable.r).into(holder.ch_flag);
        }else{
            Glide.with(activity).load(R.drawable.non).into(holder.ch_flag);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder{

        TextView character_name;
        CircleImageView character_img;
        RelativeLayout ch_card;
        ImageView ch_flag;

        String urlImage, ch_alive, ch_specie, ch_gender, ch_ancestry, ch_house, ch_patronus, ch_birth, ch_actor;

        public CharacterHolder( View itemView) {
            super(itemView);
            character_img = itemView.findViewById(R.id.charater_img);
            character_name = itemView.findViewById(R.id.charater_name);
            ch_card = itemView.findViewById(R.id.ch_card);
            ch_flag = itemView.findViewById(R.id.ch_flag);

            ch_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DetailActivity.class);
                    intent.putExtra("NAME", character_name.getText().toString());
                    intent.putExtra("IMAGE", urlImage);
                    intent.putExtra("ALIVE", ch_alive);
                    intent.putExtra("SPECIE", ch_specie);
                    intent.putExtra("GENDER", ch_gender);
                    intent.putExtra("ANC", ch_ancestry);
                    intent.putExtra("HOUSE", ch_house);
                    intent.putExtra("PATRONUS", ch_patronus);
                    intent.putExtra("BIRTH", ch_birth);
                    intent.putExtra("ACTOR", ch_actor);

                    activity.startActivity(intent);

                }
            });


        }
    }
















}
