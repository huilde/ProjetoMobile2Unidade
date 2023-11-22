package com.example.calculadoraimd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.calculadoraimd.R;
import com.example.calculadoraimd.domain.Produto;
import com.example.calculadoraimd.helper.ProdutoRepository;

import java.util.ArrayList;

public class Listar extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Produto> produtos;
    private ProdutoRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        repository = ProdutoRepository.getInstance();
        startListView();
    }

    public void backToHome(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void startListView() {
        try {
            listView = findViewById(R.id.produtosListView);
            produtos = (ArrayList<Produto>) repository.lerProdutos(this.getFilesDir());
            if (produtos != null && !produtos.isEmpty()) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, produtosToString());
                listView.setAdapter(adapter);
                listView.setOnItemClickListener((adapterView, view, i, l) -> {
                    Produto produto = produtos.get(i);

                    String codigoTexto = "Código: " + produto.getCodigoProduto();
                    String nomeTexto = "Nome: " + produto.getNomeProduto();
                    String descricaoTexto = "Descrição: " + ((produto.getDescricaoProduto() != null) ? produto.getDescricaoProduto() : "");
                    String estoqueTexto = "Estoque: " + produto.getEstoque();
                    String msg = codigoTexto + "\n" + nomeTexto + "\n" + descricaoTexto + "\n" + estoqueTexto;

                    showToast("Detalhes do produto", msg);
                });
            } else {
                System.out.println("No data available for the ListView.");
            }

        } catch (Exception e) {
            showToast("Erro ao listar produtos", "Ocorreu um erro ao listar os produtos");
            e.printStackTrace(); // Print the exception for debugging
        }
    }


    private String[] produtosToString() {
        int tamanhoArrayProdutos = produtos.size();
        String[] produtosArray = new String[tamanhoArrayProdutos];

        for (int i = 0; i < tamanhoArrayProdutos; i++) {
            produtosArray[i] = produtos.get(i).toString();
        }

        return produtosArray;
    }

    private void showToast(String title, String message) {
        Toast.makeText(this, title + "\n" + message, Toast.LENGTH_SHORT).show();
    }
}
