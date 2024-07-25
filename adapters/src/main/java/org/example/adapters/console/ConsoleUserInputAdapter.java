package org.example.adapters.console;

import org.example.domain.Move;
import org.example.application.ports.in.UserInputPort;

import java.util.Scanner;

public class ConsoleUserInputAdapter implements UserInputPort {
    private final Scanner scanner;

    public ConsoleUserInputAdapter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Move getPlayerMove() {
        Move move = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter your move (ROCK, PAPER, SCISSORS):");
            String input = scanner.nextLine().trim().toUpperCase();

            try {
                move = Move.valueOf(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter ROCK, PAPER, or SCISSORS.");
            }
        }

        return move;
    }
}
