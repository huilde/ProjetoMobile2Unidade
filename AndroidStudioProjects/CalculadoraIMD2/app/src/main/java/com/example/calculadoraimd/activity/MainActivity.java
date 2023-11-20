package com.example.calculadoraimd.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadoraimd.R;
import com.example.calculadoraimd.helper.SharedPreferencesHelper;

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
        btnTrocarSenha = findViewById(R.id.esqueciSenha);
        email = findViewById(R.id.login);
        senha = findViewById(R.id.senha);

        btnEntrar.setOnClickListener(v -> {
            String username = SharedPreferencesHelper.getSavedUsername(this);
            String password = SharedPreferencesHelper.getSavedPassword(this);


            if (email.getText().toString().equals(username) && senha.getText().toString().equals(password)) {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            } else {
                Toast
                    .makeText(this, "login ou senha incorreta", Toast.LENGTH_SHORT)
                    .show();
            }
        });

        btnTrocarSenha.setOnClickListener(v -> {
            exibirDialogo();
        });
    }

    private void exibirDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_mudar_login_senha, null);
        builder.setView(dialogView);

        final EditText novoLoginEditText = dialogView.findViewById(R.id.editTextNovoLogin);
        final EditText novaSenhaEditText = dialogView.findViewById(R.id.editTextNovaSenha);

        // Configurar o botão positivo (Salvar)
        builder.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String novoLogin = novoLoginEditText.getText().toString();
                String novaSenha = novaSenhaEditText.getText().toString();
                SharedPreferencesHelper.saveCredentials(getApplicationContext(),novoLogin,novaSenha);
                // Faça algo com os novos dados (por exemplo, salvar no SharedPreferences)
                // Aqui você pode substituir esta lógica pela que você precisa
            }
        });

        // Configurar o botão negativo (Cancelar)
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Nada a fazer aqui, apenas fechar o diálogo
            }
        });

        builder.show();
    }

}