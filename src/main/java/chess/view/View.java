package chess.view;

import static chess.utils.StringUtils.appendNewLine;

import chess.board.Board;
import chess.board.Rank;
import chess.pieces.Piece;
import java.util.List;

public class View {
    public static final String EMPTY_STRING = "";

    public String showBoard(Board board) {
        List<Rank> ranks = board.getRanks();
        StringBuilder sb = new StringBuilder();
        for (Rank rank : ranks) {
            appendRankValues(rank, sb);
            sb.append(appendNewLine(EMPTY_STRING));
        }
        return sb.toString();
    }

    private void appendRankValues(Rank rank, StringBuilder sb) {
        for (Piece piece : rank.getPieces()) {
            sb.append(piece.getRepresentation());
        }
    }
}
