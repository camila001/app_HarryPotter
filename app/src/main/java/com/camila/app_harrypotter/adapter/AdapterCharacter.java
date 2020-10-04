package com.camila.app_harrypotter.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.camila.app_harrypotter.R;
import com.camila.app_harrypotter.model.Character;

import java.util.List;

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

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder{

        ImageView character_img;
        TextView character_name;


        public CharacterHolder( View itemView) {
            super(itemView);
            character_img = itemView.findViewById(R.id.charater_img);
            character_name = itemView.findViewById(R.id.charater_name);
        }
    }
















}
