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

public class Cadastrar extends AppCompatActivity {
    private EditText codigo;
    private EditText nome;
    private EditText descricao;
    private EditText estoque;

    private TextView salvar;
    private TextView limpar;
    private AppBarConfiguration appBarConfiguration;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        codigo = findViewById(R.id.codigoProduto);
        nome = findViewById(R.id.nomeProduto);
        descricao = findViewById(R.id.descricao);
        estoque = findViewById(R.id.estoque);
        salvar = findViewById(R.id.salvar);
        limpar = findViewById(R.id.limpar);


        limpar.setOnClickListener(v -> {
            nome.setText("");
            descricao.setText("");
            estoque.setText("");
            codigo.setText("");
        });

        salvar.setOnClickListener(v -> {
            String nomeStr = nome.getText().toString();
            String descricaoStr = descricao.getText().toString();
            String estoqueStr = estoque.getText().toString();
            String codigoStr = codigo.getText().toString();


            if (nomeStr.isEmpty() || descricaoStr.isEmpty() || estoqueStr.isEmpty() || codigoStr.isEmpty()) {
                Toast
                        .makeText(this, "preencha todos os campos para salvar", Toast.LENGTH_SHORT)
                        .show();
            }
            else {


                Produto novoProduto = new Produto(codigoStr, nomeStr,descricaoStr,Integer.valueOf(estoqueStr));
                ProdutoRepository repository =  ProdutoRepository.getInstance();
                repository.criarProduto(novoProduto,this.getFilesDir());

                Toast
                        .makeText(this, "produto salvo", Toast.LENGTH_SHORT)
                        .show();
                System.out.println(repository.lerProdutos());
            }
        });


    }

}