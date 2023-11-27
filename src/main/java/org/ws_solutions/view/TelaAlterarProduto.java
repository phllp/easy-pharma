package org.ws_solutions.view;

import org.ws_solutions.Principal;
import org.ws_solutions.Router;
import org.ws_solutions.controller.ControllerProduto;
import org.ws_solutions.model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TelaAlterarProduto extends TelaBase {
    private ControllerProduto controller = new ControllerProduto();
    public JPanel telaAlterarProduto;
    private JButton cancelarBtn;
    private JButton alterarBtn;
    private JTextField nome;
    private JTextField descricao;
    private JTextField preco;

    public TelaAlterarProduto(Router router) {
        super(router);

        cancelarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaConsultaProdutos");
            }
        });

        alterarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idProduto = Principal.getProdutoSelecionado().getId();
                boolean alterado = controller.alterarProduto(idProduto, nome.getText(), descricao.getText(), preco.getText());
                if(alterado) {
                    JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso");
                    router.route("TelaConsultaProdutos");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar o produto");
                }
            }
        });

        telaAlterarProduto.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {

            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {
                carregaDadosProdutoSelecionado();
            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });



    }

    private void carregaDadosProdutoSelecionado() {
        Produto p = Principal.getProdutoSelecionado();

        this.descricao.setText(p.getDescricao());
        this.preco.setText(String.valueOf(p.getPreco()));
        this.nome.setText(p.getNome());
    }
}
