package racingcar.view;

import java.util.Arrays;
import java.util.regex.Pattern;
import racingcar.exception.IllegalInputException;

public class InputValidator {

    public static void validateInputCars(final String input) {
        validateValueIsEmpty(input);
        validateNameMatchedNameRegex(input);
    }

    public static void validateCars(final String input) {
        validateNameCount(input);
    }

    public static void validateCar(final String name) {
        validateNameLength(name);
    }

    public static void validateInputNumber(final String input) {
        validateValueIsEmpty(input);
        validateNumberMatchedNumberRegex(input);
    }

    private static void validateValueIsEmpty(final String input) {
        if (input.isBlank()) {
            throw new IllegalInputException();
        }
    }

    private static void validateNameMatchedNameRegex(final String input) {
        final String regex = "^[a-z]+(,[a-z]+)*$";

        if (!Pattern.matches(regex, input)) {
            throw new IllegalInputException();
        }
    }

    private static void validateNumberMatchedNumberRegex(final String input) {
        final String regex = "^[1-9]\\d*$";

        if (!Pattern.matches(regex, input)) {
            throw new IllegalInputException();
        }
    }

    private static void validateNameCount(final String input) {
        if (Arrays.stream(input.split(",")).count() <= 1) {
            throw new IllegalInputException();
        }
    }

    private static void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalInputException();
        }
    }
}