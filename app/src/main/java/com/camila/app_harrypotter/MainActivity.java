package com.camila.app_harrypotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {



    EditText User, Password;
    Button Login;

    MediaPlayer mPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User = (EditText) findViewById(R.id.User);
        Password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.btn_login);

        if (hayinternet()){
            Login.setOnClickListener(new View.OnClickListener() {



                @Override
                public void onClick(View view) {
                    if (User.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Ingrese un usuario", Toast.LENGTH_SHORT).show();
                    }else if (Password.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Ingresa tu contraseña", Toast.LENGTH_SHORT).show();
                    }else if(User.getText().toString().equals("admin") && Password.getText().toString().equals("123")){
                        Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
                        startActivity(intent);
                    }else{
                        Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent2);
                    }
                }
            });



        } else {
            setContentView(R.layout.empty_internet_activity);
        }

        if (mPlayer != null){
            mPlayer.release();

        }

        mPlayer = MediaPlayer.create(this,R.raw.cancion);
        mPlayer.setLooping(true);
        mPlayer.seekTo(1000);
        mPlayer.start();
        mPlayer.setVolume(10,10);
    }



    public void onPause(){
        super.onPause();

        if (mPlayer != null){
            mPlayer.release();
        }
    }

    public boolean hayinternet(){
        boolean connected = false;

        ConnectivityManager connectivityManager;
        connectivityManager = (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);

        Network [] networks = connectivityManager.getAllNetworks();

        for (Network network : networks){
            NetworkInfo info = connectivityManager.getNetworkInfo(network);
            if (info.isConnected()){
                connected = true;
            }
        }

        return connected;
    }
}