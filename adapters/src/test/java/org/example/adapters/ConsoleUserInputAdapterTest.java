package org.example.adapters;

import org.example.adapters.console.ConsoleUserInputAdapter;
import org.example.domain.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConsoleUserInputAdapterTest {

    @Mock
    private Scanner scannerMock;

    private ConsoleUserInputAdapter userInputAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userInputAdapter = new ConsoleUserInputAdapter(scannerMock);
    }

    @Test
    public void shouldReturnRockForValidInput() {
        // Given
        when(scannerMock.nextLine()).thenReturn("rock");

        // When
        Move move = userInputAdapter.getPlayerMove();

        // Then
        assertEquals(Move.ROCK, move);
    }

    @Test
    public void shouldAskAgainIfInvalidInputThenReturnScissors() {
        // Given
        when(scannerMock.nextLine()).thenReturn("invalid", "scissors");

        // When
        Move move = userInputAdapter.getPlayerMove();

        // Then
        assertEquals(Move.SCISSORS, move);
        verify(scannerMock, times(2)).nextLine();
    }
}
