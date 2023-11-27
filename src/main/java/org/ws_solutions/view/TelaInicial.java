package org.ws_solutions.view;

import org.ws_solutions.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends TelaBase{

    public JPanel telaInicial;
    private JButton loginBtn;
    private JButton cadastrarBtn;

    public TelaInicial(Router router) {
        super(router);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                router.route("TelaLogin");
            }

        });

        cadastrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaCadastro");
            }
        });
    }
}
