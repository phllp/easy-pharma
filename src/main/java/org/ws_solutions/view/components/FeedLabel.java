package org.ws_solutions.view.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FeedLabel extends JLabel {

    public FeedLabel(String text, Border border, Font font) {
        super.setText(text);
        super.setBorder(border);
        super.setFont(font);
    }

}