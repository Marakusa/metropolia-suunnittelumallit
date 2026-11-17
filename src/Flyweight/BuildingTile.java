package Flyweight;

public class BuildingTile extends Tile {
    public BuildingTile() {
        super(TileType.BUILDING);
    }

    @Override
    public void action() {
        System.out.println("You are in a building.");
    }
}
