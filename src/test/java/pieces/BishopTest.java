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

class BishopTest {

    private Board chessBoard;
    private ChessGame chessGame;

    @BeforeEach
    void setUp() {
        this.chessBoard = new Board();
        this.chessGame = new ChessGame(chessBoard);
    }

    @Test
    @DisplayName("Bishop 기물의 색깔과 유니코드 심볼이 알맞게 생성되어야 한다.")
    void create() {
        Bishop blackBishop = Bishop.create(Color.BLACK, new Position("c8"));
        Bishop whiteBishop = Bishop.create(Color.WHITE, new Position("c1"));

        verifyBishop(blackBishop, Color.BLACK);
        verifyBishop(whiteBishop, Color.WHITE);
    }

    private void verifyBishop(final Piece Piece, final Color color) {
        assertThat(Piece.matchColor(color)).isTrue();
        assertThat(Piece.matchSymbol(PieceSymbol.BISHOP)).isTrue();
    }

    @DisplayName("입력받은 위치가 Bishop의 이동 가능한 범위이어야 한다.")
    @ValueSource(strings = {"a6", "b7", "d7", "e6", "f5", "g4", "h3"})
    @ParameterizedTest
    void verifyMovePosition(String pos) {
        Bishop blackBishop = Bishop.create(Color.BLACK, new Position("c8"));

        assertThat(blackBishop.verifyMovePosition(new Position("a1"))).isFalse();
        assertThat(blackBishop.verifyMovePosition(new Position(pos))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 같은 색의 기물이 존재한다면 움직일 수 없다.")
    @ValueSource(strings = {"b7", "d7", "a6", "f5"})
    @ParameterizedTest
    void 같은_색의_기물_존재(String pos) {
        chessBoard.initialize();
        Bishop blackBishop = Bishop.create(Color.BLACK, new Position("c8"));
        assertThat(blackBishop.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackBishop))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 아무것도 없거나 다른 색의 기물이 존재한다면 이동할 수 있다.")
    @ValueSource(strings = {"a6", "a2", "e6"})
    @ParameterizedTest
    void 같은_색의_기물_존재하지않음(String pos) {
        chessBoard.initialize();
        Bishop blackBishop = Bishop.create(Color.BLACK, new Position("c4"));
        assertThat(blackBishop.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackBishop))).isFalse();
    }

    @DisplayName("Bishop만의 이동 방향으로 이동할 수 있다.")
    @ValueSource(strings = {"a6", "b7", "d7", "e6", "f5", "g4", "h3"})
    @ParameterizedTest
    void move(String pos) {
        chessBoard.initialize();
        Bishop blackBishop = Bishop.create(Color.BLACK, new Position("c8"));
        blackBishop.move(new Position(pos));
        assertThat(blackBishop.getPosition()).isEqualTo(new Position(pos));
    }
}