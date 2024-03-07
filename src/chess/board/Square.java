package src.chess.board;

import java.util.function.Supplier;
import src.chess.pieces.Piece;

public enum Square {
    A8(Piece::createBlackRook), B8(Piece::createBlackKnight), C8(Piece::createBlackBishop), D8(Piece::createBlackQueen),
    E8(Piece::createBlackKing), F8(Piece::createBlackBishop), G8(Piece::createBlackKnight), H8(Piece::createBlackRook),

    A7(Piece::createBlackPawn), B7(Piece::createBlackPawn), C7(Piece::createBlackPawn), D7(Piece::createBlackPawn),
    E7(Piece::createBlackPawn), F7(Piece::createBlackPawn), G7(Piece::createBlackPawn), H7(Piece::createBlackPawn),

    A6(Piece::createBlank), B6(Piece::createBlank), C6(Piece::createBlank), D6(Piece::createBlank),
    E6(Piece::createBlank), F6(Piece::createBlank), G6(Piece::createBlank), H6(Piece::createBlank),

    A5(Piece::createBlank), B5(Piece::createBlank), C5(Piece::createBlank), D5(Piece::createBlank),
    E5(Piece::createBlank), F5(Piece::createBlank), G5(Piece::createBlank), H5(Piece::createBlank),

    A4(Piece::createBlank), B4(Piece::createBlank), C4(Piece::createBlank), D4(Piece::createBlank),
    E4(Piece::createBlank), F4(Piece::createBlank), G4(Piece::createBlank), H4(Piece::createBlank),

    A3(Piece::createBlank), B3(Piece::createBlank), C3(Piece::createBlank), D3(Piece::createBlank),
    E3(Piece::createBlank), F3(Piece::createBlank), G3(Piece::createBlank), H3(Piece::createBlank),

    A2(Piece::createWhitePawn), B2(Piece::createWhitePawn), C2(Piece::createWhitePawn), D2(Piece::createWhitePawn),
    E2(Piece::createWhitePawn), F2(Piece::createWhitePawn), G2(Piece::createWhitePawn), H2(Piece::createWhitePawn),

    A1(Piece::createWhiteRook), B1(Piece::createWhiteKnight), C1(Piece::createWhiteBishop), D1(Piece::createWhiteQueen),
    E1(Piece::createWhiteKing), F1(Piece::createWhiteBishop), G1(Piece::createWhiteKnight), H1(Piece::createWhiteRook);

    private Supplier<Piece> init;

    Square(Supplier<Piece> init) {
        this.init = init;
    }

    public Piece initBoard() {
        return init.get();
    }

    public int getOrdinal() {
        return this.ordinal();
    }
}