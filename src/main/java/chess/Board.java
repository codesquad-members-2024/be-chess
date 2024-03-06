package chess;

import chess.enums.Color;
import chess.pieces.Piece;
import static chess.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Piece> pieces = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();
    private final int PAWN_CNT = 8;
    private final int BLACK_PAWN = 1;
    private final int WHITE_PAWN = 6;

    public void add(Piece piece, Color color) {
        if (color.equals(Color.WHITE)) whitePieces.add(piece);
        else blackPieces.add(piece);
    }

    public Piece findPawn(int idx, Color color) {
        if (color.equals(Color.WHITE)) return whitePieces.get(idx - 1);
        return blackPieces.get(idx - 1);
    }

    public int size(Color color) {
        if (color.equals(Color.WHITE)) return whitePieces.size();
        return blackPieces.size();
    }

    public void initialize() {
        for (Color color : Color.values()) {
            for (int i = 0; i < PAWN_CNT; i++) add(new Piece(color), color);
        }

    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        String dots = "........";
        for (int i = 0; i < PAWN_CNT; i++) {
            if (i == BLACK_PAWN) sb.append(getBlackPawnsResult());
            else if (i == WHITE_PAWN) sb.append(getWhitePawnsResult());
            else sb.append(dots);
            sb.append(appendNewLine(sb.toString()));
        }

        System.out.println(sb);
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < PAWN_CNT; i++) sb.append(blackPieces.get(i).getRepresent());
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < PAWN_CNT; i++) sb.append(whitePieces.get(i).getRepresent());
        return sb.toString();
    }

}
