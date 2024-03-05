package chess.board;

import static chess.utils.StringUtils.appendNewLine;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public static final int COLUMN_AND_ROW_SIZE = 8;
    private static final int BLACK_INITIAL_OTHERS_ROW = 0;
    private static final int BLACK_INITIAL_PAWNS_ROW = 1;
    private static final int WHITE_INITIAL_PAWNS_ROW = 6;
    private static final int WHITE_INITIAL_OTHERS_ROW = 7;

    public static final String EMPTY_STRING = "";
    private final Piece[][] pieces = new Piece[COLUMN_AND_ROW_SIZE][COLUMN_AND_ROW_SIZE];

    public void initialize() {
        List<Type> otherTypes = makeOtherNames();
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            fillRank(i, otherTypes);
        }
    }

    private void fillRank(int i, List<Type> otherTypes) {
        for (int j = 0; j < COLUMN_AND_ROW_SIZE; j++) {
            if (i == BLACK_INITIAL_OTHERS_ROW) {
                pieces[i][j] = Piece.createBlack(otherTypes.get(j));
                continue;
            }
            if (i == BLACK_INITIAL_PAWNS_ROW) {
                pieces[i][j] = Piece.createBlack(Type.PAWN);
                continue;
            }
            if (i == WHITE_INITIAL_PAWNS_ROW) {
                pieces[i][j] = Piece.createWhite(Type.PAWN);
                continue;
            }
            if (i == WHITE_INITIAL_OTHERS_ROW) {
                pieces[i][j] = Piece.createWhite(otherTypes.get(j));
                continue;
            }
            pieces[i][j] = Piece.createBlank();
        }
    }

    private List<Type> makeOtherNames() {
        List<Type> otherTypes = new ArrayList<>();
        otherTypes.add(Type.ROOK);
        otherTypes.add(Type.KNIGHT);
        otherTypes.add(Type.BISHOP);
        otherTypes.add(Type.QUEEN);
        otherTypes.add(Type.KING);
        otherTypes.add(Type.BISHOP);
        otherTypes.add(Type.KNIGHT);
        otherTypes.add(Type.ROOK);
        return otherTypes;
    }

    public int pieceCount() {
        return (int) Arrays.stream(pieces)
                .flatMap(Arrays::stream)
                .filter(piece -> !piece.isBlank())
                .count();
    }

    public int pieceCount(Type type, Color color) {
        return (int) Arrays.stream(pieces)
                .flatMap(Arrays::stream)
                .filter(piece -> piece.getType() == type && piece.getColor() == color)
                .count();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Piece[] pieceArray : pieces) {
            for (Piece piece : pieceArray) {
                sb.append(piece.getRepresentation());
            }
            sb.append(appendNewLine(EMPTY_STRING));
        }
        return sb.toString();
    }

    public Piece findPiece(Position position) {
        return pieces[position.getYPos()][position.getXPos()];
    }
}
