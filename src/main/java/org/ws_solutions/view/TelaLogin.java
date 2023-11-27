package org.ws_solutions.view;

import org.ws_solutions.Router;
import org.ws_solutions.controller.ControllerLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends TelaBase{

    private ControllerLogin controller = new ControllerLogin();
    public JPanel telaLogin;
    private JTextField username;
    private JPasswordField password;
    private JButton loginBtn;
    private JButton voltarBtn;

    public TelaLogin(Router router) {
        super(router);

        voltarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaInicial");
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                router.route("TelaPrincipalV2");

                boolean loginSuccess = controller.login(username.getText(), password.getText());
                if (loginSuccess) {
                    JOptionPane.showMessageDialog(null, "Sucesso");
                    router.route("TelaPrincipal");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado");
                }
            }
        });

    }
}
