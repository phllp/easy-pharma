package org.ws_solutions.model;

import java.util.ArrayList;

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
        // TODO: 11/8/23 Implementar lógica
        return 0.0;
    }
}
