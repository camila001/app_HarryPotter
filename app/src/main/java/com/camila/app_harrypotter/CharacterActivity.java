package com.camila.app_harrypotter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class CharacterActivity extends AppCompatActivity {
    private static final String URL="http://hp-api.herokuapp.com/api/characters";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        processHTTP();
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

                Log.d("INFO", "***************************************");
                Log.d("INFO", name + " " + species + " " + gender + " " + house + " " + dateOfBirth + " " + ancestry + " " + patronus + " " + actor + " " + alive + " " + image);
                Log.d("INFO", "***************************************");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}