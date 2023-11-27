package org.ws_solutions;

import org.ws_solutions.model.Pedido;
import org.ws_solutions.model.Produto;
import org.ws_solutions.model.Usuario;
import org.ws_solutions.model.dtos.PedidoDto;

public class Principal {

    private static Usuario usuarioSessao;
    private static Produto produtoSelecionado;
    private static PedidoDto pedidoSelecionado;

    private static String message;

    public static Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public static void setUsuarioSessao(Usuario usuarioSessao) {
        Principal.usuarioSessao = usuarioSessao;
    }

    public static Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public static void setProdutoSelecionado(Produto produtoSelecionado) {
        Principal.produtoSelecionado = produtoSelecionado;
    }

    public static PedidoDto getPedidoSelecionado() {
        return pedidoSelecionado;
    }

    public static void setPedidoSelecionado(PedidoDto pedidoSelecionado) {
        Principal.pedidoSelecionado = pedidoSelecionado;
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Principal.message = message;
    }
}
