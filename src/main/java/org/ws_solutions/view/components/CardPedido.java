package org.ws_solutions.view.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CardPedido extends JPanel {

    public CardPedido(JPanel parent) {
        int width = (int) Math.round(parent.getWidth() * 0.98);
        Dimension cardSize = new Dimension(width , 100);
        Border cardBorder = BorderFactory.createLineBorder(Color.BLACK, 2);


        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        super.setMaximumSize(cardSize);
        super.setPreferredSize(cardSize);
        super.setBorder(cardBorder);
    }

}
