package chess.utils;

import static chess.utils.ErrorMessage.NOT_FOUND_COMMAND;

import java.util.Arrays;

public enum MainCommand {
    START,
    END;

    public static MainCommand of(String input) {
        return Arrays.stream(values())
                .filter(mainCommand -> mainCommand.name().equals(input.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_COMMAND.getValue()));
    }
}
