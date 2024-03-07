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
    public static final String INVALID_SELECT = "아군의 피스만 움직일 수 있습니다.";
    private final Board board;
    private int turn = 1;

    public Game(Board board) {
        this.board = board;
    }

    public void move(Position source, Position target) {
        Piece piece = board.findPiece(source);
        if (isNotPositionOnBoard(source) || isNotPositionOnBoard(target) || isSamePosition(source, target)
                || isAllyPresent(piece, target)) {
            throw new IllegalArgumentException(INVALID_POSITION);
        }
        if (isInvalidSelect(piece)) {
            throw new IllegalArgumentException(INVALID_SELECT);
        }
        // 성공로직

        piece.changePosition(target);
        board.addPiece(target, piece);
        board.addPiece(source, Piece.createBlank(source));
        turn++;
    }

    private boolean isInvalidSelect(Piece piece) {
        if (isWhiteTurn()) {
            return !piece.isWhite();
        }
        return !piece.isBlack();
    }

    private boolean isSamePosition(Position source, Position target) {
        return source.equals(target);
    }

    private boolean isAllyPresent(Piece sourcePiece, Position target) {
        Piece tagetPiece = board.findPiece(target);
        return tagetPiece.isAlly(sourcePiece);
    }

    private boolean isNotPositionOnBoard(Position position) {
        int yPos = position.getYPos();
        int xPos = position.getXPos();

        return yPos < BOARD_MIN__IDX || yPos > BOARD_MAX__IDX || xPos < BOARD_MIN__IDX || xPos > BOARD_MAX__IDX;
    }

    public double calculatePoint(Color color) {
        double sum = board.sumDefaultPoints(color);
        int count = board.countDuplicatedPawn(color);
        return sum - (count * DECREASED_PAWN_POINT);
    }

    private boolean isWhiteTurn() {
        return turn % 2 == 1;
    }
}
