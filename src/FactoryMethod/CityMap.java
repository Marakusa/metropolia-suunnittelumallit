package FactoryMethod;

import java.util.Random;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        Random random = new Random();
        int r = random.nextInt(3);
        if (r == 0) {
            return new ForestTile();
        } else if (r == 1) {
            return new BuildingTile();
        } else {
            return new RoadTile();
        }
    }
}
