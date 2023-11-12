package org.ws_solutions;

import javax.swing.*;
import java.awt.*;

public class Router extends JFrame {

    private JPanel cardPanel;
    private CardLayout cardLayout;

    private Container contentPane = getContentPane();

    public Router() {
        setTitle("Easy Pharma");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        contentPane.setLayout(new BorderLayout());
        contentPane.add(cardPanel, BorderLayout.CENTER);
    }

    public void route(String destiny) {
        cardLayout.show(cardPanel, destiny);
    }

    public void addComponent(JPanel panel, String name) {
        cardPanel.add(panel, name);
    }


}