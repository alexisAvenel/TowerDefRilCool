package towerdefense.bo;

/**
 * Created by FZAB on 12/01/2016.
 */
public class Ressource {
    private String name;
    private int quantity;

    public Ressource(String name) {
        this.name = name;
        this.quantity = 0;
    }

    public Ressource(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}