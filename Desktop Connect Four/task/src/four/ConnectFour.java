package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConnectFour extends JFrame {

    private final JButton[][] buttons;
    int rows = 6;
    int cols = 7;
    Player currentPlayer = Player.X;
    ArrayList<buttonExtender> winningButtons = new ArrayList<>();

    public ConnectFour() {

        //FRAME
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(cols * 100, rows * 100 + 50);
        setLocationRelativeTo(null);

        setTitle("Connect Four");

        //create panels and array
        JPanel gridPanel = new JPanel(new GridLayout(rows, cols, 0, 0));
        buttons = new buttonExtender[rows][cols];

        ActionListener buttonClickListener = e -> {
            buttonExtender clickedButton = (buttonExtender) e.getSource();
            int col = clickedButton.col;
            if (!isColumnFull(col)) {
                for (int row = rows - 1; row >= 0; row--) {
                    if (buttons[row][col].getText().equals(" ")) {
                        buttons[row][col].setText(currentPlayer.toString());
                        break;
                    }
                }
                if (checkForWin()) {
                    markWinningButtons();
                    disableButtons();
                } else {
                    currentPlayer = currentPlayer.nextPlayer();
                }
            }
        };

        // Initialize and add buttons
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                var b = new buttonExtender(row, col);
                b.addActionListener(buttonClickListener);
                gridPanel.add(b);
                buttons[row][col] = b;
            }
        }

        JPanel resetBar = new JPanel();
        resetBar.setPreferredSize(new Dimension(cols * 100, 50));
        resetBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(resetBar, BorderLayout.SOUTH);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(0, 0, 100, 25);
        resetButton.setName("ButtonReset");
        resetBar.add(resetButton);

        resetButton.addActionListener(e -> resetGame());

        add(gridPanel);
        setVisible(true);

    }

    private boolean isColumnFull(int col) {
        for (int row = 0; row < rows; row++) {
            if (buttons[row][col].getText().equals(" ")) {
                return false;
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                var c = buttons[i][j];
                c.setText(" ");
                c.setBackground(null);
                c.setEnabled(true);
            }
        }
        winningButtons.clear();
        currentPlayer = Player.X;
    }


    private boolean checkForWin() {

        if (checkHorizontal()) return true;

        if (checkVertical()) return true;

        if (checkDiagonal()) return true;

        if (checkForwardDiagonal()) return true;

        return false;
    }


    private boolean checkHorizontal() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                String stringToCheck = buttons[i][j].getText();
                if (!stringToCheck.equals(" ")) {
                    int correctSquares = 1;
                    for (int k = 1; k <= 3; k++) {
                        if (buttons[i][j + k].getText().equals(stringToCheck)) correctSquares++;
                    }
                    if (correctSquares == 4) {
                        for (int k = 0; k <= 3; k++) {
                            winningButtons.add((buttonExtender) buttons[i][j + k]);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkVertical() {
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < cols; j++) {
                String stringToCheck = buttons[i][j].getText();
                if (!stringToCheck.equals(" ")) {
                    int correctSquares = 1;
                    for (int k = 1; k <= 3; k++) {
                        if (buttons[i + k][j].getText().equals(stringToCheck)) correctSquares++;
                    }
                    if (correctSquares == 4) {
                        for (int k = 0; k <= 3; k++) {
                            winningButtons.add((buttonExtender) buttons[i + k][j]);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < cols - 3; j++) {
                String stringToCheck = buttons[i][j].getText();
                if (!stringToCheck.equals(" ")) {
                    int correctSquares = 1;
                    for (int k = 1; k <= 3; k++) {
                        if (buttons[i + k][j + k].getText().equals(stringToCheck)) correctSquares++;
                    }
                    if (correctSquares == 4) {
                        for (int k = 0; k <= 3; k++) {
                            winningButtons.add((buttonExtender) buttons[i + k][j + k]);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkForwardDiagonal() {
        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                String stringToCheck = buttons[i][j].getText();
                if (!stringToCheck.equals(" ")) {
                    int correctSquares = 1;
                    for (int k = 1; k <= 3; k++) {
                        if (buttons[i - k][j + k].getText().equals(stringToCheck)) correctSquares++;
                    }
                    if (correctSquares == 4) {
                        for (int k = 0; k <= 3; k++) {
                            winningButtons.add((buttonExtender) buttons[i - k][j + k]);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private void markWinningButtons() {
        for (buttonExtender b : winningButtons) {
            b.setBackground(Color.green);
        }
    }

    public void disableButtons() {
        for (int k = 0; k < rows; k++) {
            for (int l = 0; l < cols; l++) {
                buttons[k][l].setEnabled(false);
            }
        }
    }
}



