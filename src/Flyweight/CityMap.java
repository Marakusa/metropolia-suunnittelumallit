package Flyweight;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        return switch (random.nextInt(3)) {
            case 0 -> new ForestTile();
            case 1 -> new BuildingTile();
            default -> new RoadTile();
        };
    }
}
