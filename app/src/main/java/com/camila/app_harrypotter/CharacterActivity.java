package com.camila.app_harrypotter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.camila.app_harrypotter.adapter.AdapterCharacter;
import com.camila.app_harrypotter.model.Character;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class CharacterActivity extends AppCompatActivity {
    private static final String URL="http://hp-api.herokuapp.com/api/characters";

    String house;
    TextView character_name;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        processHTTP();


        if (mPlayer != null){
            mPlayer.release();
        }

        mPlayer = MediaPlayer.create(this,R.raw.cancion);
        mPlayer.seekTo(2000);
        mPlayer.start();

    }

    public void onPause(){
        super.onPause();

        if (mPlayer != null){
            mPlayer.release();
        }
    }


    public void processHTTP(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                Log.d("INFO",data);
                processCharacters(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


    public void processCharacters(String data) {
        try {

            JSONArray root = new JSONArray(data);
            List<Character> list = new ArrayList<>();

            for (int i = 0; i<root.length();i++) {
                JSONObject characters = root.getJSONObject(i);

                String name = characters.getString("name");
                String species = characters.getString("species");
                String gender = characters.getString("gender");
                String house = characters.getString("house");
                String dateOfBirth = characters.getString("dateOfBirth");
                String ancestry = characters.getString("ancestry");
                String patronus = characters.getString("patronus");
                String actor = characters.getString("actor");
                String alive = characters.getString("alive");
                String image = characters.getString("image");

                Character character = new Character(name, species,gender, house,dateOfBirth,ancestry,patronus,actor,alive,image);
                list.add(character);
            }

            RecyclerView rc = findViewById(R.id.rc_chara);
            AdapterCharacter ad = new AdapterCharacter(this, list,R.layout.activity_character);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);

            rc.setLayoutManager(lm);
            rc.setAdapter(ad);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}