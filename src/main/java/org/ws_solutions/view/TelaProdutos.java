package org.ws_solutions.view;

import org.ws_solutions.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaProdutos extends TelaBase {
    public JPanel telaProdutos;
    private JTextField nome;
    private JTextField descricao;
    private JTextField preco;
    private JButton adicionarButton;
    private JButton voltarBtn;

    public TelaProdutos(Router router) {
        super(router);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                router.route("TelaInicial");
            }
        });

        voltarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaPrincipal");
            }
        });


    }
}
