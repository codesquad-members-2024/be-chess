package chess.utils;

import static chess.utils.ErrorMessage.NOT_FOUND_COMMAND;

import java.util.Arrays;

public enum Command {
    START,
    END;

    public static Command of(String input) {
        return Arrays.stream(values())
                .filter(command -> command.name().equals(input.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_COMMAND.getValue()));
    }
}
