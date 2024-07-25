package org.example.application.ports.out;

import org.example.domain.RoundResult;

public interface UserOutputPort {
    void showRoundResult(RoundResult result);

    void showFinalResult(int player1Wins, int player2Wins);
}