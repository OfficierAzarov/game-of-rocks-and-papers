package utils;

public class TestUtils {

    public static String normalizeLineEndings(String input) {
        return input.replaceAll("\\R", System.lineSeparator());
    }
}
