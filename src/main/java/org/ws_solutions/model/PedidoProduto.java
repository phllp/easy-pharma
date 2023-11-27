package org.ws_solutions.model;

import org.ws_solutions.db.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoProduto {
    private String id;
    private Produto produto;

    private int quantidade;

    public PedidoProduto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public static ArrayList<Produto> buscarProdutosPedido(String pedidoId) {
        ArrayList<Produto> produtos =  new ArrayList<>();

        String sql = "SELECT * FROM pedidoproduto JOIN produto on pedidoproduto.idproduto = produto.id WHERE idpedido = \'" + pedidoId + "\'";
        Connection con = ConnectionDB.conectar();
        System.out.println("*********************** SELECT PEDIDO PRODUTOS ***************************");
        System.out.println(sql);
        try {
            ResultSet resultado = con.createStatement().executeQuery(sql);
            while (resultado.next()) {
                String idProduto = resultado.getString("idproduto");
                String nomeProduto = resultado.getString("nome");
                String descricaoProduto = resultado.getString("descricao");
                Double preco = resultado.getDouble("preco");

                Produto p = new Produto();
                p.setId(idProduto);
                p.setNome(nomeProduto);
                p.setPreco(preco);
                p.setDescricao(descricaoProduto);


                produtos.add(p);

            }
            ConnectionDB.desconectar(con);
            return produtos;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL ao validar o login do usuário. " + ex.getMessage());
            ConnectionDB.desconectar(con);
            return produtos;
        } catch (Exception ex) {
            System.out.println("Erro ao ao validar o login do usuário. " + ex.getMessage());
            return produtos;
        }
    }
}
