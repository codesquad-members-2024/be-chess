package chess.pieces;

import static chess.utils.ErrorMessage.NOT_FOUND_REPRESENTATION;

import java.util.Arrays;

public enum Representation {
    WHITE_PAWN("p"), BLACK_PAWN("P"),
    WHITE_KNIGHT("n"), BLACK_KNIGHT("N"),
    WHITE_ROOK("r"), BLACK_ROOK("R"),
    WHITE_BISHOP("b"), BLACK_BISHOP("B"),
    WHITE_QUEEN("q"), BLACK_QUEEN("Q"),
    WHITE_KING("k"), BLACK_KING("K");
    private final String value;

    Representation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Representation of(Name name, Color color) {
        return Arrays.stream(values())
                .filter(representation -> representation.name().contains(name.name())
                        && representation.name().contains(color.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_REPRESENTATION.getValue()));
    }
}
