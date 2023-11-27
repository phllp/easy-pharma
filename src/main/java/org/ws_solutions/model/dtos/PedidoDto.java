package org.ws_solutions.model.dtos;

import org.ws_solutions.model.Produto;

import java.util.ArrayList;

public class PedidoDto {
    private String id;
    private String nomeCliente;
    private String cpfCliente;
    private ArrayList<Produto> produtosPedido =  new ArrayList<>();
    private double valorTotal;

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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

    public ArrayList<Produto> getProdutosPedido() {
        return produtosPedido;
    }

    public void setProdutosPedido(ArrayList<Produto> produtosPedido) {
        this.produtosPedido = produtosPedido;
    }
}
