package com.example.calculadoraimd;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.calculadoraimd.databinding.ActivityMenuBinding;

public class menu extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMenuBinding binding;
    private TextView btnCadastrar, btnListar, btnAlterar, btnDeletar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCadastrar = findViewById(R.id.cadastrar);
        btnAlterar = findViewById(R.id.alterar);
        btnDeletar = findViewById(R.id.voltar);
        btnListar = findViewById(R.id.listar);
        btnCadastrar.setOnClickListener(v -> {
            Intent intent = new Intent(menu.this, cadastrar.class);

            // Inicie a nova atividade
            startActivity(intent);
        });

        btnAlterar.setOnClickListener(v -> {
            Intent intent = new Intent(menu.this, alterar.class);

            // Inicie a nova atividade
            startActivity(intent);
        });

        btnDeletar.setOnClickListener(v -> {
            Intent intent = new Intent(menu.this, deletar.class);

            // Inicie a nova atividade
            startActivity(intent);
        });

        btnListar.setOnClickListener(v -> {
            Intent intent = new Intent(menu.this, listar.class);

            // Inicie a nova atividade
            startActivity(intent);
        });


    }

}