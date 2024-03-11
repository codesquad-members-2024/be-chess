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

class KingTest {
    private Board chessBoard;
    private ChessGame chessGame;

    @BeforeEach
    void setUp() {
        this.chessBoard = new Board();
        this.chessGame = new ChessGame(chessBoard);
    }

    @Test
    @DisplayName("king 기물의 색깔과 유니코드 심볼이 알맞게 생성되어야 한다.")
    void create() {
        King blackKing = King.create(Color.BLACK, new Position("e8"));
        King whiteKing = King.create(Color.WHITE, new Position("e1"));

        verifyKing(blackKing, Color.BLACK);
        verifyKing(whiteKing, Color.WHITE);
    }

    private void verifyKing(final Piece Piece, final Color color) {
        assertThat(Piece.matchColor(color)).isTrue();
        assertThat(Piece.matchSymbol(PieceSymbol.KING)).isTrue();
    }

    @DisplayName("입력받은 위치가 King의 위치에서 한칸 차이여야 한다.")
    @ValueSource(strings = {"d8", "d7", "e7", "f7", "f8"})
    @ParameterizedTest
    void verifyMovePosition(String pos) {
        King blackKing = King.create(Color.BLACK, new Position("e8"));
        assertThat(blackKing.verifyMovePosition(new Position("a1"))).isFalse();
        assertThat(blackKing.verifyMovePosition(new Position(pos))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 같은 색의 기물이 존재한다면 움직일 수 없다.")
    @ValueSource(strings = {"d8", "d7", "e7", "f7", "f8"})
    @ParameterizedTest
    void 같은_색의_기물_존재(String pos) {
        chessBoard.initialize();
        King blackKing = King.create(Color.BLACK, new Position("e8"));
        assertThat(blackKing.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackKing))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 아무것도 없거나 다른 색의 기물이 존재한다면 이동할 수 있다.")
    @ValueSource(strings = {"d2", "d3", "d4", "e2", "e4", "f2", "f3", "f4"})
    @ParameterizedTest
    void 같은_색의_기물_존재하지않음(String pos) {
        chessBoard.initialize();
        King blackKing = King.create(Color.BLACK, new Position("e3"));
        assertThat(blackKing.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackKing))).isFalse();
    }

    @DisplayName("king은 어느 방향이나 한 칸을 움직일 수 있다.")
    @ValueSource(strings = {"d3", "d4", "d5", "e3", "e5", "f3", "f4", "f5"})
    @ParameterizedTest
    void move(String pos) {
        chessBoard.initialize();
        King blackKing = King.create(Color.BLACK, new Position("e4"));
        blackKing.move(new Position(pos));
        assertThat(blackKing.getPosition()).isEqualTo(new Position(pos));
    }
}