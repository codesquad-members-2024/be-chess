package chess.game;

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
        piece.changePosition(target);
        board.addPiece(target, piece);
        board.addPiece(source, Piece.createBlank(source));
    }

    public double calculatePoint(Color color) {
        double sum = board.sumDefaultPoints(color);
        int count = board.countDuplicatedPawn(color);
        return sum - (count * 0.5);
    }

}
