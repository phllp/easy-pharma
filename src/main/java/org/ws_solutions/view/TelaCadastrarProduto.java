package org.ws_solutions.view;

import org.ws_solutions.Router;
import org.ws_solutions.controller.ControllerProduto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastrarProduto extends TelaBase {

    private ControllerProduto controller = new ControllerProduto();
    public JPanel telaCadastrarProduto;
    private JTextField nome;
    private JTextField descricao;
    private JTextField preco;
    private JButton adicionarButton;
    private JButton voltarBtn;
    private JTextField quantidade;

    public TelaCadastrarProduto(Router router) {
        super(router);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean sucesso = controller.adicionarProduto(nome.getText(), descricao.getText(), preco.getText(), quantidade.getText());
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
                    router.route("TelaConsultaProdutos");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto.");
                }
            }
        });

        voltarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaConsultaProdutos");
            }
        });


    }
}
