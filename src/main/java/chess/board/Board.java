package chess.board;

import static chess.utils.StringUtils.appendNewLine;

import chess.pieces.Color;
import chess.pieces.Name;
import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    public static final int COLUMN_AND_ROW_SIZE = 8;
    public static final int WHITE_PAWN_ROW = 6;
    public static final int BLACK_PAWN_ROW = 1;
    public static final String EMPTY_SPACE = ".";
    private final List<Piece> allPieces = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();


    public void initialize() {
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            add(Piece.createPiece(Name.PAWN, Color.WHITE));
            add(Piece.createPiece(Name.PAWN, Color.BLACK));
        }
    }

    public void add(Piece piece) {
        allPieces.add(piece);
        if (piece.getColor().equals(Color.WHITE)) {
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

    public String getPawnsResult(Color color) {
        return (color.equals(Color.WHITE) ? whitePieces : blackPieces).stream()
                .map(piece -> piece.getRepresentation().getValue())
                .collect(Collectors.joining());
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_AND_ROW_SIZE; j++) {
                if (i == WHITE_PAWN_ROW) {
                    sb.append(getPawnsResult(Color.WHITE));
                    break;
                }
                if (i == BLACK_PAWN_ROW) {
                    sb.append(getPawnsResult(Color.BLACK));
                    break;
                }
                sb.append(EMPTY_SPACE);
            }
            appendNewLine(sb);
        }
        return sb.toString();
    }
}
