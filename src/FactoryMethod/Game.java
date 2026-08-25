package FactoryMethod;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        createMap();
    }

    private static void createMap() {
        Scanner scanner = new Scanner(System.in);
        String mapType;
        do {
            System.out.print("Which type of map do you want to generate? ( c:City , w:Wilderness ): ");
            mapType = scanner.next();
            if (!mapType.equals("c") && !mapType.equals("w")) {
                System.out.print("Invalid input.");
            }
        } while (!mapType.equals("c") && !mapType.equals("w"));

        int size = 16;
        Map map;

        if (mapType.equals("c")) {
            map = new CityMap(size, size);
        } else {
            map = new WildernessMap(size, size);
        }

        map.display();
    }
}
