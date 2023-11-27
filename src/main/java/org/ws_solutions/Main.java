package org.ws_solutions;

import org.ws_solutions.model.Usuario;
import org.ws_solutions.view.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("******* Running Easy Pharma Application *******");

        Principal.setUsuarioSessao(new Usuario());

        Router router =  new Router();

        JPanel telaInicial = new TelaInicial(router).telaInicial;
        JPanel telaLogin = new TelaLogin(router).telaLogin;
        JPanel telaCadastro = new TelaCadastro(router).telaCadastro;
        JPanel telaProdutos = new TelaCadastrarProduto(router).telaCadastrarProduto;
        JPanel telaRegistrarPedido = new TelaRegistrarPedido(router).telaRegistrarPedido;
        JPanel telaConsultarPedidos = new TelaConsultaPedidos(router).telaConsultarPedidos;
        JPanel telaPrincipalV2 = new TelaPrincipalV2(router).telaPrincipalV2;
        JPanel telaConsultaProdutos =  new TelaConsultaProdutos(router).telaConsultaProdutos;
        JPanel telaAlterarProduto =  new TelaAlterarProduto(router).telaAlterarProduto;
        JPanel telaDetalhesPedido =  new TelaDetalhesPedido(router).telaDetalhesPedido;

        router.addComponent(telaInicial, "TelaInicial");
        router.addComponent(telaLogin, "TelaLogin");
        router.addComponent(telaCadastro, "TelaCadastro");
        router.addComponent(telaProdutos, "TelaCadastrarProduto");
        router.addComponent(telaRegistrarPedido, "TelaRegistrarPedido");
        router.addComponent(telaConsultarPedidos, "TelaConsultaPedidos");
        router.addComponent(telaPrincipalV2, "TelaPrincipalV2");
        router.addComponent(telaConsultaProdutos, "TelaConsultaProdutos");
        router.addComponent(telaAlterarProduto, "TelaAlterarProduto");
        router.addComponent(telaDetalhesPedido, "TelaDetalhesPedido");

        router.setVisible(true);

        System.out.println("******* Closing Easy Pharma Application *******");
    }


}