package com.example.calculadoraimd.activity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.calculadoraimd.R;
import com.example.calculadoraimd.domain.Produto;
import com.example.calculadoraimd.helper.ProdutoRepository;

public class Deletar extends AppCompatActivity {
    private EditText codigo;

    private TextView deletar;
    private TextView limpar;
    private AppBarConfiguration appBarConfiguration;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);
        codigo = findViewById(R.id.codigoProduto);
        deletar = findViewById(R.id.salvar);
        limpar = findViewById(R.id.limpar);


        limpar.setOnClickListener(v -> {
            codigo.setText("");
        });

        deletar.setOnClickListener(v -> {
            String codigoStr = codigo.getText().toString();


            if (codigoStr.isEmpty()) {
                Toast
                        .makeText(this, "preencha todos os campos para excluir", Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                ProdutoRepository repository =  ProdutoRepository.getInstance();
                repository.excluirProduto(codigoStr,this.getFilesDir());

                Toast
                        .makeText(this, "produto excluido", Toast.LENGTH_SHORT)
                        .show();
                System.out.println(repository.lerProdutos(this.getFilesDir()));
                finish();
            }
        });


    }

}