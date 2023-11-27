package org.ws_solutions.model;

import org.ws_solutions.db.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class Produto {

    private String id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto() {
    }

    public Produto(String id, String nome, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Insere um registro de produto no banco de dados
     * @param quantidade
     * @return boolean
     */
    public boolean criar(int quantidade) {
        String uuidProduto = "\'" + UUID.randomUUID().toString() + "\'";
        String nomeProduto = "\'" + this.getNome() + "\'";
        String descricaoProduto = "\'" + this.getDescricao() + "\'";
        Double precoProduto = this.getPreco();

        String insertProduto = "INSERT INTO produto (id, nome, descricao, preco) " +
                "VALUES (" + uuidProduto + ", " + nomeProduto + ", " + descricaoProduto + ", " + precoProduto + ")";

        Connection con = ConnectionDB.conectar();
        try {
            boolean resultado = con.createStatement().execute(insertProduto);

            for (int i = 0; i < quantidade; i++) {
                String uuidItem = "\'" + UUID.randomUUID().toString() + "\'";
                String insertProdutoItem = "INSERT INTO produtoItem (id, idproduto) " +
                        "VALUES (" + uuidItem + ", " + uuidProduto + ")";
                con.createStatement().execute(insertProdutoItem);
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL ao inserir os dados do Produto: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Erro ao inserir dados do Produto: " + ex.getMessage());
            return false;
        } finally {
            ConnectionDB.desconectar(con);
        }
    }

    /**
     * Retorna todos os Produtos cadastrados
     * @return ArrayList<Produto>
     */
    public static ArrayList<Produto> buscarTodos() {
        ArrayList<Produto> produtos =  new ArrayList<>();

        String sql = "SELECT * FROM produto;";
        Connection con = ConnectionDB.conectar();
        try {
            ResultSet resultado = con.createStatement().executeQuery(sql);
            while (resultado.next()) {
                String id = resultado.getString("id");
                String nome = resultado.getString("nome");
                String descricao = resultado.getString("descricao");
                Double preco = resultado.getDouble("preco");

                Produto produto = new Produto(id, nome, descricao, preco);
                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL ao validar o login do usuário. " + ex.getMessage());
            return produtos;
        }
        finally {
            ConnectionDB.desconectar(con);
        }
    }

    /**
     * Realiza a contagem e retorna a quantidade de items em estoque para um Produto
     * @param produto
     * @return int
     */
    public static int getQuantidadeEstoque(Produto produto) {
        String uuidProduto = "\'" + produto.getId().toString() + "\'";

        String sql = "SELECT COUNT(*) FROM produtoitem WHERE idproduto = " + uuidProduto + ";";
        System.out.println(sql);
        Connection con = ConnectionDB.conectar();
        try {
            ResultSet resultado = con.createStatement().executeQuery(sql);
            resultado.next();
            return resultado.getInt(1);
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a quantidade de itens em estoque.");
        } finally {
            ConnectionDB.desconectar(con);
        }
        return 0;
    }

    /**
     * Atualiza os dados de um produto específico
     * @return boolean
     */
    public boolean atualizar() {
        String nome = this.getNome();
        String descricao = this.getDescricao();
        Double preco = this.getPreco();
        String uuid = this.getId();
        String sql = "UPDATE produto SET descricao =  \'" +descricao + "\', nome = \'" +nome+ "\', preco = " + preco + " WHERE id = \'" +uuid + "\'";

        Connection con = ConnectionDB.conectar();
        try {
            con.createStatement().execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL ao atualizar os dados do Produto: " + ex.getMessage());
            return false;
        } finally {
            ConnectionDB.desconectar(con);
        }
    }
}
