package chess;

import chess.enums.Position;
import chess.pieces.Piece;

import static chess.utils.StringUtils.appendNewLine;

import java.util.*;

public class Board {
    private final int ROW = 8;
    private final int COL = 8;

    private final Map<Position, Piece> chessBoard = new HashMap<>();


    public void initialize() {
        Arrays.stream(Position.values())
                .forEach((Position pos) -> {
                    chessBoard.put(pos, pos.initPosition());
                });
    }

    public int pieceCount() {
        return (int)chessBoard.values().stream()
                                    .filter(Objects::nonNull)
                                    .count();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = ROW; i > 0; i--) {
            sb.append(appendNewLine((getRowString(i))));
        }

        return sb.toString();
    }

    private String getRowString(int row) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Position.values())
                .filter(position -> position.name().contains(String.valueOf(row)))
                .forEach(position -> sb.append(chessBoard.get(position) == null ? '.' : chessBoard.get(position).getRepresent()));
        return sb.toString();
    }
}
