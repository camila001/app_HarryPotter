package com.camila.app_harrypotter;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class characters_activity {

   private static final String URL="http://hp-api.herokuapp.com/api/characters ";

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

                JSONObject characters = root.getJSONObject(1);
                String name = characters.getString("name");
                String image = characters.getString("image");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
