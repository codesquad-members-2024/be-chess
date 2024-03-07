package chess.board;

import chess.enums.Position;
import chess.pieces.Piece;

import java.util.Arrays;
import java.util.Map;

import static chess.board.Board.RANK_CNT;
import static chess.utils.StringUtils.appendNewLine;

public class BoardView {

    private final Map<Position, Piece> chessBoard;

    public BoardView(Map<Position, Piece> chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void printBoard() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = RANK_CNT; i > 0; i--) {
            sb.append(appendNewLine((getRowString(i))));
        }
        return sb.toString();
    }

    private String getRowString(int row) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Position.values())
                .filter(position -> position.name().contains(String.valueOf(row)))
                .forEach(position -> sb.append(chessBoard.get(position).getRepresent()));
        return sb.toString();
    }

}
