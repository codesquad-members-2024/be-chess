package chess.enums;

import chess.pieces.Piece;
import chess.pieces.implement.*;

import java.util.function.Supplier;

public enum Position {
    A8(() -> Rook.rook.create(Color.BLACK)), B8(() -> Knight.knight.create(Color.BLACK)),
    C8(() -> Bishop.bishop.create(Color.BLACK)), D8(() -> Queen.queen.create(Color.BLACK)),
    E8(() -> King.king.create(Color.BLACK)), F8(() -> Bishop.bishop.create(Color.BLACK)),
    G8(() -> Knight.knight.create(Color.BLACK)), H8(() -> Rook.rook.create(Color.BLACK)),
    A7(() -> Pawn.pawn.create(Color.BLACK)), B7(() -> Pawn.pawn.create(Color.BLACK)),
    C7(() -> Pawn.pawn.create(Color.BLACK)), D7(() -> Pawn.pawn.create(Color.BLACK)),
    E7(() -> Pawn.pawn.create(Color.BLACK)), F7(() -> Pawn.pawn.create(Color.BLACK)),
    G7(() -> Pawn.pawn.create(Color.BLACK)), H7(() -> Pawn.pawn.create(Color.BLACK)),
    A6(() -> Blank.blank.create(Color.NO_COLOR)), B6(() -> Blank.blank.create(Color.NO_COLOR)),
    C6(() -> Blank.blank.create(Color.NO_COLOR)), D6(() -> Blank.blank.create(Color.NO_COLOR)),
    E6(() -> Blank.blank.create(Color.NO_COLOR)), F6(() -> Blank.blank.create(Color.NO_COLOR)),
    G6(() -> Blank.blank.create(Color.NO_COLOR)), H6(() -> Blank.blank.create(Color.NO_COLOR)),
    A5(() -> Blank.blank.create(Color.NO_COLOR)), B5(() -> Blank.blank.create(Color.NO_COLOR)),
    C5(() -> Blank.blank.create(Color.NO_COLOR)), D5(() -> Blank.blank.create(Color.NO_COLOR)),
    E5(() -> Blank.blank.create(Color.NO_COLOR)), F5(() -> Blank.blank.create(Color.NO_COLOR)),
    G5(() -> Blank.blank.create(Color.NO_COLOR)), H5(() -> Blank.blank.create(Color.NO_COLOR)),
    A4(() -> Blank.blank.create(Color.NO_COLOR)), B4(() -> Blank.blank.create(Color.NO_COLOR)),
    C4(() -> Blank.blank.create(Color.NO_COLOR)), D4(() -> Blank.blank.create(Color.NO_COLOR)),
    E4(() -> Blank.blank.create(Color.NO_COLOR)), F4(() -> Blank.blank.create(Color.NO_COLOR)),
    G4(() -> Blank.blank.create(Color.NO_COLOR)), H4(() -> Blank.blank.create(Color.NO_COLOR)),
    A3(() -> Blank.blank.create(Color.NO_COLOR)), B3(() -> Blank.blank.create(Color.NO_COLOR)),
    C3(() -> Blank.blank.create(Color.NO_COLOR)), D3(() -> Blank.blank.create(Color.NO_COLOR)),
    E3(() -> Blank.blank.create(Color.NO_COLOR)), F3(() -> Blank.blank.create(Color.NO_COLOR)),
    G3(() -> Blank.blank.create(Color.NO_COLOR)), H3(() -> Blank.blank.create(Color.NO_COLOR)),
    A2(() -> Pawn.pawn.create(Color.WHITE)), B2(() -> Pawn.pawn.create(Color.WHITE)),
    C2(() -> Pawn.pawn.create(Color.WHITE)), D2(() -> Pawn.pawn.create(Color.WHITE)),
    E2(() -> Pawn.pawn.create(Color.WHITE)), F2(() -> Pawn.pawn.create(Color.WHITE)),
    G2(() -> Pawn.pawn.create(Color.WHITE)), H2(() -> Pawn.pawn.create(Color.WHITE)),
    A1(() -> Rook.rook.create(Color.WHITE)), B1(() -> Knight.knight.create(Color.WHITE)),
    C1(() -> Bishop.bishop.create(Color.WHITE)), D1(() -> Queen.queen.create(Color.WHITE)),
    E1(() -> King.king.create(Color.WHITE)), F1(() -> Bishop.bishop.create(Color.WHITE)),
    G1(() -> Knight.knight.create(Color.WHITE)), H1(() -> Rook.rook.create(Color.WHITE));

    private final Supplier<Piece> init;

    Position(Supplier<Piece> init) {
        this.init = init;
    }

    public Piece initPosition() {
        return init.get();
    }
}
