package chess.enums;

import chess.pieces.Piece;

import java.util.function.Supplier;

public enum Position {
    A8(() -> Piece.createBlack(TypeOfPiece.ROOK)), B8(() -> Piece.createBlack(TypeOfPiece.KNIGHT)),
    C8(() -> Piece.createBlack(TypeOfPiece.BISHOP)), D8(() -> Piece.createBlack(TypeOfPiece.QUEEN)),
    E8(() -> Piece.createBlack(TypeOfPiece.KING)), F8(() -> Piece.createBlack(TypeOfPiece.BISHOP)),
    G8(() -> Piece.createBlack(TypeOfPiece.KNIGHT)), H8(() -> Piece.createBlack(TypeOfPiece.ROOK)),
    A7(() -> Piece.createBlack(TypeOfPiece.PAWN)), B7(() -> Piece.createBlack(TypeOfPiece.PAWN)),
    C7(() -> Piece.createBlack(TypeOfPiece.PAWN)), D7(() -> Piece.createBlack(TypeOfPiece.PAWN)),
    E7(() -> Piece.createBlack(TypeOfPiece.PAWN)), F7(() -> Piece.createBlack(TypeOfPiece.PAWN)),
    G7(() -> Piece.createBlack(TypeOfPiece.PAWN)), H7(() -> Piece.createBlack(TypeOfPiece.PAWN)),
    A6(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), B6(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), C6(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    D6(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), E6(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), F6(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    G6(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), H6(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    A5(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), B5(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), C5(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    D5(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), E5(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), F5(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    G5(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), H5(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    A4(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), B4(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), C4(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    D4(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), E4(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), F4(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    G4(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), H4(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    A3(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), B3(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), C3(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    D3(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), E3(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), F3(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    G3(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)), H3(() -> Piece.createBlank(TypeOfPiece.NO_PIECE)),
    A2(() -> Piece.createWhite(TypeOfPiece.PAWN)), B2(() -> Piece.createWhite(TypeOfPiece.PAWN)),
    C2(() -> Piece.createWhite(TypeOfPiece.PAWN)), D2(() -> Piece.createWhite(TypeOfPiece.PAWN)),
    E2(() -> Piece.createWhite(TypeOfPiece.PAWN)), F2(() -> Piece.createWhite(TypeOfPiece.PAWN)),
    G2(() -> Piece.createWhite(TypeOfPiece.PAWN)), H2(() -> Piece.createWhite(TypeOfPiece.PAWN)),
    A1(() -> Piece.createWhite(TypeOfPiece.ROOK)), B1(() -> Piece.createWhite(TypeOfPiece.KNIGHT)),
    C1(() -> Piece.createWhite(TypeOfPiece.BISHOP)), D1(() -> Piece.createWhite(TypeOfPiece.QUEEN)),
    E1(() -> Piece.createWhite(TypeOfPiece.KING)), F1(() -> Piece.createWhite(TypeOfPiece.BISHOP)),
    G1(() -> Piece.createWhite(TypeOfPiece.KNIGHT)), H1(() -> Piece.createWhite(TypeOfPiece.ROOK));


    private final Supplier<Piece> init;

    Position(Supplier<Piece> init) {
        this.init = init;
    }

    public Piece initPosition() {
        return init.get();
    }
}
