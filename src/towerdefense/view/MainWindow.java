package towerdefense.view;

import towerdefense.bo.Tower;
import towerdefense.manager.EntityManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {
    private JPanel contentPane;
    private towerdefense.view.Board Board;
    private JButton AddTowerBtn;

    public MainWindow() {

        setContentPane(contentPane);
        setVisible(true);
        setPreferredSize(new Dimension(800, 600));
        pack();
        AddTowerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                EntityManager.entities.add(new Tower(50, 50, 20, 20));
            }
        });
    }

    public void refreshBoard() {
        this.Board.repaint();
    }

    public towerdefense.view.Board getBoard() {
        return Board;
    }
}
