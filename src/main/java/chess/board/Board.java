package chess.board;

import static chess.utils.StringUtils.appendNewLine;

import chess.pieces.Color;
import chess.pieces.Name;
import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Board {
    public static final int COLUMN_AND_ROW_SIZE = 8;
    private static final int BLACK_INITIAL_OTHERS_ROW = 0;
    private static final int BLACK_INITIAL_PAWNS_ROW = 1;
    private static final int WHITE_INITIAL_OTHERS_ROW = 7;
    private static final int WHITE_INITIAL_PAWNS_ROW = 6;

    public static final String EMPTY_SPACE = ".";
    public static final String EMPTY_STRING = "";
    private final Piece[][] pieces = new Piece[COLUMN_AND_ROW_SIZE][COLUMN_AND_ROW_SIZE];

    public void initialize() {
        List<Name> otherNames = makeOtherNames();

        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            pieces[BLACK_INITIAL_OTHERS_ROW][i] = Piece.createPiece(otherNames.get(i), Color.BLACK);
        }
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            pieces[BLACK_INITIAL_PAWNS_ROW][i] = Piece.createPiece(Name.PAWN, Color.BLACK);
        }
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            pieces[WHITE_INITIAL_OTHERS_ROW][i] = Piece.createPiece(otherNames.get(i), Color.WHITE);
        }
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            pieces[WHITE_INITIAL_PAWNS_ROW][i] = Piece.createPiece(Name.PAWN, Color.WHITE);
        }
    }

    private List<Name> makeOtherNames() {
        List<Name> otherNames = new ArrayList<>();
        otherNames.add(Name.ROOK);
        otherNames.add(Name.KNIGHT);
        otherNames.add(Name.BISHOP);
        otherNames.add(Name.QUEEN);
        otherNames.add(Name.KING);
        otherNames.add(Name.BISHOP);
        otherNames.add(Name.KNIGHT);
        otherNames.add(Name.ROOK);
        return otherNames;
    }

    public int pieceCount() {
        return (int) Arrays.stream(pieces)
                .flatMap(Arrays::stream)
                .filter(Objects::nonNull)
                .count();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Piece[] pieceArray : pieces) {
            appendRow(pieceArray, sb);
        }
        return sb.toString();
    }

    private void appendRow(Piece[] pieceArray, StringBuilder sb) {
        for (Piece piece : pieceArray) {
            if (piece == null) {
                sb.append(EMPTY_SPACE);
                continue;
            }
            sb.append(piece.getRepresentation().getValue());
        }
        sb.append(appendNewLine(EMPTY_STRING));
    }
}
