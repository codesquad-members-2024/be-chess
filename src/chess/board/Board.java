package src.chess.board;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import src.chess.pieces.Colors;
import src.chess.pieces.Piece;
import java.util.ArrayList;
import src.chess.pieces.PieceType;
import src.utils.StringUtils;

public class Board {
    private List<Piece> pieces = new ArrayList<>();
    private Map<Square, Piece> chessBoard = new EnumMap<>(Square.class);

    public void add(Piece piece) {
        this.pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public Piece findPawn(int index) {
        return pieces.get(index);
    }

    public void initialize() {
       Arrays.stream(Square.values())
                .forEach(square -> chessBoard.put(square, square.initBoard()));
    }

    public int pieceCount() {
        return (int) (chessBoard.values().stream()
                .filter(square -> square != null)
                .count());
    }

    public String getBlackPawnsResult() {
        return chessBoard.keySet().stream()
                .filter(key -> Square.A7.ordinal() <= key.ordinal() && Square.H7.ordinal() >= key.ordinal())
                .map(key -> chessBoard.get(key).toString())
                .collect(Collectors.joining());
    }

    public String getWhitePawnsResult() {
        return chessBoard.keySet().stream()
                .filter(key -> Square.A2.ordinal() <= key.ordinal() && Square.H2.ordinal() >= key.ordinal())
                .map(key -> chessBoard.get(key).toString())
                .collect(Collectors.joining());
    }

    public String getPieceByRow(int ordinal) {
        StringBuilder result = new StringBuilder();
        int maxRange = ordinal + 7;
        chessBoard.entrySet().stream()
                .filter(entry -> entry.getKey().getOrdinal() >= ordinal && entry.getKey().getOrdinal() <= maxRange)
                .forEach(entry -> result.append(entry.getValue() != null ? entry.getValue() : "."));
        return result.toString();
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < chessBoard.size(); i += 8) {
            result.append(StringUtils.appendNewLine(getPieceByRow(i)));
        }
        return result.toString();
    }
}