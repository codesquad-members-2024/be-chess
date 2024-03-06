package chess.pieces;

import static chess.common.Color.*;
import static chess.pieces.Piece.Type.*;

import chess.common.Color;
import java.util.function.Function;

public class Piece {
    private final Color color;
    private final String name;
    private final Type type;
    private final Function<Piece, String> representation = piece -> piece.isWhite() ? piece.type.whiteRepresentation : piece.type.blackRepresentation;

    private Piece(Color color, String name, Type type) {
        this.color = color;
        this.name = name;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE, PAWN.allowedName, PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, PAWN.allowedName, PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE, KNIGHT.allowedName, KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK, KNIGHT.allowedName, KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE, BISHOP.allowedName, BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK, BISHOP.allowedName, BISHOP);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE, ROOK.allowedName, ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK, ROOK.allowedName, ROOK);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE, QUEEN.allowedName, QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK, QUEEN.allowedName, QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE, KING.allowedName, KING);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK, KING.allowedName, KING);
    }
    public static Piece createBlank() {
        return new Piece(NO_COLOR, NO_PIECE.allowedName, NO_PIECE);
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getRepresentation() {
        return representation.apply(this);
    }

    public boolean isBlack() {
        return color.equals(BLACK);
    }

    public boolean isWhite() {
        return color.equals(WHITE);
    }

    public boolean isPawn() {
        return type.equals(PAWN);
    }

    public boolean isSameColor(Color color) {
        return this.color.equals(color);
    }

    public enum Type {
        PAWN("♙", "♟", "pawn"),
        KNIGHT("♘", "♞", "knight"),
        BISHOP("♗", "♝", "bishop"),
        ROOK("♖", "♜", "rook"),
        QUEEN("♕", "♛", "queen"),
        KING("♔", "♚", "king"),
        NO_PIECE(".", ".", "blank"),
        ;

        public final String whiteRepresentation;
        public final String blackRepresentation;
        public final String allowedName;

        Type(String whiteRepresentation, String blackRepresentation, String allowedName) {
            this.whiteRepresentation = whiteRepresentation;
            this.blackRepresentation = blackRepresentation;
            this.allowedName = allowedName;
        }
    }
}
