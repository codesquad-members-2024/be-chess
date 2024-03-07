package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

public class Knight extends Piece {

    public static final Knight knight = new Knight();

    private Knight() {
        super(null, TypeOfPiece.KNIGHT, TypeOfPiece.KNIGHT.getRepresent());
    }

    private Knight(Color color) {
        super(color, TypeOfPiece.KNIGHT, color.equals(Color.WHITE) ? (char) TypeOfPiece.KNIGHT.getRepresent() : (char) (TypeOfPiece.KNIGHT.getRepresent() - 6));
    }

    @Override
    public Piece create(Color color) {
        return new Knight(color);
    }
}
