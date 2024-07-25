package org.example.application;

import org.example.application.ports.out.UserOutputPort;
import org.example.domain.RoundResult;
import org.example.domain.Result;

public class GameService {
    private final RoundService roundService;
    private final UserOutputPort outputPort;
    private final int totalRounds;
    private int currentRound;
    private int player1Wins;
    private int player2Wins;

    public GameService(RoundService roundService, UserOutputPort outputPort, int totalRounds) {
        this.roundService = roundService;
        this.outputPort = outputPort;
        this.totalRounds = totalRounds;
        this.currentRound = 0;
        this.player1Wins = 0;
        this.player2Wins = 0;
    }

    public void playGame() {
        while (currentRound < totalRounds) {
            RoundResult result = roundService.playRound();
            outputPort.showRoundResult(result);
            updateScore(result);
            currentRound++;
        }
        outputPort.showFinalResult(player1Wins, player2Wins);
    }

    private void updateScore(RoundResult result) {
        if (result.getResult() == Result.WIN) {
            player1Wins++;
        } else if (result.getResult() == Result.LOSE) {
            player2Wins++;
        }
    }
}
