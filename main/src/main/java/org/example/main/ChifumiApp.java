package org.example.main;
import org.example.adapters.configurator.ConsoleGameConfigAdapter;
import org.example.adapters.console.ConsoleUserInputAdapter;
import org.example.adapters.console.ConsoleUserOutputAdapter;
import org.example.adapters.players.ComputerPlayer;
import org.example.adapters.players.HumanPlayer;
import org.example.application.GameService;
import org.example.application.RoundService;
import org.example.application.ports.in.GameConfigPort;
import org.example.application.ports.in.UserInputPort;
import org.example.application.ports.out.UserOutputPort;
import org.example.domain.Player;
import org.example.domain.EvaluateRoundService;

import java.util.Scanner;

public class ChifumiApp {

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            GameConfigPort configPort = new ConsoleGameConfigAdapter(scanner);
            UserInputPort inputPort = new ConsoleUserInputAdapter(scanner);
            UserOutputPort outputPort = new ConsoleUserOutputAdapter();
            EvaluateRoundService evaluateRoundService = new EvaluateRoundService();

            int totalRounds = configPort.getTotalRounds();

            // Uncomment next line if you want to have the option of playing against a fellow human
            boolean againstComputer = configPort.playAgainstComputer();

            Player player1 = new HumanPlayer(inputPort);

            // Comment next line if you want to have the option of playing against a fellow human
            // Player player2 = new ComputerPlayer();
            // Uncomment next line if you want to have the option of playing against a fellow human
            Player player2 = againstComputer ? new ComputerPlayer() : new HumanPlayer(inputPort);

            RoundService roundService = new RoundService(evaluateRoundService, player1, player2);
            GameService gameService = new GameService(roundService, outputPort, totalRounds);

            gameService.playGame();
        }
    }

}
