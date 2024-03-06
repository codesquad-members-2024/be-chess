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
        return createPiece(WHITE, PAWN);
    }

    public static Piece createBlackPawn() {
        return createPiece(BLACK, PAWN);
    }

    public static Piece createWhiteKnight() {
        return createPiece(WHITE, KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createPiece(BLACK, KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return createPiece(WHITE, BISHOP);
    }

    public static Piece createBlackBishop() {
        return createPiece(BLACK, BISHOP);
    }

    public static Piece createWhiteRook() {
        return createPiece(WHITE, ROOK);
    }

    public static Piece createBlackRook() {
        return createPiece(BLACK, ROOK);
    }

    public static Piece createWhiteQueen() {
        return createPiece(WHITE, QUEEN);
    }

    public static Piece createBlackQueen() {
        return createPiece(BLACK, QUEEN);
    }

    public static Piece createWhiteKing() {
        return createPiece(WHITE, KING);
    }

    public static Piece createBlackKing() {
        return createPiece(BLACK, KING);
    }
    public static Piece createBlank() {
        return createPiece(NO_COLOR, NO_PIECE);
    }

    private static Piece createPiece(Color color, Type type) {
        return new Piece(color, type.allowedName, type);
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
        return !type.equals(NO_PIECE) && type.equals(PAWN);
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
