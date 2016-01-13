package towerdefense.view;

import towerdefense.bo.Base;
import towerdefense.bo.Entity;
import towerdefense.bo.Ressource;
import towerdefense.bo.Tower;
import towerdefense.manager.*;
import towerdefense.manager.UIManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private JPanel contentPane;
    private towerdefense.view.Board Board;
    private JButton AddTowerBtn;
    private JLabel systemMsgLabel;
    private JLabel systemMsgContent;

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
                ArrayList<Point> slotsTower = new ArrayList<Point>();
                slotsTower.add(new Point(100, (UIManager.getWindow().getBoard().getHeight()/2)-(Base.SIZE/2)-20));
                slotsTower.add(new Point(200, (UIManager.getWindow().getBoard().getHeight()/2)-(Base.SIZE/2)-20));
                slotsTower.add(new Point(300, (UIManager.getWindow().getBoard().getHeight()/2)-(Base.SIZE/2)-20));
                slotsTower.add(new Point(100, (UIManager.getWindow().getBoard().getHeight()/2)-(Base.SIZE/2)+125));
                slotsTower.add(new Point(200, (UIManager.getWindow().getBoard().getHeight()/2)-(Base.SIZE/2)+125));
                slotsTower.add(new Point(300, (UIManager.getWindow().getBoard().getHeight()/2)-(Base.SIZE/2)+125));
                if (EntityManager.getTowers().size() < 6){
                    if(((Base) EntityManager.entities.get(0)).removeRessource(new Ressource(null, Tower.cost))){
                        EntityManager.addTower(new Tower((int)(slotsTower.get(EntityManager.getTowers().size()).getX()), (int)(slotsTower.get(EntityManager.getTowers().size()).getY()), 50, 50));
                    }
                    else{
                        systemMsgContent.setText("You can't add a tower! You don't have enough resources.");
                    }
                }
                else{
                    systemMsgContent.setText("You can't add more tower!");
                }
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
