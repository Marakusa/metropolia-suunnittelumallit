package Flyweight;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

import java.util.EnumMap;

/**
 * Flyweight factory: creates each tile graphic only once and returns the
 * same shared instance on every later request.
 */
public class TileGraphicFactory {
    public static final int TILE_SIZE = 32;

    private static final java.util.Map<TileType, TileGraphic> graphics = new EnumMap<>(TileType.class);

    private TileGraphicFactory() {}

    public static TileGraphic getGraphic(TileType type) {
        return graphics.computeIfAbsent(type, t -> {
            System.out.println("TileGraphicFactory: creating graphic for " + t);
            return new TileGraphic(t, createImage(t));
        });
    }

    public static int getCreatedCount() {
        return graphics.size();
    }

    // Must be called on the JavaFX application thread (uses Canvas.snapshot).
    private static WritableImage createImage(TileType type) {
        int s = TILE_SIZE;
        Canvas canvas = new Canvas(s, s);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(type.getBaseColor());
        gc.fillRect(0, 0, s, s);

        switch (type) {
            case FOREST -> {
                gc.setFill(Color.web("#5a3a1e"));
                gc.fillRect(9, 20, 3, 7);
                gc.fillRect(21, 16, 3, 7);
                gc.setFill(Color.web("#1f5320"));
                gc.fillPolygon(new double[]{3, 10.5, 18}, new double[]{21, 5, 21}, 3);
                gc.fillPolygon(new double[]{15, 22.5, 30}, new double[]{17, 2, 17}, 3);
            }
            case WATER -> {
                gc.setStroke(Color.web("#a9cdf0"));
                gc.setLineWidth(2);
                gc.setLineCap(StrokeLineCap.ROUND);
                for (int row = 0; row < 3; row++) {
                    double y = 8 + row * 9;
                    double offset = (row % 2) * 6;
                    gc.strokeArc(2 + offset, y - 3, 8, 6, 0, 180, javafx.scene.shape.ArcType.OPEN);
                    gc.strokeArc(14 + offset, y - 3, 8, 6, 0, 180, javafx.scene.shape.ArcType.OPEN);
                }
            }
            case SWAMP -> {
                gc.setFill(Color.web("#3d4a2a"));
                gc.fillOval(4, 18, 14, 7);
                gc.fillOval(17, 6, 11, 6);
                gc.setStroke(Color.web("#8fa34a"));
                gc.setLineWidth(1.5);
                for (int i = 0; i < 3; i++) {
                    gc.strokeLine(20 + i * 3, 28, 19 + i * 4, 18);
                }
                gc.strokeLine(6, 14, 5, 6);
                gc.strokeLine(9, 14, 10, 7);
            }
            case ROAD -> {
                gc.setFill(Color.web("#6e6e6e"));
                gc.fillRect(0, 6, s, s - 12);
                gc.setFill(Color.web("#f2d24b"));
                gc.fillRect(2, 15, 8, 2);
                gc.fillRect(14, 15, 8, 2);
                gc.fillRect(26, 15, 6, 2);
            }
            case BUILDING -> {
                gc.setFill(Color.web("#d9c7a3"));
                gc.fillRect(5, 13, 22, 17);
                gc.setFill(Color.web("#a33a2a"));
                gc.fillPolygon(new double[]{2, 16, 30}, new double[]{14, 3, 14}, 3);
                gc.setFill(Color.web("#5a3a1e"));
                gc.fillRect(14, 21, 5, 9);
                gc.setFill(Color.web("#7fb3d5"));
                gc.fillRect(8, 17, 4, 4);
                gc.fillRect(21, 17, 4, 4);
            }
        }
        gc.setStroke(Color.color(0, 0, 0, 0.15));
        gc.setLineWidth(1);
        gc.strokeRect(0.5, 0.5, s - 1, s - 1);

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        return canvas.snapshot(params, null);
    }
}
