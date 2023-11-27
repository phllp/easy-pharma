package org.ws_solutions.view;

import org.ws_solutions.Router;
import org.ws_solutions.model.Produto;
import org.ws_solutions.view.components.FeedCard;
import org.ws_solutions.view.components.FeedLabel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

public class TelaPrincipal extends TelaBase{
    public JPanel telaPrincipal;
    private JButton cadastrarProduto;
    private JPanel feedArea;
    private JButton registrarPedidoBtn;
    private JButton consultarPedidos;

    public TelaPrincipal(Router router) {
        super(router);

        cadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaProdutos");
            }
        });

        registrarPedidoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaRegistrarPedido");
            }
        });

        consultarPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaConsultarPedidos");
            }
        });


        telaPrincipal.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
                loadFeed();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
    }


    /**
     * Carrega os cards do feed com as informações das competições registradas
     */
    private void loadFeed() {
        feedArea.removeAll();
        feedArea.setLayout(new BoxLayout(feedArea, BoxLayout.Y_AXIS));

        ArrayList<Produto> produtos = Produto.buscarTodos();

        for (Produto produto : produtos) {
            FeedCard card = createFeedCard(produto);
            feedArea.add(card);
            feedArea.add(Box.createVerticalStrut(10));
            feedArea.revalidate();
            feedArea.repaint();
        }
    }



    /**
     * Cria um componente com as informações de uma competição
     *
     * @param produto
     * @return FeedCard
     */
    private FeedCard createFeedCard(Produto produto) {
        Border topBorder = new EmptyBorder(5, 25, 5, 0);
        Font nomeFont = new Font("Arial", Font.BOLD, 24);
        Border defaultBorder = new EmptyBorder(0, 10, 5, 0);
        Font defaultFont = new Font("Arial", Font.BOLD, 14);

        String uuid = produto.getId();
        String nome = produto.getNome();
        String descricao = produto.getDescricao();
        double preco = produto.getPreco();
        int quantidade = Produto.getQuantidadeEstoque(produto);

        FeedLabel nomeLabel = new FeedLabel(nome, topBorder, nomeFont);
        FeedLabel descricaoLabel = new FeedLabel("Descrição: " + descricao, defaultBorder, defaultFont);
        FeedLabel precoLabel = new FeedLabel("Valor: " + "R$"+preco, defaultBorder, defaultFont);
        FeedLabel quantidadeLabel = new FeedLabel("Estoque: " + quantidade, defaultBorder, defaultFont);

        JButton detalhes = new JButton();
        detalhes.setText("Detalhes");
        detalhes.setName("detalhesEvento_" + uuid);
        detalhes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Competicao comp = new Competicao();
//                comp.setNome(nome);
//                comp.setUuid(uuid);
//                comp.setDataInicio(dataInicio);
//                comp.setDataTermino(dataTermino);
//                comp.setIdadeMaxima(idadeMaxima.intValue());
//                comp.setIdadeMinima(idadeMinima.intValue());
//                Principal.setCompeticaoSelecionada(comp);
//
//                router.route("TelaDetalheCompeticao");
                System.out.println("Item Clicado: " + detalhes.getName());
            }
        });

        FeedCard card = new FeedCard();

        card.add(nomeLabel);
        card.add(descricaoLabel);
        card.add(precoLabel);
        card.add(detalhes);
        card.add(quantidadeLabel);
        return card;
    }
}
