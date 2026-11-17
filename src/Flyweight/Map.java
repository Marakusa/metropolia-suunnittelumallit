package Flyweight;

import java.util.Random;

public abstract class Map {
    protected final Random random = new Random();
    private final Tile[][] tiles;

    public Map(int width, int height) {
        tiles = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = createTile();
            }
        }
    }

    /** Factory Method: subclasses decide which tiles the map contains. */
    public abstract Tile createTile();

    public int getWidth() {
        return tiles.length;
    }

    public int getHeight() {
        return tiles[0].length;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public void display() {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                System.out.print(tiles[x][y].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
