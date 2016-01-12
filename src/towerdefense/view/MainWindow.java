package towerdefense.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel contentPane;
    private towerdefense.view.Board Board;

    public MainWindow() {

        setContentPane(contentPane);
        setTitle("TowerDefense RIL COOL"); //On donne un titre à l'application
        setSize(800,600); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(false); //On interdit la redimensionnement de la fenêtre
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
    }

    public void refreshBoard() {
        this.Board.repaint();
    }

    public towerdefense.view.Board getBoard() {
        return Board;
    }
}
