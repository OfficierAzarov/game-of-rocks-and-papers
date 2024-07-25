package org.example.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class RoundResult {

    private final Move player1Move;
    private final Move player2Move;
    private final Result result;

    public RoundResult(Move player1Move, Move player2Move, Result result) {
        this.player1Move = player1Move;
        this.player2Move = player2Move;
        this.result = result;
    }
}