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

class QueenTest {

    private Board chessBoard;
    private ChessGame chessGame;

    @BeforeEach
    void setUp() {
        this.chessBoard = new Board();
        this.chessGame = new ChessGame(chessBoard);
    }

    @Test
    @DisplayName("Queen 기물의 색깔과 유니코드 심볼이 알맞게 생성되어야 한다.")
    void create() {
        Queen blackQueen = Queen.create(Color.BLACK, new Position("d8"));
        Queen whiteQueen = Queen.create(Color.WHITE, new Position("d1"));

        verifyQueen(blackQueen, Color.BLACK);
        verifyQueen(whiteQueen, Color.WHITE);
    }

    private void verifyQueen(final Piece Piece, final Color color) {
        assertThat(Piece.matchColor(color)).isTrue();
        assertThat(Piece.matchSymbol(PieceSymbol.QUEEN)).isTrue();
    }

    @DisplayName("입력받은 위치가 Queen의 이동 가능한 범위이어야 한다.")
    @ValueSource(strings = {"a8", "a5", "h8", "f6", "d5"})
    @ParameterizedTest
    void verifyMovePosition(String pos) {
        Queen blackQueen = Queen.create(Color.BLACK, new Position("d8"));

        assertThat(blackQueen.verifyMovePosition(new Position("a1"))).isFalse();
        assertThat(blackQueen.verifyMovePosition(new Position(pos))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 같은 색의 기물이 존재한다면 움직일 수 없다.")
    @ValueSource(strings = {"c8", "c7", "d7", "e7", "e8"})
    @ParameterizedTest
    void 같은_색의_기물_존재(String pos) {
        chessBoard.initialize();
        Queen blackQueen = Queen.create(Color.BLACK, new Position("d8"));
        assertThat(blackQueen.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackQueen))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 아무것도 없거나 다른 색의 기물이 존재한다면 이동할 수 있다.")
    @ValueSource(strings = {"d2", "d3", "d4", "e2", "e4", "f2", "f3", "f4"})
    @ParameterizedTest
    void 같은_색의_기물_존재하지않음(String pos) {
        chessBoard.initialize();
        Queen blackQueen = Queen.create(Color.BLACK, new Position("e3"));
        assertThat(blackQueen.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackQueen))).isFalse();
    }

    @DisplayName("Queen만의 이동 방향으로 이동할 수 있다.")
    @ValueSource(strings = {"d2", "d3", "d4", "e2", "e4", "f2", "f3", "f4"})
    @ParameterizedTest
    void move(String pos) {
        chessBoard.initialize();
        Queen blackQueen = Queen.create(Color.BLACK, new Position("e3"));
        blackQueen.move(new Position(pos));
        assertThat(blackQueen.getPosition()).isEqualTo(new Position(pos));
    }
}