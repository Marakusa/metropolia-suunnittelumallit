package Flyweight;

public class SwampTile extends Tile {
    public SwampTile() {
        super(TileType.SWAMP);
    }

    @Override
    public void action() {
        System.out.println("You are in a swamp. It's wet and muddy.");
    }
}
