package chess.game;

import static chess.board.Board.COLUMN_AND_ROW_SIZE;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;

public class Game {
    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void move(Position source, Position target) {
        Piece piece = board.findPiece(source);
        board.addPiece(target, piece.changePosition(target));
        board.addPiece(source, Piece.createBlank(source));
    }

    public double calculatePoint(Color color) {
        double sum = 0;
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            sum = addSum(color, i, sum);
        }
        return sum;
    }

    private double addSum(Color color, int i, double sum) {
        for (int j = 0; j < COLUMN_AND_ROW_SIZE; j++) {
            Piece target = board.findPiece(i, j);
            if (target.getColor() != color) {
                continue;
            }
            if (!target.isPawn()) {
                sum += target.getDefaultPoint();
                continue;
            }
            if (hasSameColumnPawn(target, i, j)) {
                sum += target.getDefaultPoint() / 2;
                continue;
            }
            sum += target.getDefaultPoint();
        }
        return sum;
    }

    private boolean hasSameColumnPawn(Piece target, int row, int column) {
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            if (i == row) {
                continue;
            }
            Piece other = board.findPiece(i, column);
            if (other.isPawn() && target.getColor() == other.getColor()) {
                return true;
            }
        }
        return false;
    }

}
