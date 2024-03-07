package chess.pieces;

import chess.enums.Color;
import chess.enums.TypeOfPiece;

public abstract class Piece {

    protected static final int UNICODE_DIFF = 6;

    public abstract Piece create(Color color);

    private final Color color;
    private final char represent;
    private final TypeOfPiece type;

    protected Piece(Color color, TypeOfPiece type, char represent) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piece) {
            Piece piece = (Piece) obj;
            return piece.getType().equals(this.type) && piece.getColor().equals(this.color);
        }
        return false;
    }
}
