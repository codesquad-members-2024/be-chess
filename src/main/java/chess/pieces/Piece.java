package chess.pieces;

import chess.enums.Color;
import chess.enums.TypeOfPiece;

public class Piece {

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, TypeOfPiece.QUEEN, (char)(TypeOfPiece.QUEEN.getRepresent() + 6));
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, TypeOfPiece.QUEEN, TypeOfPiece.QUEEN.getRepresent());
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, TypeOfPiece.KING, (char)(TypeOfPiece.KING.getRepresent() + 6));
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, TypeOfPiece.KING, TypeOfPiece.KING.getRepresent());
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, TypeOfPiece.ROOK, (char)(TypeOfPiece.ROOK.getRepresent() + 6));
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, TypeOfPiece.ROOK, TypeOfPiece.ROOK.getRepresent());
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, TypeOfPiece.PAWN, (char)(TypeOfPiece.PAWN.getRepresent() + 6));
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, TypeOfPiece.PAWN, TypeOfPiece.PAWN.getRepresent());
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, TypeOfPiece.BISHOP, (char)(TypeOfPiece.BISHOP.getRepresent() + 6));
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, TypeOfPiece.BISHOP, TypeOfPiece.BISHOP.getRepresent());
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, TypeOfPiece.KNIGHT, (char)(TypeOfPiece.KNIGHT.getRepresent() + 6));
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, TypeOfPiece.KNIGHT, TypeOfPiece.KNIGHT.getRepresent());
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
