package com.camila.app_harrypotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User = (EditText) findViewById(R.id.User);
        Password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.btn_login);

        

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
                    finish();
                }else{
                    Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent2);
                }
            }
        });
    }

}