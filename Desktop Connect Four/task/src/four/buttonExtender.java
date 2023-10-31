package four;

import javax.swing.*;
import java.awt.*;

public class buttonExtender extends JButton {

    int row;
    int col;

    public buttonExtender(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        this.setText(" ");
        String buttonName = String.valueOf((char) ('A' + col)) + (6 - row);
        this.setName("Button" + buttonName);
        Font buttonFont = new Font("Arial", Font.BOLD, 22);
        this.setFont(buttonFont);
        this.setPreferredSize(new Dimension(100, 100));
        this.setFocusPainted(false);

    }
}
