package chess.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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