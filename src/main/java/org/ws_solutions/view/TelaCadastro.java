package org.ws_solutions.view;

import org.ws_solutions.Router;
import org.ws_solutions.controller.ControllerFuncionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends TelaBase {

    private ControllerFuncionario controller = new ControllerFuncionario();
    public JPanel telaCadastro;
    private JTextField username;
    private JTextField password;
    private JTextField salario;
    private JTextField dataAdmissao;
    private JButton cadastrarBtn;
    private JButton voltarBtn;

    public TelaCadastro(Router router) {
        super(router);

        cadastrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUsuario();
            }
        });

        voltarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaInicial");
            }
        });

    }

    private boolean addUsuario() {
        String username = this.username.getText();
        String password = this.password.getText();
        String salario = this.salario.getText();
        String dataAdmissao = this.dataAdmissao.getText();
        if (controller.criarFuncionario(username, password, dataAdmissao, salario)) {
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Usuário");
            return false;
        }
    }

}
