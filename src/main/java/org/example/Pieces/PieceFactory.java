package org.example.Pieces;

public class PieceFactory {
    public static Piece createWhitePawn() {
        return Pawn.createPawn(Color.WHITE);
    }

    public static Piece createBlackPawn() {
        return Pawn.createPawn(Color.BLACK);
    }

    public static Piece createWhiteKnight() {
        return Knight.createKnight(Color.WHITE);
    }

    public static Piece createBlackKnight() {
        return Knight.createKnight(Color.BLACK);
    }
    public static Piece createWhiteBishop() {
        return Bishop.createBishop(Color.WHITE);
    }

    public static Piece createBlackBishop() {
        return Bishop.createBishop(Color.BLACK);
    }
    public static Piece createWhiteRook() {
        return Rook.createRook(Color.WHITE);
    }

    public static Piece createBlackRook() {
        return Rook.createRook(Color.BLACK);
    }

    public static Piece createWhiteQueen() {
        return Queen.createQueen(Color.WHITE);
    }

    public static Piece createBlackQueen() {
        return Queen.createQueen(Color.BLACK);
    }

    public static Piece createWhiteKing() {
        return King.createKing(Color.WHITE);
    }

    public static Piece createBlackKing() {
        return King.createKing(Color.BLACK);
    }

}
