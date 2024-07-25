package org.example.adapters.players;

import org.example.domain.Move;
import org.example.domain.Player;

import java.util.Random;

public class ComputerPlayer implements Player {
    @Override
    public Move getMove() {
        Move[] moves = Move.values();
        return moves[new Random().nextInt(moves.length)];
    }
}