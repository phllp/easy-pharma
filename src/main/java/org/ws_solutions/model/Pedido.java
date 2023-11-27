package org.ws_solutions.model;

import org.ws_solutions.db.ConnectionDB;
import org.ws_solutions.model.dtos.PedidoDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class Pedido {
    private String id;
    private String nomeCliente;
    private String cpfCliente;
    private ArrayList<PedidoProduto> pedidoProduto;

    public Pedido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public ArrayList<PedidoProduto> getPedidoProduto() {
        return pedidoProduto;
    }

    public void setPedidoProduto(ArrayList<PedidoProduto> pedidoProduto) {
        this.pedidoProduto = pedidoProduto;
    }
    
    public double getValorTotal() {
        return 0.0;
    }

    public boolean criar() {
        String uuidPedido = "\'" + UUID.randomUUID().toString() + "\'";
        String nomeCliente = "\'" + this.getNomeCliente() + "\'";
        String cpfCliente = "\'" + this.getCpfCliente() + "\'";

        String insertPedido = "INSERT INTO pedido (id, nomecliente, cpfcliente) " +
                "VALUES (" + uuidPedido + ", " + nomeCliente + ", " + cpfCliente + ")";

        Connection con = ConnectionDB.conectar();
        try {
            con.createStatement().execute(insertPedido);

            for (PedidoProduto produto: this.pedidoProduto) {
                String uuidPedidoProduto = "\'" + UUID.randomUUID().toString() + "\'";
                String uuidProduto = "\'" + produto.getId() + "\'";

                String insertProdutoItem = "INSERT INTO pedidoproduto (id, idpedido, idproduto, quantidade) " +
                        "VALUES (" + uuidPedidoProduto + ", " + uuidPedido + ", " + uuidProduto + ", " + 1 + ")";

                con.createStatement().execute(insertProdutoItem);
            }

            ConnectionDB.desconectar(con);
            return true;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL ao inserir os dados do Produto: " + ex.getMessage());
            ConnectionDB.desconectar(con);
            return false;
        } catch (Exception ex) {
            System.out.println("Erro ao inserir dados do Produto: " + ex.getMessage());
            return false;
        }
    }

    public static ArrayList<PedidoDto> buscarDadosConsulta() {
        ArrayList<PedidoDto> data =  new ArrayList<>();

        String sql = "SELECT * FROM pedido";

        Connection con = ConnectionDB.conectar();
        try {
            ResultSet resultado = con.createStatement().executeQuery(sql);
            while (resultado.next()) {
                String idPedido = resultado.getString("id");

                ArrayList<Produto>  produtosPedido =  PedidoProduto.buscarProdutosPedido(idPedido);

                String nomeCliente = resultado.getString("nomeCliente");
                String cpfCliente = resultado.getString("cpfCliente");

                double valorTotal = 0.0;

                for (Produto p : produtosPedido)
                    valorTotal += p.getPreco();

                PedidoDto item = new PedidoDto();
                item.setId(idPedido);
                item.setNomeCliente(nomeCliente);
                item.setCpfCliente(cpfCliente);
                item.setProdutosPedido(produtosPedido);
                item.setValorTotal(valorTotal);

                data.add(item);
            }
            ConnectionDB.desconectar(con);
            return data;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL ao buscar os dados da consulta de Pedidos. " + ex.getMessage());
            ConnectionDB.desconectar(con);
            return data;
        }
    }


}
