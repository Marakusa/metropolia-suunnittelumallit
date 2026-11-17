package Flyweight;

public class WaterTile extends Tile {
    public WaterTile() {
        super(TileType.WATER);
    }

    @Override
    public void action() {
        System.out.println("You are swimming.");
    }
}
