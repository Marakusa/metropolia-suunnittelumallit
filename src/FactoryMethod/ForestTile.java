package FactoryMethod;

public class ForestTile extends Tile {
    public ForestTile() {
        super("^", "Forest area, full of trees and wildlife.");
    }

    @Override
    public void action() {
        System.out.println("You are in a forest. Watch out for wild animals!");
    }
}
