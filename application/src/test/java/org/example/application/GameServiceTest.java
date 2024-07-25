package org.example.application;

import org.example.application.ports.out.UserOutputPort;
import org.example.domain.RoundResult;
import org.example.domain.Move;
import org.example.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class GameServiceTest {

    @Mock
    private RoundService roundServiceMock;

    @Mock
    private UserOutputPort outputPortMock;

    private GameService gameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        int totalRounds = 3;
        gameService = new GameService(roundServiceMock, outputPortMock, totalRounds);
    }

    @Test
    void shouldShowFinalResultPlayer1Wins() {
        // Given
        RoundResult winResult = new RoundResult(Move.ROCK, Move.SCISSORS, Result.WIN);
        RoundResult winResult2 = new RoundResult(Move.PAPER, Move.ROCK, Result.WIN);
        RoundResult loseResult = new RoundResult(Move.SCISSORS, Move.ROCK, Result.LOSE);

        when(roundServiceMock.playRound()).thenReturn(winResult, winResult2, loseResult);

        // When
        gameService.playGame();

        // Then
        verify(outputPortMock).showRoundResult(new RoundResult(Move.ROCK, Move.SCISSORS, Result.WIN));
        verify(outputPortMock).showRoundResult(new RoundResult(Move.PAPER, Move.ROCK, Result.WIN));
        verify(outputPortMock).showRoundResult(new RoundResult(Move.SCISSORS, Move.ROCK, Result.LOSE));
    }

    @Test
    void shouldShowFinalResultPlayer2Wins() {
        // Given
        RoundResult loseResult = new RoundResult(Move.SCISSORS, Move.ROCK, Result.LOSE);
        RoundResult loseResult2 = new RoundResult(Move.PAPER, Move.SCISSORS, Result.LOSE);
        RoundResult winResult = new RoundResult(Move.ROCK, Move.SCISSORS, Result.WIN);

        when(roundServiceMock.playRound()).thenReturn(loseResult, loseResult2, winResult);

        // When
        gameService.playGame();

        // Then
        verify(outputPortMock).showRoundResult(new RoundResult(Move.SCISSORS, Move.ROCK, Result.LOSE));
        verify(outputPortMock).showRoundResult(new RoundResult(Move.PAPER, Move.SCISSORS, Result.LOSE));
        verify(outputPortMock).showRoundResult(new RoundResult(Move.ROCK, Move.SCISSORS, Result.WIN));
    }

    @Test
    void shouldShowFinalResultDraw() {
        // Given
        RoundResult drawResult = new RoundResult(Move.ROCK, Move.ROCK, Result.DRAW);
        RoundResult winResult = new RoundResult(Move.PAPER, Move.ROCK, Result.WIN);
        RoundResult loseResult = new RoundResult(Move.SCISSORS, Move.ROCK, Result.LOSE);

        when(roundServiceMock.playRound()).thenReturn(drawResult, winResult, loseResult);

        // When
        gameService.playGame();

        // Then
        verify(outputPortMock).showRoundResult(new RoundResult(Move.ROCK, Move.ROCK, Result.DRAW));
        verify(outputPortMock).showRoundResult(new RoundResult(Move.PAPER, Move.ROCK, Result.WIN));
        verify(outputPortMock).showRoundResult(new RoundResult(Move.SCISSORS, Move.ROCK, Result.LOSE));
    }
}