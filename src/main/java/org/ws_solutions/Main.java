package org.ws_solutions;

import org.ws_solutions.db.ConnectionDB;
import org.ws_solutions.model.Usuario;
import org.ws_solutions.view.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("******* Running Easy Pharma Application *******");


        Principal.setUsuarioSessao(new Usuario());

        Router router =  new Router();

        JPanel telaInicial = new TelaInicial(router).telaInicial;
        JPanel telaLogin = new TelaLogin(router).telaLogin;
        JPanel telaCadastro = new TelaCadastro(router).telaCadastro;
        JPanel telaPrincipal = new TelaPrincipal(router).telaPrincipal;
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
        router.addComponent(telaPrincipal, "TelaPrincipal");
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

    private void connectToDb(){
        Connection con = ConnectionDB.conectar();

        String query =  "SELECT * FROM usuarios";
        try {
            ResultSet resultado = con.createStatement().executeQuery(query);
            while (resultado.next()) {
                // Recupere os valores das colunas do resultado
                String id = resultado.getString("id");
                String nome = resultado.getString("username");
                // Faça algo com os valores obtidos
                System.out.println("ID: " + id + ", Nome: " + nome);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao buscar os dados" + ex.getMessage());
        }


        ConnectionDB.desconectar(con);

    }
}