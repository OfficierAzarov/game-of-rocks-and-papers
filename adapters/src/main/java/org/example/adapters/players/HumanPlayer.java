package org.example.adapters.players;

import org.example.domain.Move;
import org.example.domain.Player;
import org.example.application.ports.in.UserInputPort;

public class HumanPlayer implements Player {
    private final UserInputPort inputPort;

    public HumanPlayer(UserInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @Override
    public Move getMove() {
        return inputPort.getPlayerMove();
    }
}