package org.ws_solutions.view.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FeedCard extends JPanel {

    public FeedCard() {
        Dimension cardSize = new Dimension(500, 150);
        Border cardBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        super.setMaximumSize(cardSize);
        super.setPreferredSize(cardSize);
        super.setBorder(cardBorder);
    }

    public FeedCard(int width, int height, int borderWidth) {
        Dimension cardSize = new Dimension(width, height);
        Border cardBorder = BorderFactory.createLineBorder(Color.BLACK, borderWidth);

        JPanel card = new JPanel();
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        super.setMaximumSize(cardSize);
        super.setPreferredSize(cardSize);
        super.setBorder(cardBorder);
    }

    public FeedCard(JPanel parent) {
        int width = (int) Math.round(parent.getWidth() * 0.98);
        Dimension cardSize = new Dimension(width , 100);
        Border cardBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

        JPanel card = new JPanel();
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        super.setMaximumSize(cardSize);
        super.setPreferredSize(cardSize);
        super.setBorder(cardBorder);
    }




}