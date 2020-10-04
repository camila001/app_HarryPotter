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
        holder.ch_alive.setText(character.alive);
        holder.ch_specie.setText(character.species);
        holder.ch_gender.setText(character.gender);
        holder.ch_ancestry.setText(character.ancestry);
        holder.ch_house.setText(character.house);
        holder.ch_patronus.setText(character.patronus);
        holder.ch_birth.setText(character.dateOfBirth);
        holder.ch_actor.setText(character.actor);
        Glide.with(activity).load(character.image).into(holder.ch_image);
        holder.urlImage = character.image;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder{

        ImageView character_img;
        TextView character_name, ch_alive, ch_specie, ch_gender, ch_ancestry, ch_house, ch_patronus, ch_birth, ch_actor;;
        CircleImageView ch_image;
        RelativeLayout ch_card;

        String urlImage;

        public CharacterHolder( View itemView) {
            super(itemView);
            character_img = itemView.findViewById(R.id.charater_img);
            character_name = itemView.findViewById(R.id.charater_name);
            ch_card = itemView.findViewById(R.id.ch_card);

            ch_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DetailActivity.class);
                    intent.putExtra("NAME", character_name.getText().toString());
                    intent.putExtra("IMAGE", urlImage);
                    intent.putExtra("ALIVE", ch_alive.getText().toString());
                    intent.putExtra("SPECIE", ch_specie.getText().toString());
                    intent.putExtra("GENDER", ch_gender.getText().toString());
                    intent.putExtra("ANC", ch_ancestry.getText().toString());
                    intent.putExtra("HOUSE", ch_house.getText().toString());
                    intent.putExtra("PATRONUS", ch_patronus.getText().toString());
                    intent.putExtra("BIRTH", ch_birth.getText().toString());
                    intent.putExtra("ACTOR", ch_actor.getText().toString());

                    activity.startActivity(intent);

                }
            });

        }
    }
















}
