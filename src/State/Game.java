package State;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==================");
        System.out.println("   THE RPG GAME   ");
        System.out.println("==================");

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        GameCharacter character = new GameCharacter(name);

        boolean running = true;

        while (running) {

            character.showStatus();

            if (character.getState() instanceof MasterState) {
                System.out.println("You have reached the Master level!");
                System.out.println("Congratulations, " + character.getName() + "!");
                System.out.println("Game complete.");

                running = false;
                continue;
            }

            System.out.print("Choose an action: ");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "train":
                    character.train();
                    break;

                case "meditate":
                    character.meditate();
                    break;

                case "fight":
                    character.fight();
                    break;

                case "q":
                case "quit":
                    running = false;
                    System.out.println("Game ended.");
                    break;

                default:
                    System.out.println("Unknown action.");
                    System.out.println("Please choose one of the available actions.");
                    break;
            }
        }

        scanner.close();
    }
}
