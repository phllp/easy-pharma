package org.ws_solutions.view;

import org.ws_solutions.Principal;
import org.ws_solutions.Router;
import org.ws_solutions.controller.ControllerPedido;
import org.ws_solutions.model.Pedido;
import org.ws_solutions.model.Produto;
import org.ws_solutions.model.dtos.PedidoDto;
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

public class TelaDetalhesPedido extends TelaBase {
    private ControllerPedido controller = new ControllerPedido();
    public JPanel telaDetalhesPedido;
    private JButton voltarBtn;
    private JLabel nomeCliente;
    private JLabel cpfCliente;
    private JPanel feedArea;
    private JLabel valorTotal;

    public TelaDetalhesPedido(Router router) {
        super(router);

        voltarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaConsultaPedidos");
            }
        });

        telaDetalhesPedido.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {

            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
                carregarDetalhesPedido();
                loadFeed();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                nomeCliente.setText("carregando...");
                cpfCliente.setText("carregando...");

            }
        });
    }

    private void loadFeed() {
        feedArea.removeAll();
        feedArea.setLayout(new BoxLayout(feedArea, BoxLayout.Y_AXIS));
        feedArea.setBorder(new EmptyBorder(20, 20, 0, 0));

        Border topLabelBorder = new EmptyBorder(0, 20, 20, 0);
        Font topLabelFont = new Font("Arial", Font.BOLD, 18);
        FeedLabel topLabel = new FeedLabel("Items do Pedido", topLabelBorder, topLabelFont);
        feedArea.add(topLabel);

        PedidoDto pedido = Principal.getPedidoSelecionado();

        for (Produto p : pedido.getProdutosPedido()) {
            FeedCard card = createFeedCard(p);
            feedArea.add(card);
            feedArea.add(Box.createVerticalStrut(10));
            feedArea.revalidate();
            feedArea.repaint();
        }
    }

    private FeedCard createFeedCard(Produto produto) {
        Border topBorder = new EmptyBorder(0, 20, 0, 0);
        Font nomeFont = new Font("Arial", Font.BOLD, 18);
        Border defaultBorder = new EmptyBorder(0, 20, 0, 0);
        Font defaultFont = new Font("Arial", Font.BOLD, 14);

        String nome = produto.getNome();
        String descricao = produto.getDescricao().length() > 0 ? produto.getDescricao() : "Não informado";
        double preco = produto.getPreco();

        FeedLabel nomeLabel = new FeedLabel("Produto: " + nome, topBorder, nomeFont);
        FeedLabel descricaoLabel = new FeedLabel("Descrição: " + descricao, defaultBorder, defaultFont);
        FeedLabel precoLabel = new FeedLabel("Preço: R$" + preco, defaultBorder, defaultFont);

        FeedCard card = new FeedCard(500, 100, 2);

        card.add(nomeLabel);
        card.add(descricaoLabel);
        card.add(precoLabel);

        return card;
    }

    private void carregarDetalhesPedido() {
        PedidoDto p = Principal.getPedidoSelecionado();
        this.nomeCliente.setText(p.getNomeCliente());
        this.cpfCliente.setText(p.getCpfCliente());
        this.valorTotal.setText("R$" + String.valueOf(p.getValorTotal()));
    }
}
