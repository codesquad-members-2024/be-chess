package chess.pieces;

import java.util.Arrays;

public enum Representation {
    pawn("♙", "♟"),
    knight("♘", "♞"),
    rook("♖", "♜"),
    bishop("♗", "♝"),
    queen("♕", "♛"),
    king("♔", "♚");

    private final String representationWhite;
    private final String representationBlack;

    Representation(String representationWhite, String representationBlack) {
        this.representationWhite = representationWhite;
        this.representationBlack = representationBlack;
    }

    public String getRepresentationWhite() {
        return representationWhite;
    }

    public String getRepresentationBlack() {
        return representationBlack;
    }

    public static String getRepresentation(final String name, final String color) {
        Representation representation = Arrays.stream(Representation.values())
                .filter(rep -> rep.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기물입니다."));

        if (color.equals(Piece.WHITE_COLOR)) {
            return representation.representationWhite;
        } else if (color.equals(Piece.BLACK_COLOR)) {
            return representation.representationBlack;
        }
        throw new IllegalArgumentException("존재하지 않는 색상입니다.");
    }
}
