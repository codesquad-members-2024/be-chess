package chess;

import java.util.List;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;

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

    public List<Piece> findSameColorAndSymbolPieces(Color color, PieceSymbol pieceSymbol) {
        return pieces.stream().filter(piece -> piece.equalsPiece(color, pieceSymbol)).toList();
    }

    public List<Piece> findSameColorPieces(Color color) {
        return pieces.stream().filter(piece -> piece.matchColor(color)).toList();
    }

    public boolean hasSameColorPawn(Piece piece) {
        int col = piece.getPosition().getCol();
        Piece comparePiece = pieces.get(col);

        if (piece.equals(comparePiece)) {
            return false;
        }
        if (!comparePiece.isPawn()) {
            return false;
        }
        if (!comparePiece.matchColor(piece.getColor())) {
            return false;
        }
        return true;
    }
}
