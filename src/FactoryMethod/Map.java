package FactoryMethod;

public abstract class Map {
    public final Tile[][] tiles;

    public Map(int width, int height) {
        tiles = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = createTile();
            }
        }
    }

    public abstract Tile createTile();

    public void display() {
        for (Tile[] tile : tiles) {
            for (Tile value : tile) {
                System.out.print(value.getCharacter() + " ");
            }
            System.out.print("\n");
        }
    }
}
