package org.example.domain;

public class EvaluateRoundService {
    public Result evaluateGame(Move player1Move, Move player2Move) {

        validatePlayerMove(player1Move);
        validatePlayerMove(player2Move);

        if (player1Move == player2Move) {
            return Result.DRAW;
        }
        switch (player1Move) {
            case ROCK:
                return (player2Move == Move.SCISSORS) ? Result.WIN : Result.LOSE;
            case PAPER:
                return (player2Move == Move.ROCK) ? Result.WIN : Result.LOSE;
            case SCISSORS:
                return (player2Move == Move.PAPER) ? Result.WIN : Result.LOSE;
            default:
                throw new IllegalArgumentException("Unknown move: " + player1Move);
        }
    }

    private void validatePlayerMove(Move playerMove) {
        if (playerMove == null) {
            throw new IllegalArgumentException("Player move cannot be null");
        }
    }
}
