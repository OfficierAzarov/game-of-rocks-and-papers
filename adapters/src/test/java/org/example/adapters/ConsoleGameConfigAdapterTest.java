package org.example.adapters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.example.adapters.configurator.ConsoleGameConfigAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ConsoleGameConfigAdapterTest {
    @Mock
    private Scanner scannerMock;

    private ConsoleGameConfigAdapter gameConfigAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameConfigAdapter = new ConsoleGameConfigAdapter(scannerMock);
    }

    @Test
    void shouldReturnTotalRoundsForValidInput() {
        // Given
        when(scannerMock.nextLine()).thenReturn("4");

        // When
        int result = gameConfigAdapter.getTotalRounds();

        // Then
        assertEquals(4, result);
    }

    @Test
    void shouldAskAgainIfInvalidStringInputThenReturnTotalRounds() {
        // Given
        when(scannerMock.nextLine()).thenReturn("invalid", "3");

        // When
        int result = gameConfigAdapter.getTotalRounds();

        // Then
        assertEquals(3, result);
        verify(scannerMock, times(2)).nextLine();
    }

    @Test
    void shouldAskAgainIfInvalidNegativeNumberInputThenReturnTotalRounds() {
        // Given
        when(scannerMock.nextLine()).thenReturn("-1", "2");

        // When
        int result = gameConfigAdapter.getTotalRounds();

        // Then
        assertEquals(2, result);
    }

    @Test
    void shouldReturnTrueForPlayAgainstComputerYes() {
        // Given
        when(scannerMock.nextLine()).thenReturn("yes");

        // When
        boolean result = gameConfigAdapter.playAgainstComputer();

        // Then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForPlayAgainstComputerNo() {
        // Given
        when(scannerMock.nextLine()).thenReturn("no");

        // When
        boolean result = gameConfigAdapter.playAgainstComputer();

        // Then
        assertFalse(result);
    }

    @Test
    void shouldAskAgainAfterInvalidStringInputThenReturnYesForPlayAgainstComputer() {
        // Given
        when(scannerMock.nextLine()).thenReturn("maybe", "yes");

        // When
        boolean result = gameConfigAdapter.playAgainstComputer();

        // Then
        assertTrue(result);
        verify(scannerMock, times(2)).nextLine();
    }

    @Test
    void shouldAskAgainAfterInvalidStringInputThenReturnNoForPlayAgainstComputer() {
        // Given
        when(scannerMock.nextLine()).thenReturn("maybe", "no");

        // When
        boolean result = gameConfigAdapter.playAgainstComputer();

        // Then
        assertFalse(result);
        verify(scannerMock, times(2)).nextLine();
    }
}
