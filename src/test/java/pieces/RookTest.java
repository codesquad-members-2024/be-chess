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

class RookTest {

    private Board chessBoard;
    private ChessGame chessGame;

    @BeforeEach
    void setUp() {
        this.chessBoard = new Board();
        this.chessGame = new ChessGame(chessBoard);
    }

    @Test
    @DisplayName("Rook 기물의 색깔과 유니코드 심볼이 알맞게 생성되어야 한다.")
    void create() {
        Rook blackRook = Rook.create(Color.BLACK, new Position("a8"));
        Rook whiteRook = Rook.create(Color.WHITE, new Position("h8"));

        verifyRook(blackRook, Color.BLACK);
        verifyRook(whiteRook, Color.WHITE);
    }

    private void verifyRook(final Piece Piece, final Color color) {
        assertThat(Piece.matchColor(color)).isTrue();
        assertThat(Piece.matchSymbol(PieceSymbol.ROOK)).isTrue();
    }

    @DisplayName("입력받은 위치가 Rook의 이동 가능한 범위이어야 한다.")
    @ValueSource(strings = {"a1", "a2", "a3", "e8", "f8", "g8", "h8"})
    @ParameterizedTest
    void verifyMovePosition(String pos) {
        Rook blackRook = Rook.create(Color.BLACK, new Position("a8"));

        assertThat(blackRook.verifyMovePosition(new Position("h1"))).isFalse();
        assertThat(blackRook.verifyMovePosition(new Position(pos))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 같은 색의 기물이 존재한다면 움직일 수 없다.")
    @ValueSource(strings = {"a7", "b8"})
    @ParameterizedTest
    void 같은_색의_기물_존재(String pos) {
        chessBoard.initialize();
        Rook blackRook = Rook.create(Color.BLACK, new Position("a8"));
        assertThat(blackRook.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackRook))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 아무것도 없거나 다른 색의 기물이 존재한다면 이동할 수 있다.")
    @ValueSource(strings = {"c2", "a4", "c6", "f4"})
    @ParameterizedTest
    void 같은_색의_기물_존재하지않음(String pos) {
        chessBoard.initialize();
        Rook blackRook = Rook.create(Color.BLACK, new Position("c4"));
        assertThat(blackRook.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackRook))).isFalse();
    }

    @DisplayName("Rook만의 이동 방향으로 이동할 수 있다.")
    @ValueSource(strings = {"a1", "a2", "a3", "e8", "f8", "g8", "h8"})
    @ParameterizedTest
    void move(String pos) {
        chessBoard.initialize();
        Rook blackRook = Rook.create(Color.BLACK, new Position("a8"));
        blackRook.move(new Position(pos));
        assertThat(blackRook.getPosition()).isEqualTo(new Position(pos));
    }
}