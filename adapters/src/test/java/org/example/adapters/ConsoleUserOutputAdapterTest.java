package org.example.adapters;

import org.example.adapters.console.ConsoleUserOutputAdapter;
import org.example.domain.RoundResult;
import org.example.domain.Move;
import org.example.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleUserOutputAdapterTest {

    private ConsoleUserOutputAdapter outputAdapter;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        outputAdapter = new ConsoleUserOutputAdapter();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldDisplayPlayerMovesAndResultForWin() {
        // Given
        RoundResult result = new RoundResult(Move.ROCK, Move.SCISSORS, Result.WIN);

        // When
        outputAdapter.showRoundResult(result);

        // Then
        String expectedOutput = "You played: ROCK\n" +
                "Your opponent played: SCISSORS\n" +
                "Your result is: WIN";
        assertEquals(TestUtils.normalizeLineEndings(expectedOutput), outputStreamCaptor.toString().trim());
    }

    @Test
    public void shouldDisplayPlayerMovesAndResultForDraw() {
        // Given
        RoundResult result = new RoundResult(Move.PAPER, Move.PAPER, Result.DRAW);

        // When
        outputAdapter.showRoundResult(result);

        // Then
        String expectedOutput = "You played: PAPER\n" +
                "Your opponent played: PAPER\n" +
                "Your result is: DRAW";
        assertEquals(TestUtils.normalizeLineEndings(expectedOutput), outputStreamCaptor.toString().trim());
    }

    @Test
    public void shouldDisplayPlayerMovesAndResultForLoss() {
        // Given
        RoundResult result = new RoundResult(Move.SCISSORS, Move.ROCK, Result.LOSE);

        // When
        outputAdapter.showRoundResult(result);

        // Then
        String expectedOutput = "You played: SCISSORS\n" +
                "Your opponent played: ROCK\n" +
                "Your result is: LOSE";
        assertEquals(TestUtils.normalizeLineEndings(expectedOutput), outputStreamCaptor.toString().trim());
    }
}
