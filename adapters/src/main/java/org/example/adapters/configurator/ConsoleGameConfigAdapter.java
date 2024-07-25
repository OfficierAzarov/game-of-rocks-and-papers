package org.example.adapters.configurator;

import org.example.application.ports.in.GameConfigPort;

import java.util.Scanner;

public class ConsoleGameConfigAdapter implements GameConfigPort {
    private final Scanner scanner;

    public ConsoleGameConfigAdapter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int getTotalRounds() {
        while (true) {
            try {
                System.out.println(AsciiScreen.welcomeText);
                System.out.println("How many rounds would you like to play?");
                int rounds = Integer.parseInt(scanner.nextLine());
                if (rounds > 0) {
                    return rounds;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    @Override
    public boolean playAgainstComputer() {
        while (true) {
            System.out.println("Do you want to play against the computer? (yes/no)");
            String response = scanner.nextLine().trim().toUpperCase();
            if (response.equals("YES") || response.equals("Y")) {
                return true;
            } else if (response.equalsIgnoreCase("NO") || response.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
