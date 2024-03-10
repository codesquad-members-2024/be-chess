package pieces;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Board;
import chess.ChessGame;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;
import utils.Position;

class PawnTest {

    private Board chessBoard;
    private ChessGame chessGame;

    @BeforeEach
    void setUp() {
        this.chessBoard = new Board();
        this.chessGame = new ChessGame(chessBoard);
    }

    @Test
    @DisplayName("Pawn 기물의 색깔과 유니코드 심볼이 알맞게 생성되어야 한다.")
    void create() {
        Pawn blackPawn = Pawn.create(Color.BLACK, new Position("c7"));
        Pawn whitePawn = Pawn.create(Color.WHITE, new Position("c2"));

        verifyPawn(blackPawn, Color.BLACK);
        verifyPawn(whitePawn, Color.WHITE);
    }

    private void verifyPawn(final Piece Piece, final Color color) {
        assertThat(Piece.matchColor(color)).isTrue();
        assertThat(Piece.matchSymbol(PieceSymbol.PAWN)).isTrue();
    }

    @DisplayName("Black Pawn이 시작 위치에 있을 때, 정면으로 1칸 또는 2칸만 움직일 수 있다.")
    @ValueSource(strings = {"c5", "c6"})
    @ParameterizedTest
    void verifyBlackMovePosition(String pos) {
        Pawn blackPawn = Pawn.create(Color.BLACK, new Position("c7"));

        assertThat(blackPawn.verifyMovePosition(new Position("b6"))).isFalse();
        assertThat(blackPawn.verifyMovePosition(new Position(pos))).isTrue();
    }

    @DisplayName("White Pawn이 시작 위치에 있을 때, 정면으로 1칸 또는 2칸만 움직일 수 있다.")
    @ValueSource(strings = {"c3", "c4"})
    @ParameterizedTest
    void verifyWhiteMovePosition(String pos) {
        Pawn whitePawn = Pawn.create(Color.WHITE, new Position("c2"));

        assertThat(whitePawn.verifyMovePosition(new Position("d3"))).isFalse();
        assertThat(whitePawn.verifyMovePosition(new Position(pos))).isTrue();
    }

    @DisplayName("대각선 위치에 같은 색의 기물이 존재하거나 정면에 기물이 있다면 움직일 수 없다.")
    @ValueSource(strings = {"b2", "c2", "d2"})
    @ParameterizedTest
    void 같은_색의_기물_존재(String pos) {
        chessBoard.initialize();
        Pawn obstacle = Pawn.create(Color.BLACK, new Position("c2"));
        Pawn whitePawn = Pawn.create(Color.WHITE, new Position("c1"));
        List<Position> a = chessGame.getObstacle(whitePawn);
        assertThat(whitePawn.isObstacleInPath(new Position(pos), chessGame.getObstacle(whitePawn))).isTrue();
    }

    @DisplayName("이동하고자 하는 위치에 아무것도 없거나 대각선 위치에 다른 색의 기물이 존재한다면 이동할 수 있다.")
    @ValueSource(strings = {"b2", "d2"})
    @ParameterizedTest
    void 같은_색의_기물_존재하지않음(String pos) {
        chessBoard.initialize();
        Pawn blackPawn = Pawn.create(Color.BLACK, new Position("c3"));
        assertThat(blackPawn.isObstacleInPath(new Position(pos), chessGame.getObstacle(blackPawn))).isFalse();
    }

    @DisplayName("Pawn만의 이동 방향으로 이동할 수 있다.")
    @ValueSource(strings = {"c3", "c4"})
    @ParameterizedTest
    void move(String pos) {
        chessBoard.initialize();
        Pawn whitePawn = Pawn.create(Color.WHITE, new Position("c2"));
        whitePawn.move(new Position(pos));
        assertThat(whitePawn.getPosition()).isEqualTo(new Position(pos));
    }
}