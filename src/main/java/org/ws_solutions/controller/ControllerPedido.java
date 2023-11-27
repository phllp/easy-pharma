package org.ws_solutions.controller;

import org.ws_solutions.model.Pedido;
import org.ws_solutions.model.PedidoProduto;
import org.ws_solutions.model.dtos.PedidoDto;

import java.util.ArrayList;
import java.util.Set;

public class ControllerPedido extends ControllerBase {

    public boolean registrarPedido(String nomeCliente, String cpfCliente, Set<String> produtos) {
        Pedido pedido = new Pedido();
        pedido.setNomeCliente(nomeCliente);
        pedido.setCpfCliente(cpfCliente);

        ArrayList<PedidoProduto> produtosPedido = new ArrayList<>();
        for (String id: produtos) {
            PedidoProduto pp =  new PedidoProduto();
            pp.setId(id);
            produtosPedido.add(pp);
        }

        pedido.setPedidoProduto(produtosPedido);

        boolean pedidoCriado = pedido.criar();
        return pedidoCriado;
    }

    public ArrayList<PedidoDto> buscaPedidosConsulta() {
        ArrayList<PedidoDto> dadosConsulta = Pedido.buscarDadosConsulta();
        return dadosConsulta;

    }
}
