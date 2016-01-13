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
        setTitle("TowerDefense RIL COOL"); //On donne un titre à l'application
        setSize(1000,600); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(false); //On interdit la redimensionnement de la fenêtre
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
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
