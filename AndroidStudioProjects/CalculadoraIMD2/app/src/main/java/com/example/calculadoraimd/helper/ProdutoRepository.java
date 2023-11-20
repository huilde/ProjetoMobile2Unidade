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
    public void criarProduto(Produto produto,  File diretorioInterno) {
        List<Produto> produtos = lerProdutos();
        produtos.add(produto);
        salvarProdutos(produtos, diretorioInterno);
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
    public void atualizarProduto(Produto produtoAtualizado,File diretorioInterno) {
        List<Produto> produtos = lerProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getCodigoProduto().equals(produtoAtualizado.getCodigoProduto())) {
                produtos.set(i, produtoAtualizado);
                break;
            }
        }
        salvarProdutos(produtos, diretorioInterno);
    }

    // Método para excluir um produto
    public void excluirProduto(String codigoProduto,File diretorioInterno) {
        List<Produto> produtos = lerProdutos();
        produtos.removeIf(produto -> produto.getCodigoProduto().equals(codigoProduto));
        salvarProdutos(produtos,diretorioInterno);
    }

    // Método para salvar a lista de produtos no arquivo
    private void salvarProdutos(List<Produto> produtos, File diretorioInterno) {
        File file = new File(diretorioInterno, ARQUIVO_PRODUTOS);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
