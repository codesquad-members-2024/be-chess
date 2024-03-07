package chess.pieces;

import chess.enums.Color;
import chess.enums.TypeOfPiece;

public class Piece {

    public static final char WHITE_PAWN_REPRESENT = '♟';
    public static final char BLACK_PAWN_REPRESENT = '♙';
    public static final char WHITE_QUEEN_REPRESENT = '♛';
    public static final char BLACK_QUEEN_REPRESENT = '♕';
    public static final char WHITE_KING_REPRESENT = '♚';
    public static final char BLACK_KING_REPRESENT = '♔';
    public static final char WHITE_ROOK_REPRESENT = '♜';
    public static final char BLACK_ROOK_REPRESENT = '♖';
    public static final char WHITE_BISHOP_REPRESENT = '♝';
    public static final char BLACK_BISHOP_REPRESENT = '♗';
    public static final char WHITE_KNIGHT_REPRESENT = '♞';
    public static final char BLACK_KNIGHT_REPRESENT = '♘';

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, TypeOfPiece.QUEEN, BLACK_QUEEN_REPRESENT);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, TypeOfPiece.QUEEN, WHITE_QUEEN_REPRESENT);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, TypeOfPiece.KING, BLACK_KING_REPRESENT);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, TypeOfPiece.KING, WHITE_KING_REPRESENT);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, TypeOfPiece.ROOK, BLACK_ROOK_REPRESENT);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, TypeOfPiece.ROOK, WHITE_ROOK_REPRESENT);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, TypeOfPiece.PAWN, BLACK_PAWN_REPRESENT);
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, TypeOfPiece.PAWN, WHITE_PAWN_REPRESENT);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, TypeOfPiece.BISHOP, BLACK_BISHOP_REPRESENT);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, TypeOfPiece.BISHOP, WHITE_BISHOP_REPRESENT);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, TypeOfPiece.KNIGHT, BLACK_KNIGHT_REPRESENT);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, TypeOfPiece.KNIGHT, WHITE_KNIGHT_REPRESENT);
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
