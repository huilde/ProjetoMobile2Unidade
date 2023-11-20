package com.example.calculadoraimd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.calculadoraimd.R;

public class MainActivity extends AppCompatActivity {

private TextView btnEntrar, btnTrocarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnEntrar = findViewById(R.id.entrar);
        btnEntrar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Menu.class);

            // Inicie a nova atividade
            startActivity(intent);
        });

    }
}