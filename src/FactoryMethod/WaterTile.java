package FactoryMethod;

public class WaterTile extends Tile {
    public WaterTile() {
        super("~", "Water area, deep and dangerous.");
    }

    @Override
    public void action() {
        System.out.println("You are swimming.");
    }
}
