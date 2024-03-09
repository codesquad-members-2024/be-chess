package pieces;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Board;
import chess.ChessGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;
import utils.Position;

class KnightTest {
    private Board chessBoard;
    private ChessGame chessGame;

    @BeforeEach
    void setUp() {
        this.chessBoard = new Board();
        this.chessGame = new ChessGame(chessBoard);
    }

    @Test
    @DisplayName("Knight 기물의 색깔과 유니코드 심볼이 알맞게 생성되어야 한다.")
    void create() {
        Knight blackKnight = Knight.create(Color.BLACK, new Position("e8"));
        Knight whiteKnight = Knight.create(Color.WHITE, new Position("e1"));

        verifyKnight(blackKnight, Color.BLACK);
        verifyKnight(whiteKnight, Color.WHITE);
    }

    private void verifyKnight(final Piece Piece, final Color color) {
        assertThat(Piece.matchColor(color)).isTrue();
        assertThat(Piece.matchSymbol(PieceSymbol.KNIGHT)).isTrue();
    }

    @DisplayName("입력받은 위치가 Knight의 이동 가능한 범위이어야 한다.")
    @ValueSource(strings = {"a6", "c6"})
    @ParameterizedTest
    void verifyMovePosition(String pos) {
        Knight blackKnight = Knight.create(Color.BLACK, new Position("b8"));

        assertThat(blackKnight.verifyMovePosition(new Position("a1"))).isFalse();
        assertThat(blackKnight.verifyMovePosition(new Position(pos))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 같은 색의 기물이 존재한다면 움직일 수 없다.")
    @Test
    void 같은_색의_기물_존재() {
        chessBoard.initialize();
        Knight blackKnight = Knight.create(Color.BLACK, new Position("b8"));
        assertThat(blackKnight.isObstacleInPath(new Position("d7"), chessGame.getObstacle(blackKnight))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 아무것도 없거나 다른 색의 기물이 존재한다면 이동할 수 있다.")
    @ValueSource(strings = {"a6", "c6"})
    @ParameterizedTest
    void 같은_색의_기물_존재하지않음(String pos) {
        chessBoard.initialize();
        Knight blackKnight = Knight.create(Color.BLACK, new Position("b3"));
        assertThat(blackKnight.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackKnight))).isFalse();
    }

    @DisplayName("knight만의 이동 방향으로 이동할 수 있다.")
    @ValueSource(strings = {"d6", "c5", "c3", "d2", "f2", "g3", "g5", "f6"})
    @ParameterizedTest
    void move(String pos) {
        chessBoard.initialize();
        Knight blackKnight = Knight.create(Color.BLACK, new Position("e4"));
        blackKnight.move(new Position(pos));
        assertThat(blackKnight.getPosition()).isEqualTo(new Position(pos));
    }
}