package Flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Flyweight: the shared image of one tile type. One instance per TileType
 * is shared by every tile of that type. The position on the canvas
 * (extrinsic state) is given as a parameter when drawing.
 */
public class TileGraphic {
    private final TileType type;
    private final Image image;

    public TileGraphic(TileType type, Image image) {
        this.type = type;
        this.image = image;
    }

    public TileType getType() {
        return type;
    }

    public void draw(GraphicsContext gc, double x, double y, double size) {
        gc.drawImage(image, x, y, size, size);
    }
}
