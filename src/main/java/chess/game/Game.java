package chess.game;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;

public class Game {
    public static final int BOARD_MIN__IDX = 0;
    public static final int BOARD_MAX__IDX = 7;
    public static final double DECREASED_PAWN_POINT = 0.5;
    public static final String INVALID_POSITION = "해당 위치로 이동할 수 없습니다.";
    private final Board board;
    private int turn = 1;

    public Game(Board board) {
        this.board = board;
    }

    public void move(Position source, Position target) {
        if (!isPositionOnBoard(source) || !isPositionOnBoard(target)) {
            throw new IllegalArgumentException(INVALID_POSITION);
        }

        // 성공로직
        Piece piece = board.findPiece(source);
        piece.changePosition(target);
        board.addPiece(target, piece);
        board.addPiece(source, Piece.createBlank(source));
    }

    private boolean isPositionOnBoard(Position position) {
        int yPos = position.getYPos();
        int xPos = position.getXPos();

        return yPos >= BOARD_MIN__IDX && yPos <= BOARD_MAX__IDX && xPos >= BOARD_MIN__IDX && xPos <= BOARD_MAX__IDX;
    }

    public double calculatePoint(Color color) {
        double sum = board.sumDefaultPoints(color);
        int count = board.countDuplicatedPawn(color);
        return sum - (count * DECREASED_PAWN_POINT);
    }

    private boolean isWhiteTurn() {
        return turn % 2 == 1;
    }

    private boolean isBlackTurn() {
        return turn % 2 == 0;
    }
}
