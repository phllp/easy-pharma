package org.ws_solutions.view;

import org.ws_solutions.Principal;
import org.ws_solutions.Router;
import org.ws_solutions.controller.ControllerPedido;
import org.ws_solutions.model.Pedido;
import org.ws_solutions.model.dtos.PedidoDto;
import org.ws_solutions.view.components.CardPedido;
import org.ws_solutions.view.components.FeedCard;
import org.ws_solutions.view.components.FeedLabel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class TelaConsultaPedidos extends TelaBase {

    private ControllerPedido controller = new ControllerPedido();
    public JPanel telaConsultarPedidos;
    private JButton voltarBtn;
    private JPanel feedArea;
    private JButton novoPedidoBtn;

    public TelaConsultaPedidos(Router router) {
        super(router);

        novoPedidoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaRegistrarPedido");
            }
        });
        voltarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.route("TelaPrincipalV2");
            }
        });
        telaConsultarPedidos.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                loadFeed();
            }
        });
    }

    private void loadFeed() {
        feedArea.removeAll();
        feedArea.setLayout(new BoxLayout(feedArea, BoxLayout.Y_AXIS));
        feedArea.setBorder(new EmptyBorder(20,0,0,0));

        ArrayList<PedidoDto> pedidos = controller.buscaPedidosConsulta();

        for (PedidoDto pedido : pedidos) {
            FeedCard card = createFeedCard(pedido);
            feedArea.add(card);
            feedArea.add(Box.createVerticalStrut(10));
            feedArea.revalidate();
            feedArea.repaint();
        }
    }

    private FeedCard createFeedCard(PedidoDto pedido) {
        Border topBorder = new EmptyBorder(0, 20, 0, 0);
        Font nomeFont = new Font("Arial", Font.BOLD, 18);
        Border defaultBorder = new EmptyBorder(0, 20, 0, 20);
        Font defaultFont = new Font("Arial", Font.BOLD, 14);

        String uuid = pedido.getId();
        String nomeCliente = pedido.getNomeCliente();
        String cpfCliente = pedido.getCpfCliente();

        FeedLabel nomeClienteLabel = new FeedLabel("Cliente: " + nomeCliente, topBorder, nomeFont);
        FeedLabel cpfClienteLabel = new FeedLabel("CPF: " + cpfCliente, defaultBorder, defaultFont);

        JButton detalhes = new JButton();
        detalhes.setText("Detalhes");
        detalhes.setName("detalhesPedido_" + uuid);
        detalhes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal.setPedidoSelecionado(pedido);
                router.route("TelaDetalhesPedido");
            }
        });
        FeedCard card = new FeedCard(feedArea);

        card.add(nomeClienteLabel);
        card.add(cpfClienteLabel);
        card.add(detalhes);
        return card;
    }

}
