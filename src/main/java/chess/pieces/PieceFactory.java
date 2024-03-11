package chess.pieces;

import static chess.common.Color.BLACK;
import static chess.common.Color.WHITE;

public class PieceFactory {
    public static Pawn createWhitePawn() {
        return new Pawn(WHITE);
    }

    public static Pawn createBlackPawn() {
        return new Pawn(BLACK);
    }

    public static Knight createWhiteKnight() {
        return new Knight(WHITE);
    }

    public static Knight createBlackKnight() {
        return new Knight(BLACK);
    }

    public static Bishop createWhiteBishop() {
        return new Bishop(WHITE);
    }

    public static Bishop createBlackBishop() {
        return new Bishop(BLACK);
    }

    public static Rook createWhiteRook() {
        return new Rook(WHITE);
    }

    public static Rook createBlackRook() {
        return new Rook(BLACK);
    }

    public static Queen createWhiteQueen() {
        return new Queen(WHITE);
    }

    public static Queen createBlackQueen() {
        return new Queen(BLACK);
    }

    public static King createWhiteKing() {
        return new King(WHITE);
    }

    public static King createBlackKing() {
        return new King(BLACK);
    }

    public static Blank createBlank() {
        return new Blank();
    }
}
