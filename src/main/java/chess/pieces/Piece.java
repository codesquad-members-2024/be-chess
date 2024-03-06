package chess.pieces;

import chess.enums.Color;
import chess.enums.TypeOfPiece;

public class Piece {

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, TypeOfPiece.BLACK_QUEEN, TypeOfPiece.BLACK_QUEEN.getRepresent());
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, TypeOfPiece.WHITE_QUEEN, TypeOfPiece.WHITE_QUEEN.getRepresent());
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, TypeOfPiece.BLACK_KING, TypeOfPiece.BLACK_KING.getRepresent());
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, TypeOfPiece.WHITE_KING, TypeOfPiece.WHITE_KING.getRepresent());
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, TypeOfPiece.BLACK_ROOK, TypeOfPiece.BLACK_ROOK.getRepresent());
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, TypeOfPiece.WHITE_ROOK, TypeOfPiece.WHITE_ROOK.getRepresent());
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, TypeOfPiece.BLACK_PAWN, TypeOfPiece.BLACK_PAWN.getRepresent());
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, TypeOfPiece.WHITE_PAWN, TypeOfPiece.WHITE_PAWN.getRepresent());
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, TypeOfPiece.BLACK_BISHOP, TypeOfPiece.BLACK_BISHOP.getRepresent());
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, TypeOfPiece.WHITE_BISHOP, TypeOfPiece.WHITE_BISHOP.getRepresent());
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, TypeOfPiece.BLACK_KNIGHT, TypeOfPiece.BLACK_KNIGHT.getRepresent());
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, TypeOfPiece.WHITE_KNIGHT, TypeOfPiece.WHITE_KNIGHT.getRepresent());
    }

    public static Piece createBlank() {
        return new Piece(Color.NO_COLOR, TypeOfPiece.NO_PIECE, TypeOfPiece.NO_PIECE.getRepresent());
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

    public boolean isWhite() {
        return this.color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return this.color.equals(Color.BLACK);
    }

}
