package chess.game;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import java.util.List;

public class Game {
    public static final int BOARD_MIN__IDX = 0;
    public static final int BOARD_MAX__IDX = 7;
    public static final double DECREASED_PAWN_POINT = 0.5;
    public static final String INVALID_POSITION = "해당 위치로 이동할 수 없습니다.";
    public static final String INVALID_DIRECTION = "해당 방향으로 이동할 수 없습니다.";
    public static final String INVALID_SELECT = "아군의 피스만 움직일 수 있습니다.";
    private final Board board;
    private int turn = 1;

    public Game(Board board) {
        this.board = board;
    }

    public void move(Position source, Position target) {
        validatePosition(source, target);

        Piece sourcePiece = board.findPiece(source);
        Piece targetPiece = board.findPiece(target);

        validateSelect(sourcePiece);
        validateDirection(source, target, sourcePiece, targetPiece);

        // 성공로직
        if (sourcePiece instanceof Pawn pawn) {
            pawn.setInit(false);
        }
        board.addPiece(target, sourcePiece);
        board.addPiece(source, Piece.createBlank(source));
        turn++;
    }

    private void validatePosition(Position source, Position target) {
        if (isNotPositionOnBoard(source) || isNotPositionOnBoard(target)) {
            throw new IllegalArgumentException(INVALID_POSITION);
        }
        if (isSamePosition(source, target) || isAllyPresent(board.findPiece(source), board.findPiece(target))) {
            throw new IllegalArgumentException(INVALID_POSITION);
        }
    }

    private boolean isNotPositionOnBoard(Position position) {
        int yPos = position.getYPos();
        int xPos = position.getXPos();

        return yPos < BOARD_MIN__IDX || yPos > BOARD_MAX__IDX || xPos < BOARD_MIN__IDX || xPos > BOARD_MAX__IDX;
    }

    private boolean isSamePosition(Position source, Position target) {
        return source.equals(target);
    }

    private boolean isAllyPresent(Piece sourcePiece, Piece targetPiece) {
        return sourcePiece.isAlly(targetPiece);
    }

    private void validateSelect(Piece sourcePiece) {
        if (isInvalidSelect(sourcePiece)) {
            throw new IllegalArgumentException(INVALID_SELECT);
        }
    }

    private boolean isInvalidSelect(Piece piece) {
        if (isWhiteTurn()) {
            return !piece.isWhite();
        }
        return !piece.isBlack();
    }

    private boolean targetIsEnemy(Piece sourcePiece, Piece targetPiece) {
        return sourcePiece.isEnemy(targetPiece);
    }

    private void validateDirection(Position source, Position target, Piece sourcePiece, Piece targetPiece) {
        boolean isValidDirection = isValidDirection(source, target, sourcePiece, targetPiece);
        if (!isValidDirection) {
            throw new IllegalArgumentException(INVALID_DIRECTION);
        }
    }

    private boolean isValidDirection(Position source, Position target, Piece sourcePiece, Piece targetPiece) {
        if (sourcePiece instanceof Pawn pawn && targetIsEnemy(sourcePiece, targetPiece)) { // 폰이고 공격상황일 경우
            return pawn.verifyAttackPosition(source, target);
        }
        List<Position> occupied = board.getOccupiedPosition();
        return sourcePiece.verifyMovingDirection(source, target, occupied);
    }

    public double calculatePoint(Color color) {
        double sum = board.sumDefaultPoints(color);
        int count = board.countDuplicatedPawn(color);
        return sum - (count * DECREASED_PAWN_POINT);
    }

    public boolean isWhiteTurn() {
        return turn % 2 == 1;
    }

    public boolean isOver() {
        return !board.hasTwoKings();
    }
}
