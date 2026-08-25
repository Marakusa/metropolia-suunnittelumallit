package FactoryMethod;

public class RoadTile extends Tile {
    public RoadTile() {
        super("=", "Road tile, you can drive on it.");
    }

    @Override
    public void action() {
        System.out.println("You are driving.");
    }
}
