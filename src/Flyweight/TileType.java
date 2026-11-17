package Flyweight;

import javafx.scene.paint.Color;

/**
 * Intrinsic state of a tile: everything that is the same for every tile of one type.
 */
public enum TileType {
    FOREST("^", "Forest area, full of trees and wildlife.", Color.web("#3f7f3a")),
    WATER("~", "Water area, deep and dangerous.", Color.web("#3a6fb0")),
    SWAMP("S", "Swamp area, muddy and wet.", Color.web("#5f6b3a")),
    ROAD("=", "Road tile, you can drive on it.", Color.web("#8a8a8a")),
    BUILDING("#", "Building tile.", Color.web("#b5651d"));

    private final String character;
    private final String description;
    private final Color baseColor;

    TileType(String character, String description, Color baseColor) {
        this.character = character;
        this.description = description;
        this.baseColor = baseColor;
    }

    public String getCharacter() {
        return character;
    }

    public String getDescription() {
        return description;
    }

    public Color getBaseColor() {
        return baseColor;
    }
}
