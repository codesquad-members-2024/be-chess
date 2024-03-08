package chess.pieces;

import java.util.Arrays;
import java.util.Map;

public enum Representation {
    PAWN(Map.ofEntries(
            Map.entry(Color.WHITE, "♙"),
            Map.entry(Color.BLACK, "♟"))),
    KNIGHT(Map.ofEntries(
            Map.entry(Color.WHITE, "♘"),
            Map.entry(Color.BLACK, "♞"))),
    ROOK(Map.ofEntries(
            Map.entry(Color.WHITE, "♖"),
            Map.entry(Color.BLACK, "♜"))),
    BISHOP(Map.ofEntries(
            Map.entry(Color.WHITE, "♗"),
            Map.entry(Color.BLACK, "♝"))),
    QUEEN(Map.ofEntries(
            Map.entry(Color.WHITE, "♕"),
            Map.entry(Color.BLACK, "♛"))),
    KING(Map.ofEntries(
            Map.entry(Color.WHITE, "♔"),
            Map.entry(Color.BLACK, "♚")));


    private final Map<Color, String> representationByColors;

    Representation(Map<Color, String> representationByColors){
        this.representationByColors = representationByColors;
    }

    public static String of(String pieceName, Color pieceColor) {
        return Arrays.stream(values())
                .filter(r -> r.name().toLowerCase().equals(pieceName))
                .findFirst()
                .map(r -> r.getRepresentationByColors().get(pieceColor))
                .orElseThrow();
    }

    private Map<Color, String> getRepresentationByColors() {
        return representationByColors;
    }
}