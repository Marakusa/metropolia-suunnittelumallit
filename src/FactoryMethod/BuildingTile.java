package FactoryMethod;

public class BuildingTile extends Tile {
    public BuildingTile() {
        super("#", "Building tile.");
    }

    @Override
    public void action() {
        System.out.println("You are in a building.");
    }
}
