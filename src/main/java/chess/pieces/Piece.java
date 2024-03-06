package chess.pieces;

import chess.enums.Color;
import chess.enums.TypeOfPiece;

public class Piece {

    private static final int UNICODE_DIFF = 6;

    public static Piece createWhite(TypeOfPiece type) {
        return new Piece(Color.WHITE, type, type.getRepresent());
    }

    public static Piece createBlack(TypeOfPiece type) {
        return new Piece(Color.BLACK, type, (char) (type.getRepresent() - UNICODE_DIFF));
    }

    public static Piece createBlank(TypeOfPiece type) {
        return new Piece(Color.NO_COLOR, type, TypeOfPiece.NO_PIECE.getRepresent());
    }

    private final Color color;
    private final char represent;
    private final TypeOfPiece type;

    private Piece(Color color, TypeOfPiece type, char represent) {
        this.color = color;
        this.represent = represent;
        this.type = type;

    }

    public Color getColor() {
        return color;
    }

    public char getRepresent() {
        return this.represent;
    }

    public TypeOfPiece getType() {
        return this.type;
    }

    public boolean isWhite() {
        return this.color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return this.color.equals(Color.BLACK);
    }

    public boolean isBlank() {
        return this.type.equals(TypeOfPiece.NO_PIECE);
    }

}
