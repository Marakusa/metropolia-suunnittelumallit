package FactoryMethod;

public class SwampTile extends Tile {
    public SwampTile() {
        super("S", "Swamp area, muddy and wet.");
    }

    @Override
    public void action() {
        System.out.println("You are in a swamp. It's wet and muddy.");
    }
}
