package chess.board;

import static chess.common.Color.*;
import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.PieceFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    private Board board;
    private Game game;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.clear();
    }


    @DisplayName("검정색 기물에 대해 폰이 아닌 킹, 퀸, 나이트, 비숍, 룩의 합은 19.5점이다")
    @Test
    void calculateMajorPoints() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackKing());
        board.setPiece("a2", PieceFactory.createBlackQueen());
        board.setPiece("a3", PieceFactory.createBlackKnight());
        board.setPiece("a4", PieceFactory.createBlackBishop());
        board.setPiece("a5", PieceFactory.createBlackRook());

        game = new Game(board.getBoardBlocks());

        // when
        double majorPoints = game.calculateMajorPoints(BLACK);

        // then
        assertEquals(19.5, majorPoints, 0.01);
    }

    @DisplayName("검정색 기물에 대해, 폰이 같은 열에 3개 있으면 합은 1.5점이다")
    @Test
    void calculatePawnPoints_when_same_file() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackPawn());
        board.setPiece("a2", PieceFactory.createBlackPawn());
        board.setPiece("a3", PieceFactory.createBlackPawn());

        game = new Game(board.getBoardBlocks());

        // when
        double pawnPoints = game.calculatePawnPoints(BLACK);

        // then
        assertEquals(1.5, pawnPoints, 0.01);
    }

    @DisplayName("검은색 기물에 대해, 폰이 같은 행에 3개 있으면 합은 3.0점이다")
    @Test
    void calculatePawnPoints_when_different_file() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackPawn());
        board.setPiece("b1", PieceFactory.createBlackPawn());
        board.setPiece("c1", PieceFactory.createBlackPawn());

        game = new Game(board.getBoardBlocks());

        // when
        double pawnPoints = game.calculatePawnPoints(BLACK);

        // then
        assertEquals(3.0, pawnPoints, 0.01);
    }

    @DisplayName("검정색 기물에 대해, 나이트 2개, 룩 1개, 퀸 1개, 같은 열의 폰 2개의 점수 합은 20.0 이다")
    @Test
    void calculatePoints() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackKnight());
        board.setPiece("a2", PieceFactory.createBlackKnight());
        board.setPiece("a3", PieceFactory.createBlackRook());
        board.setPiece("a4", PieceFactory.createBlackQueen());

        board.setPiece("b1", PieceFactory.createBlackPawn());
        board.setPiece("b2", PieceFactory.createBlackPawn());

        game = new Game(board.getBoardBlocks());

        // when
        double points = game.calculatePoints(BLACK);

        // then
        assertEquals(20.0, points, 0.01);
    }
}