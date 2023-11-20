package com.example.calculadoraimd.helper;

import com.example.calculadoraimd.domain.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private static final String ARQUIVO_PRODUTOS = "produtos.dat";
    private static ProdutoRepository instance;

    private ProdutoRepository() {
        // Construtor privado para evitar instanciação direta
    }

    // Método para obter a instância única da classe
    public static synchronized ProdutoRepository getInstance() {
        if (instance == null) {
            instance = new ProdutoRepository();
        }
        return instance;
    }

    // Método para criar um novo produto
    public void criarProduto(Produto produto) {
        List<Produto> produtos = lerProdutos();
        produtos.add(produto);
        salvarProdutos(produtos);
    }

    // Método para ler todos os produtos do arquivo
    public List<Produto> lerProdutos() {
        List<Produto> produtos = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_PRODUTOS))) {
            produtos = (List<Produto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Arquivo ainda não existe ou não pode ser lido
        }

        return produtos;
    }

    // Método para atualizar um produto existente
    public void atualizarProduto(Produto produtoAtualizado) {
        List<Produto> produtos = lerProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getCodigoProduto().equals(produtoAtualizado.getCodigoProduto())) {
                produtos.set(i, produtoAtualizado);
                break;
            }
        }
        salvarProdutos(produtos);
    }

    // Método para excluir um produto
    public void excluirProduto(String codigoProduto) {
        List<Produto> produtos = lerProdutos();
        produtos.removeIf(produto -> produto.getCodigoProduto().equals(codigoProduto));
        salvarProdutos(produtos);
    }

    // Método para salvar a lista de produtos no arquivo
    private void salvarProdutos(List<Produto> produtos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_PRODUTOS))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
