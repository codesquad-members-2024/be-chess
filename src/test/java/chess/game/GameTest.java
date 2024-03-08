package chess.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {
    Board board;
    Game game;

    @BeforeEach
    void setUp() {
        board = new Board();
        game = new Game(board);
    }

    @Test
    @DisplayName("원하는 위치로 피스를 이동시킬 수 있다.")
    public void move() {
        board.initialize();

        Position source = new Position("b2");
        Position target = new Position("b3");

        game.move(source, target);
        assertThat(board.findPiece(source)).isEqualTo(Piece.createBlank(source)); // 위치 정보까지 동일해야 동일한 객체
        assertThat(board.findPiece(target)).isEqualTo(Piece.of(Type.PAWN, Color.WHITE, target));
    }

    @Test
    @DisplayName("보드 밖으로 이동할 수 없다.")
    void move_InvalidPosition_ThrowsException() {
        board.initializeEmpty();
        Piece whitePawn = Piece.of(Type.PAWN, Color.WHITE, new Position(1, 1));
        board.addPiece(new Position(1, 1), whitePawn);

        assertThatThrownBy(() -> game.move(new Position(1, 1), new Position(8, 8)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Game.INVALID_POSITION);
    }

    @Test
    @DisplayName("자신의 위치로 이동할 수 없다.")
    void move_SelfPosition_ThrowsException() {
        board.initializeEmpty();
        Piece whitePawn = Piece.of(Type.PAWN, Color.WHITE, new Position(1, 1));
        board.addPiece(new Position(1, 1), whitePawn);

        assertThatThrownBy(() -> game.move(new Position(1, 1), new Position(1, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Game.INVALID_POSITION);
    }

    @Test
    @DisplayName("아군의 위치로 이동할 수 없다.")
    void move_MoveToAllyPosition_ThrowsException() {
        board.initializeEmpty();
        Piece whitePawn1 = Piece.of(Type.PAWN, Color.WHITE, new Position(1, 1));
        Piece whitePawn2 = Piece.of(Type.PAWN, Color.WHITE, new Position(2, 1));
        board.addPiece(new Position(1, 1), whitePawn1);
        board.addPiece(new Position(2, 1), whitePawn2);

        assertThatThrownBy(() -> game.move(new Position(2, 1), new Position(1, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Game.INVALID_POSITION);
    }

    @Test
    @DisplayName("흰색의 턴에 검정색을 선택하면 예외가 발생한다.")
    void move_WrongTurn_ThrowsException() {
        board.initializeEmpty();
        Piece blackPawn = Piece.of(Type.PAWN, Color.BLACK, new Position(6, 1));
        board.addPiece(new Position(6, 1), blackPawn);

        assertThatThrownBy(() -> game.move(new Position(6, 1), new Position(7, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Game.INVALID_SELECT);

        Piece king = Piece.of(Type.KING, Color.WHITE, new Position(1, 1));
        board.addPiece(new Position(1, 1), king);
        assertThatCode(() -> game.move(new Position(1, 1), new Position(1, 2))).doesNotThrowAnyException(); // 흰색턴
        assertThatCode(() -> game.move(new Position(6, 1), new Position(7, 1))).doesNotThrowAnyException(); // 검정턴

        assertThatThrownBy(() -> game.move(new Position(7, 1), new Position(6, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Game.INVALID_SELECT); // 흰색턴
    }

    @Test
    @DisplayName("피스가 폰일 경우 폰의 고유한 움직임을 가져갈 수 있다.")
    void pawn_move() {
        board.initializeEmpty();
        Piece pawn = Piece.of(Type.PAWN, Color.WHITE, null);
        Piece king = Piece.of(Type.KING, Color.BLACK, null);
        board.addPiece(new Position(7, 1), pawn);
        board.addPiece(new Position(3, 1), king);
        assertThatCode(() -> game.move(new Position(7, 1), new Position(5, 1))).doesNotThrowAnyException();

        game.move(new Position(3, 1), new Position(4, 1));
        assertThatThrownBy(() -> game.move(new Position(5, 1), new Position(3, 1))).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(Game.INVALID_DIRECTION); // 처음 이후 2칸 이동 불가

        assertThatThrownBy(() -> game.move(new Position(5, 1), new Position(4, 1))).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(Game.INVALID_DIRECTION); // 정면으로 공격 불가

        board.addPiece(new Position(4, 2), king);
        assertThatCode(() -> game.move(new Position(5, 1), new Position(4, 2))).doesNotThrowAnyException(); // 대각선 공격 가능
    }

    @ParameterizedTest
    @DisplayName("왕이 제거되면 게임은 종료된다.")
    @ValueSource(ints = {0, 7})
    void isOver(int yPos) {
        board.initialize();
        assertThat(game.isOver()).isFalse();

        board.addPiece(new Position(yPos, 4), Piece.createBlank(null));
        assertThat(game.isOver()).isTrue(); // 왕이 제거되면 게임 종료

    }

    @Test
    @DisplayName("색깔별로 점수를 계산할 수 있다.")
    void calculatePoint() {
        board.initializeEmpty();
        addPieces();

        assertThat(game.calculatePoint(Color.BLACK)).isCloseTo(15.5, Offset.offset(0.01));
        assertThat(game.calculatePoint(Color.WHITE)).isCloseTo(7.5, Offset.offset(0.01));
    }


    private void addPieces() {
        addPiece("b6", Piece.of(Type.PAWN, Color.BLACK, null));
        addPiece("e6", Piece.of(Type.QUEEN, Color.BLACK, null));
        addPiece("b8", Piece.of(Type.KING, Color.BLACK, null));
        addPiece("c8", Piece.of(Type.ROOK, Color.BLACK, null));
        addPiece("b7", Piece.of(Type.PAWN, Color.BLACK, null)); // 같은 컬럼에 폰 추가
        addPiece("b5", Piece.of(Type.PAWN, Color.BLACK, null)); // 같은 컬럼에 폰 추가

        addPiece("f2", Piece.of(Type.PAWN, Color.WHITE, null));
        addPiece("g2", Piece.of(Type.PAWN, Color.WHITE, null));
        addPiece("e1", Piece.of(Type.ROOK, Color.WHITE, null));
        addPiece("f1", Piece.of(Type.KING, Color.WHITE, null));
        addPiece("f3", Piece.of(Type.PAWN, Color.WHITE, null)); // 같은 컬럼에 폰 추가
        addPiece("f4", Piece.of(Type.PAWN, Color.WHITE, null)); // 같은 컬럼에 폰 추가
    }

    private void addPiece(String position, Piece piece) {
        board.addPiece(new Position(position), piece);
    }
}