package TemplateMethod;

import java.util.Scanner;

public class FightGame extends Game {
    private Fighter[] fighters;

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Initializing a fight game with " + numberOfPlayers + " players.");
        fighters = new Fighter[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            fighters[i] = new Fighter(i + 1, 100);
            System.out.println(fighters[i].getStatus());
        }
    }

    @Override
    public boolean endOfGame() {
        int playersAlive = 0;
        for (Fighter fighter : fighters) {
            if (!fighter.isDead()) {
                playersAlive++;
            }
        }
        return playersAlive < 2;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Player " + (player + 1) + "'s turn.");

        // Wait for players input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to attack...");
        scanner.nextLine();

        int opponent = (player + 1) % fighters.length;
        int damage = (int) (Math.random() * 50) + 1; // Random damage between 1 and 20
        System.out.println("Player " + (player + 1) + " attacks Player " + (opponent + 1) + " for " + damage + " damage.");
        fighters[opponent].takeDamage(damage);
        System.out.println(fighters[opponent].getStatus());
    }

    @Override
    public void displayWinner() {
        System.out.println("Game over!");
        for (Fighter fighter : fighters) {
            if (!fighter.isDead()) {
                System.out.println("Player " + (fighter.getStatus().split(" ")[1]) + " wins!");
                return;
            }
        }
    }
}
