package org.example.adapters.console;

import org.example.domain.RoundResult;
import org.example.application.ports.out.UserOutputPort;

public class ConsoleUserOutputAdapter implements UserOutputPort {
    @Override
    public void showRoundResult(RoundResult result) {
        System.out.println("You played: " + result.getPlayer1Move());
        System.out.println("Your opponent played: " + result.getPlayer2Move());
        System.out.println("Your result is: " + result.getResult());
    }

    @Override
    public void showFinalResult(int player1Wins, int player2Wins) {
        System.out.println("Game Over!");
        System.out.println("Player 1 Wins: " + player1Wins);
        System.out.println("Player 2 Wins: " + player2Wins);
        if (player1Wins > player2Wins) {
            System.out.println("Player 1 is the winner!");
        } else if (player2Wins > player1Wins) {
            System.out.println("Player 2 is the winner!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}