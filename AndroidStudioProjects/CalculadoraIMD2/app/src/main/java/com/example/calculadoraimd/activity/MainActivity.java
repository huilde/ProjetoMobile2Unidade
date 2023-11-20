package com.example.calculadoraimd.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.TopAppBarDefaults;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadoraimd.R;
import com.example.calculadoraimd.helper.SharedPreferencesHelper;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {

    private TextView btnEntrar;
    private TextView btnTrocarSenha;
    private EditText email;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferencesHelper.saveDefaultCredentials(this);

        btnEntrar = findViewById(R.id.entrar);
        email = findViewById(R.id.login);
        senha = findViewById(R.id.senha);

        btnEntrar.setOnClickListener(v -> {
            var username = SharedPreferencesHelper.getSavedUsername(this);
            var password = SharedPreferencesHelper.getSavedPassword(this);


            if (email.getText().toString().equals(username) && senha.getText().toString().equals(password)) {
                var intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            } else {
                Toast
                    .makeText(this, "login ou senha incorreta", Toast.LENGTH_SHORT)
                    .show();
            }
        });


    }

}