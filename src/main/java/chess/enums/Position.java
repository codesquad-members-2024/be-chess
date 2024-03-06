package chess.enums;

import chess.pieces.Piece;

import java.util.function.Supplier;

public enum Position {
    A8(Piece::createBlackRook), B8(Piece::createBlackKnight), C8(Piece::createBlackBishop), D8(Piece::createBlackQueen),
    E8(Piece::createBlackKing), F8(Piece::createBlackBishop), G8(Piece::createBlackKnight), H8(Piece::createBlackRook),
    A7(Piece::createBlackPawn), B7(Piece::createBlackPawn), C7(Piece::createBlackPawn), D7(Piece::createBlackPawn),
    E7(Piece::createBlackPawn), F7(Piece::createBlackPawn), G7(Piece::createBlackPawn), H7(Piece::createBlackPawn),
    A6(), B6(), C6(), D6(), E6(), F6(), G6(), H6(),
    A5(), B5(), C5(), D5(), E5(), F5(), G5(), H5(),
    A4(), B4(), C4(), D4(), E4(), F4(), G4(), H4(),
    A3(), B3(), C3(), D3(), E3(), F3(), G3(), H3(),
    A2(Piece::createWhitePawn), B2(Piece::createWhitePawn), C2(Piece::createWhitePawn), D2(Piece::createWhitePawn),
    E2(Piece::createWhitePawn), F2(Piece::createWhitePawn), G2(Piece::createWhitePawn), H2(Piece::createWhitePawn),
    A1(Piece::createWhiteRook), B1(Piece::createWhiteKnight), C1(Piece::createWhiteBishop), D1(Piece::createWhiteQueen),
    E1(Piece::createWhiteKing), F1(Piece::createWhiteBishop), G1(Piece::createWhiteKnight), H1(Piece::createWhiteRook);


    private final Supplier<Piece> init;

    private Position(Supplier<Piece> init) {
        this.init = init;
    }

    private Position() {
        this.init = () -> null;
    }

    public Piece initPosition() {
        return init.get();
    }
}
