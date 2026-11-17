package Flyweight;

public class RoadTile extends Tile {
    public RoadTile() {
        super(TileType.ROAD);
    }

    @Override
    public void action() {
        System.out.println("You are driving.");
    }
}
