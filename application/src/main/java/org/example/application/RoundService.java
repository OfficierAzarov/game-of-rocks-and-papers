package org.example.application;

import org.example.domain.*;

public class RoundService {
    private final EvaluateRoundService evaluateRoundService;
    private final Player player1;
    private final Player player2;

    public RoundService(EvaluateRoundService evaluateRoundService, Player player1, Player player2) {
        this.evaluateRoundService = evaluateRoundService;
        this.player1 = player1;
        this.player2 = player2;
    }

    public RoundResult playRound() {
        Move player1Move = player1.getMove();
        Move player2Move = player2.getMove();
        Result result = evaluateRoundService.evaluateGame(player1Move, player2Move);
        return new RoundResult(player1Move, player2Move, result);
    }
}