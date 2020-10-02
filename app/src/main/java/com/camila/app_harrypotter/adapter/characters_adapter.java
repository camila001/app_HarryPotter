package com.camila.app_harrypotter.adapter;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.camila.app_harrypotter.R;

import java.util.List;

public class characters_adapter extends RecyclerView.Adapter<characters_adapter.charactertHolder> {

    public Activity activity;
    public List<Character> list;
    public int character_view;

    public characters_adapter(Activity activity, List<Character> list, int character_view) {
        this.activity = activity;
        this.list = list;
        this.character_view = character_view;
    }

    @NonNull
    @Override
    public charactertHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull charactertHolder holder, int position) {

        Character character = list.get(position);
        holder.characters_name.setText(character.n);
        Glide.with(activity).load(character.);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class charactertHolder extends RecyclerView.ViewHolder{

            ImageView characters_img;
            TextView characters_name;

        public charactertHolder(@NonNull View itemView) {
            super(itemView);
            characters_img = itemView.findViewById(R.id.charaters_img);
            characters_name = itemView.findViewById(R.id.charaters_name);
        }
    }

}
