package src.chess.board;

import java.util.function.Supplier;
import src.chess.pieces.Piece;

public enum Square {
    A8(Piece::createBlackRook),B8(Piece::createBlackKnight),C8(Piece::createBlackBishop),D8(Piece::createBlackQueen),
    E8(Piece::createBlackKing),F8(Piece::createBlackBishop),G8(Piece::createBlackKnight),H8(Piece::createBlackRook),

    A7(Piece::createBlackPawn),B7(Piece::createBlackPawn),C7(Piece::createBlackPawn),D7(Piece::createBlackPawn),
    E7(Piece::createBlackPawn),F7(Piece::createBlackPawn),G7(Piece::createBlackPawn),H7(Piece::createBlackPawn),

    A6(null),B6(null),C6(null),D6(null),E6(null),F6(null),G6(null),H6(null),
    A5(null),B5(null),C5(null),D5(null),E5(null),F5(null),G5(null),H5(null),
    A4(null),B4(null),C4(null),D4(null),E4(null),F4(null),G4(null),H4(null),
    A3(null),B3(null),C3(null),D3(null),E3(null),F3(null),G3(null),H3(null),

    A2(Piece::createWhitePawn),B2(Piece::createWhitePawn),C2(Piece::createWhitePawn),D2(Piece::createWhitePawn),
    E2(Piece::createWhitePawn),F2(Piece::createWhitePawn),G2(Piece::createWhitePawn),H2(Piece::createWhitePawn),

    A1(Piece::createWhiteRook),B1(Piece::createWhiteKnight),C1(Piece::createWhiteBishop),D1(Piece::createWhiteQueen),
    E1(Piece::createWhiteKing),F1(Piece::createWhiteBishop),G1(Piece::createWhiteKnight),H1(Piece::createWhiteRook);

    private Supplier<Piece> init;

    Square(Supplier<Piece> init) {
        this.init = init;
    }

    public Piece initBoard() {
        return init == null ? null : init.get();
    }

    public int getOrdinal() {
        return this.ordinal();
    }
}