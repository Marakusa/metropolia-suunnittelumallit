package FactoryMethod;

public abstract class Tile {
    private final String character;
    private final String description;

    public Tile(String character, String description) {
        this.character = character;
        this.description = description;
    }

    public String getCharacter() {
        return character;
    }

    public String getDescription() {
        return description;
    }

    public abstract void action();
}
