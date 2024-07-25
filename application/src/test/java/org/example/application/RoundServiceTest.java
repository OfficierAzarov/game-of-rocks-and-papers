package org.example.application;

import org.example.domain.EvaluateRoundService;
import org.example.domain.RoundResult;
import org.example.domain.Move;
import org.example.domain.Player;
import org.example.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RoundServiceTest {

    @Mock
    private EvaluateRoundService evaluateRoundServiceMock;

    @Mock
    private Player player1Mock;

    @Mock
    private Player player2Mock;

    private RoundService roundService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        roundService = new RoundService(evaluateRoundServiceMock, player1Mock, player2Mock);
    }

    @Test
    void shouldReturnCorrectGameResultWhenPlayer1Wins() {
        // Given
        Move player1Move = Move.ROCK;
        Move player2Move = Move.SCISSORS;
        Result expectedResult = Result.WIN;

        when(player1Mock.getMove()).thenReturn(player1Move);
        when(player2Mock.getMove()).thenReturn(player2Move);
        when(evaluateRoundServiceMock.evaluateGame(player1Move, player2Move)).thenReturn(expectedResult);

        // When
        RoundResult result = roundService.playRound();

        // Then
        assertEquals(player1Move, result.getPlayer1Move());
        assertEquals(player2Move, result.getPlayer2Move());
        assertEquals(expectedResult, result.getResult());

    }

    @Test
    void shouldReturnCorrectGameResultWhenPlayer2Wins() {
        // Given
        Move player1Move = Move.PAPER;
        Move player2Move = Move.SCISSORS;
        Result expectedResult = Result.LOSE;

        when(player1Mock.getMove()).thenReturn(player1Move);
        when(player2Mock.getMove()).thenReturn(player2Move);
        when(evaluateRoundServiceMock.evaluateGame(player1Move, player2Move)).thenReturn(expectedResult);

        // When
        RoundResult result = roundService.playRound();

        // Then
        assertEquals(player1Move, result.getPlayer1Move());
        assertEquals(player2Move, result.getPlayer2Move());
        assertEquals(expectedResult, result.getResult());

    }
}
