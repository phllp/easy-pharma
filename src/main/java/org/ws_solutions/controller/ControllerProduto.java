package org.ws_solutions.controller;

import org.ws_solutions.model.Produto;

public class ControllerProduto extends ControllerBase {

    public boolean adicionarProduto(String nome, String descricao, String preco, String quantidade) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        try {
            produto.setPreco(Double.parseDouble(preco));
        } catch (NumberFormatException ex) {
            System.out.println("O valor informado para o preço do produto é inválido.");
            return false;
        }
        int quantidadeInt;
        try {
            quantidadeInt = Integer.parseInt(quantidade);
        } catch (NumberFormatException ex) {
            System.out.println("O valor informado para a quantidade de produtos cadastrados é inválido.");
            return false;
        }

        boolean success = produto.criar(quantidadeInt);
        return success;
    }


    public boolean alterarProduto(String id, String nome, String descricao, String preco) {
        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome(nome);
        produto.setDescricao(descricao);
        try {
            System.out.println(preco);
            produto.setPreco(Double.parseDouble(preco));
        } catch (NumberFormatException ex) {
            System.out.println("O valor informado para o preço do produto é inválido." + ex.getMessage());
            return false;
        }
        return produto.atualizar();
    }

    public boolean removerProduto(String id){
        Produto produto = new Produto();
        produto.setId(id);
        return produto.remover();
    }
}
