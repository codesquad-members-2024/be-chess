package chess.view;

import static chess.utils.StringUtils.appendNewLine;

import chess.board.Board;
import chess.pieces.Piece;

public class View {
    public static final String EMPTY_STRING = "";

    public String showBoard(Board board) {
        Piece[][] pieces = board.getPieces();
        StringBuilder sb = new StringBuilder();
        for (Piece[] pieceArray : pieces) {
            for (Piece piece : pieceArray) {
                sb.append(piece.getRepresentation());
            }
            sb.append(appendNewLine(EMPTY_STRING));
        }
        return sb.toString();
    }
}
