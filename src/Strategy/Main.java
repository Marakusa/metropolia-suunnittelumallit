package Strategy;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("For random generated numbers write 'r'");
        System.out.println("Write multiple numbers separated by comma (i.e. 1,4,8,3,5):");
        String input = scanner.nextLine();

        int[] numbers;

        if (input.equalsIgnoreCase("r")) {
            System.out.println("Enter the number of random numbers to generate:");
            int n = scanner.nextInt();
            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = (int) (Math.random() * 100); // Random numbers between 0 and 99
            }
        } else {
            String[] split = input.split(",");
            numbers = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                numbers[i] = Integer.parseInt(split[i].trim());
            }
        }

        System.out.println("Choose algorithm.");
        System.out.println("1. Sort by set bit count");
        System.out.println("2. Sort in wave");
        System.out.println("3. Find missing range");

        int choice = scanner.nextInt();
        SortingStrategy strategy = switch (choice) {
            case 1 -> new SortBySetBitCount();
            case 2 -> new SortInWave();
            case 3 -> new MissingRange();
            default -> throw new NoSuchElementException("Invalid choice");
        };

        ArrayList<Integer> output = strategy.execute(numbers);
        System.out.println(output);
    }
}
