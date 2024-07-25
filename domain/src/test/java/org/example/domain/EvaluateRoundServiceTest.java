package org.example.domain;

import org.example.domain.EvaluateRoundService;
import org.example.domain.Move;
import org.example.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluateRoundServiceTest {

    private EvaluateRoundService evaluateRoundService;

    @BeforeEach
    public void setUp() {
        evaluateRoundService = new EvaluateRoundService();
    }

    @Test
    public void shouldReturnDrawWhenBothPlayersMakeSameMove() {
        // Given
        Move player1Move = Move.ROCK;
        Move player2Move = Move.ROCK;

        // When
        Result result = evaluateRoundService.evaluateGame(player1Move, player2Move);

        // Then
        assertEquals(Result.DRAW, result);
    }

    @Test
    public void shouldReturnWinWhenPlayer1RockAndPlayer2Scissors() {
        // Given
        Move player1Move = Move.ROCK;
        Move player2Move = Move.SCISSORS;

        // When
        Result result = evaluateRoundService.evaluateGame(player1Move, player2Move);

        // Then
        assertEquals(Result.WIN, result);
    }

    @Test
    public void shouldReturnLoseWhenPlayer1RockAndPlayer2Paper() {
        // Given
        Move player1Move = Move.ROCK;
        Move player2Move = Move.PAPER;

        // When
        Result result = evaluateRoundService.evaluateGame(player1Move, player2Move);

        // Then
        assertEquals(Result.LOSE, result);
    }

    @Test
    public void shouldReturnWinWhenPlayer1PaperAndPlayer2Rock() {
        // Given
        Move player1Move = Move.PAPER;
        Move player2Move = Move.ROCK;

        // When
        Result result = evaluateRoundService.evaluateGame(player1Move, player2Move);

        // Then
        assertEquals(Result.WIN, result);
    }

    @Test
    public void shouldReturnLoseWhenPlayer1PaperAndPlayer2Scissors() {
        // Given
        Move player1Move = Move.PAPER;
        Move player2Move = Move.SCISSORS;

        // When
        Result result = evaluateRoundService.evaluateGame(player1Move, player2Move);

        // Then
        assertEquals(Result.LOSE, result);
    }

    @Test
    public void shouldReturnWinWhenPlayer1ScissorsAndPlayer2Paper() {
        // Given
        Move player1Move = Move.SCISSORS;
        Move player2Move = Move.PAPER;

        // When
        Result result = evaluateRoundService.evaluateGame(player1Move, player2Move);

        // Then
        assertEquals(Result.WIN, result);
    }

    @Test
    public void shouldReturnLoseWhenPlayer1ScissorsAndPlayer2Rock() {
        // Given
        Move player1Move = Move.SCISSORS;
        Move player2Move = Move.ROCK;

        // When
        Result result = evaluateRoundService.evaluateGame(player1Move, player2Move);

        // Then
        assertEquals(Result.LOSE, result);
    }

    @Test
    public void shouldThrowExceptionForNullPlayer1Move() {
        // Given
        Move player1Move = null;
        Move player2Move = Move.ROCK;

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> evaluateRoundService.evaluateGame(player1Move, player2Move));
    }

    @Test
    public void shouldThrowExceptionForNullPlayer2Move() {
        // Given
        Move player1Move = Move.ROCK;
        Move player2Move = null;

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> evaluateRoundService.evaluateGame(player1Move, player2Move));
    }

    @Test
    public void shouldThrowExceptionForBothPlayersNullMove() {
        // Given
        Move player1Move = null;
        Move player2Move = null;

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> evaluateRoundService.evaluateGame(player1Move, player2Move));
    }
}
