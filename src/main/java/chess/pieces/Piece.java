package chess.pieces;

import chess.enums.Color;
import chess.enums.Direction;
import chess.enums.TypeOfPiece;

import java.util.List;

public abstract class Piece {

    protected static final int UNICODE_DIFF = 6;

    protected final Color color;
    protected final char represent;
    protected final TypeOfPiece type;

    protected Piece(Color color, TypeOfPiece type, char represent) {
        this.color = color;
        this.represent = represent;
        this.type = type;

    }

    public abstract Piece create(Color color);

    public abstract List<Direction> getDirections() throws IllegalArgumentException;

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
