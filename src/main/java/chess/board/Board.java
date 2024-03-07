package chess.board;

import chess.enums.Color;
import chess.enums.Position;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;
import chess.pieces.implement.Blank;

import java.util.*;

public class Board {
    public static final int RANK_CNT = 8;
    private final Map<Position, Piece> chessBoard = new HashMap<>();

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


}
