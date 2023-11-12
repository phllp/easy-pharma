package org.ws_solutions.view;

import org.ws_solutions.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends TelaBase{
    public JPanel telaPrincipal;
    private JButton cadastrarProduto;

    public TelaPrincipal(Router router) {
        super(router);

        cadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaProdutos");
            }
        });
    }
}
