package Flyweight;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MapRenderer {
    private final int tileSize;

    public MapRenderer(int tileSize) {
        this.tileSize = tileSize;
    }

    /**
     * Draws every tile using the shared TileGraphic of its type.
     * The tile's position (extrinsic state) is passed to the flyweight here.
     */
    public void render(Map map, Canvas canvas) {
        canvas.setWidth(map.getWidth() * tileSize);
        canvas.setHeight(map.getHeight() * tileSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Tile tile = map.getTile(x, y);
                TileGraphic graphic = TileGraphicFactory.getGraphic(tile.getType());
                graphic.draw(gc, x * tileSize, y * tileSize, tileSize);
            }
        }
    }

    public int getTileSize() {
        return tileSize;
    }
}
