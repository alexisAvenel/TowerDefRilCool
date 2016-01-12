package towerdefense.manager;

import towerdefense.view.MainWindow;

public class UIManager {
    private static MainWindow window;
    public static MainWindow getWindow() {
        if(window == null) {
            window = new MainWindow();
        }
        return window;
    }
}
