package com.camila.app_harrypotter.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCharacter extends RecyclerView.Adapter<AdapterCharacter.CharacterHolder> {

    public Activity activity;
    public List<Character> list;
    public int character_view;

    public AdapterCharacter(Activity activity, List<Character> list, int character_view) {
        this.activity = activity;
        this.list = list;
        this.character_view = character_view;
    }

    @NonNull
    @Override
    public AdapterCharacter.CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCharacter.CharacterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CharacterHolder extends RecyclerView.ViewHolder{

        public CharacterHolder(View itemView) {
            super(itemView);
        }
    }
}
