package Flyweight;

public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        return switch (random.nextInt(3)) {
            case 0 -> new ForestTile();
            case 1 -> new WaterTile();
            default -> new SwampTile();
        };
    }
}
