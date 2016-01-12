package towerdefense.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel contentPane;
    private towerdefense.view.Board Board;

    public MainWindow() {

        setContentPane(contentPane);
        setVisible(true);
        setPreferredSize(new Dimension(800, 600));
        pack();
    }

    public void refreshBoard() {
        this.Board.repaint();
    }

    public towerdefense.view.Board getBoard() {
        return Board;
    }
}
