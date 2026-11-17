package Flyweight;

/**
 * Launcher: starting a class that extends Application directly fails when
 * JavaFX is on the classpath instead of the module path.
 */
public class Main {
    public static void main(String[] args) {
        Game.main(args);
    }
}
