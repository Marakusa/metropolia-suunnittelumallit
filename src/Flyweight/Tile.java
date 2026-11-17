package Flyweight;

/**
 * A tile on the map. The tile only knows its type (intrinsic state).
 * Its position (extrinsic state) is stored by the Map as the array index
 * and is passed in when the tile is rendered.
 */
public abstract class Tile {
    private final TileType type;

    protected Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    public String getCharacter() {
        return type.getCharacter();
    }

    public String getDescription() {
        return type.getDescription();
    }

    public abstract void action();
}
