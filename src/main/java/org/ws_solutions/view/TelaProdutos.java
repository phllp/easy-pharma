package org.ws_solutions.view;

import org.ws_solutions.Router;
import org.ws_solutions.controller.ControllerProduto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaProdutos extends TelaBase {

    private ControllerProduto controller = new ControllerProduto();
    public JPanel telaProdutos;
    private JTextField nome;
    private JTextField descricao;
    private JTextField preco;
    private JButton adicionarButton;
    private JButton voltarBtn;
    private JTextField quantidade;

    public TelaProdutos(Router router) {
        super(router);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean sucesso = controller.adicionarProduto(nome.getText(), descricao.getText(), preco.getText(), quantidade.getText());
                // TODO: 11/12/23 Avaliar o bug que retorna false mas o produto é inserido corretamente no banco de dados 
//                if (sucesso) {
//                    JOptionPane.showMessageDialog(null, "Sucesso");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto.");
//                }
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
