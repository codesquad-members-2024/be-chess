package chess;

import java.util.List;
import pieces.Piece;

public class Rank {
    private List<Piece> pieces;

    public Rank(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Piece getPiece(int index) {
        return pieces.get(index);
    }
}
