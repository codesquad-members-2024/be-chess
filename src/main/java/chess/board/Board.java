package chess.board;

import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final List<Piece> allPieces = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();


    public void initialize() {
        for (int i = 0; i < 8; i++) {
            add(new Piece());
            add(new Piece(Piece.BLACK_COLOR));
        }
    }

    public void add(Piece piece) {
        allPieces.add(piece);
        if (piece.getColor().equals(Piece.WHITE_COLOR)) {
            whitePieces.add(piece);
            return;
        }
        blackPieces.add(piece);
    }

    public int size() {
        return allPieces.size();
    }

    public Piece findPawn(int idx) {
        return allPieces.get(idx);
    }

    public String getPawnsResult(String color) {
        return (color.equals(Piece.WHITE_COLOR) ? whitePieces : blackPieces).stream()
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    sb.append(getPawnsResult(Piece.BLACK_COLOR));
                    break;
                }
                if (i == 6) {
                    sb.append(getPawnsResult(Piece.WHITE_COLOR));
                    break;
                }
                sb.append(".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
