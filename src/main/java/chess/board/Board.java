package chess.board;

import chess.enums.Color;
import chess.enums.Direction;
import chess.enums.Position;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;
import chess.pieces.implement.Blank;

import java.util.*;

public class Board {
    public static final int RANK_CNT = 8;
    private final Map<Position, Piece> chessBoard = new EnumMap<>(Position.class);

    private static final Board instance = new Board();

    public static Board getInstance() {
        return instance;
    }

    private Board() {
        initialize();
    }

    public void initialize() {
        Arrays.stream(Position.values())
                .forEach((Position pos) -> {
                    chessBoard.put(pos, pos.initPosition());
                });
    }

    public void replace(Position key, Piece newValue) {
        chessBoard.replace(key, newValue);
    }

    public Piece get(Position key) {
        return chessBoard.get(key);
    }

    public Map<Position, Piece> getChessBoard() {
        return Collections.unmodifiableMap(chessBoard);
    }

    public int pieceCount() {
        return (int)chessBoard.values().stream()
                                    .filter(piece -> !piece.isBlank())
                                    .count();
    }

    public int numberOfSpecificPiece(TypeOfPiece type, Color color) {
        return (int)chessBoard.values().stream()
                                .filter(piece -> piece.getColor().equals(color) && piece.getType().equals(type))
                                .count();
    }

    public Piece findPiece(String index) {
        return chessBoard.get(Position.valueOf(index.toUpperCase()));
    }

    //Test만을 위한 메서드...??
    public void initializeEmpty() {
        chessBoard.keySet()
                .forEach(position -> chessBoard.replace(position, Blank.blank.create(Color.NO_COLOR)));
    }

    public boolean verifyMove(String source, String target, Color nowTurn) {
        try {
            Piece now = chessBoard.get(Position.valueOf(source.toUpperCase()));
            if (!now.getColor().equals(nowTurn)) return false;
            if (now.getColor().equals(chessBoard.get(Position.valueOf(target.toUpperCase())).getColor())) return false;

            List<Direction> dir = now.getDirections();
            for (Direction direction : dir) {
                int[] nowIdx = new int[2];
                nowIdx[0] = source.charAt(0);
                nowIdx[1] = Character.digit(source.charAt(1), 10);

                if (findRecursion(nowIdx, target, direction)) {
                    return true;
                }
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }

    private boolean findRecursion(int[] now, String target, Direction dir) {
        int[] newNow = new int[2];
        newNow[0] += now[0] + dir.getXDegree();
        newNow[1] += now[1] + dir.getYDegree();

        String nowStr = (String.valueOf((char) newNow[0]) + newNow[1]);
        try {
            Position nowPos = Position.valueOf(nowStr.toUpperCase());
            if (!chessBoard.get(nowPos).isBlank()) return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
        if (nowStr.equals(target)) {
            return true;
        }

        return findRecursion(newNow, target, dir);
    }

}
