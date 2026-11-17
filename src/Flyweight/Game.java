package Flyweight;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int MAP_SIZE = 16;

    private final Canvas canvas = new Canvas();
    private final MapRenderer renderer = new MapRenderer(TileGraphicFactory.TILE_SIZE);
    private final Label infoLabel = new Label();
    private final Label tileLabel = new Label("Hover over a tile to see what it is.");
    private Map map;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button cityButton = new Button("City map");
        Button wildernessButton = new Button("Wilderness map");
        cityButton.setOnAction(e -> showMap(new CityMap(MAP_SIZE, MAP_SIZE)));
        wildernessButton.setOnAction(e -> showMap(new WildernessMap(MAP_SIZE, MAP_SIZE)));

        HBox controls = new HBox(10, cityButton, wildernessButton, infoLabel);
        controls.setAlignment(Pos.CENTER_LEFT);
        controls.setPadding(new Insets(10));

        canvas.setOnMouseMoved(e -> {
            if (map == null) return;
            int x = (int) (e.getX() / renderer.getTileSize());
            int y = (int) (e.getY() / renderer.getTileSize());
            if (x < map.getWidth() && y < map.getHeight()) {
                tileLabel.setText("(" + x + ", " + y + ") " + map.getTile(x, y).getDescription());
            }
        });
        canvas.setOnMouseClicked(e -> {
            if (map == null) return;
            int x = (int) (e.getX() / renderer.getTileSize());
            int y = (int) (e.getY() / renderer.getTileSize());
            if (x < map.getWidth() && y < map.getHeight()) {
                map.getTile(x, y).action();
            }
        });
        tileLabel.setPadding(new Insets(6, 10, 10, 10));

        BorderPane root = new BorderPane(canvas);
        root.setTop(controls);
        root.setBottom(tileLabel);

        showMap(new WildernessMap(MAP_SIZE, MAP_SIZE));

        stage.setTitle("RPG Map - Flyweight");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    private void showMap(Map newMap) {
        map = newMap;
        map.display();
        renderer.render(map, canvas);
        int tiles = map.getWidth() * map.getHeight();
        infoLabel.setText(tiles + " tiles drawn with " + TileGraphicFactory.getCreatedCount() + " shared graphics");
    }
}
