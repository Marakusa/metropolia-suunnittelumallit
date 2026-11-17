package Flyweight;

public class ForestTile extends Tile {
    public ForestTile() {
        super(TileType.FOREST);
    }

    @Override
    public void action() {
        System.out.println("You are in a forest. Watch out for wild animals!");
    }
}
