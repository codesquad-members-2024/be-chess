package chess.board;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.List;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("초기화시  총 32개의 피스가 생성된다.")
    void create() {
        assertThat(board.pieceCount()).isEqualTo(0);
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);

    }

    @Test
    @DisplayName("특정 피스의 개수를 셀 수 있다.")
    void pieceCount() {
        board.initialize();
        assertThat(board.pieceCount(Type.ROOK, Color.WHITE)).isEqualTo(2);
        assertThat(board.pieceCount(Type.ROOK, Color.BLACK)).isEqualTo(2);
        assertThat(board.pieceCount(Type.KING, Color.WHITE)).isEqualTo(1);
        assertThat(board.pieceCount(Type.QUEEN, Color.BLACK)).isEqualTo(1);
    }

    @Test
    @DisplayName("특정 위치의 피스 정보를 가져올 수 있다.")
    public void findPiece() {
        board.initialize();
        assertThat(board.findPiece(new Position("a8"))).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(board.findPiece(new Position("h8"))).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(board.findPiece(new Position("a1"))).isEqualTo(Piece.createWhite(Type.ROOK));
        assertThat(board.findPiece(new Position("h1"))).isEqualTo(Piece.createWhite(Type.ROOK));

        assertThat(board.findPiece(new Position("e1"))).isEqualTo(Piece.createWhite(Type.KING));
    }

    @Test
    @DisplayName("원하는 위치로 피스를 이동시킬 수 있다.")
    public void move() {
        board.initialize();

        Position source = new Position("b2");
        Position target = new Position("b3");

        board.move(source, target);
        assertThat(board.findPiece(source)).isEqualTo(Piece.createBlank(source)); // 위치 정보까지 동일해야 동일한 객체
        assertThat(board.findPiece(target)).isEqualTo(Piece.createWhite(Type.PAWN, target));
    }

    @Test
    @DisplayName("색깔별로 점수를 계산할 수 있다.")
    void calculatePoint() {
        board.initializeEmpty();
        addPieces();

        assertThat(board.calculatePoint(Color.BLACK)).isCloseTo(15.5, Offset.offset(0.01));
        assertThat(board.calculatePoint(Color.WHITE)).isCloseTo(7.5, Offset.offset(0.01));
    }


    @Test
    @DisplayName("보드 위의 Piece를 점수의 내림차순으로 정렬할 수 있다.")
    void getDescendingPieces() {
        board.initializeEmpty();
        addPieces();
        List<Piece> expect = List.of(Piece.createBlack(Type.QUEEN), Piece.createBlack(Type.ROOK),
                Piece.createBlack(Type.PAWN)
                , Piece.createBlack(Type.PAWN), Piece.createBlack(Type.PAWN), Piece.createBlack(Type.KING)
                , Piece.createWhite(Type.ROOK), Piece.createWhite(Type.PAWN), Piece.createWhite(Type.PAWN),
                Piece.createWhite(Type.PAWN)
                , Piece.createWhite(Type.PAWN), Piece.createWhite(Type.KING));
        assertThat(board.getDescendingPieces()).isEqualTo(expect);
    }

    @Test()
    @DisplayName("보드 위의 Piece를 점수의 오름차순으로 정렬할 수 있다.")
    void getAscendingPieces() {
        board.initializeEmpty();
        addPieces();
        List<Piece> expect = List.of(Piece.createBlack(Type.KING)
                , Piece.createBlack(Type.PAWN), Piece.createBlack(Type.PAWN), Piece.createBlack(Type.PAWN)
                , Piece.createBlack(Type.ROOK), Piece.createBlack(Type.QUEEN)
                , Piece.createWhite(Type.KING)
                , Piece.createWhite(Type.PAWN), Piece.createWhite(Type.PAWN),
                Piece.createWhite(Type.PAWN), Piece.createWhite(Type.PAWN), Piece.createWhite(Type.ROOK));

        assertThat(board.getAscendingPieces()).isEqualTo(expect);
    }


    private void addPieces() {
        addPiece("b6", Piece.createBlack(Type.PAWN));
        addPiece("e6", Piece.createBlack(Type.QUEEN));
        addPiece("b8", Piece.createBlack(Type.KING));
        addPiece("c8", Piece.createBlack(Type.ROOK));
        addPiece("b7", Piece.createBlack(Type.PAWN)); // 같은 컬럼에 폰 추가
        addPiece("b5", Piece.createBlack(Type.PAWN)); // 같은 컬럼에 폰 추가

        addPiece("f2", Piece.createWhite(Type.PAWN));
        addPiece("g2", Piece.createWhite(Type.PAWN));
        addPiece("e1", Piece.createWhite(Type.ROOK));
        addPiece("f1", Piece.createWhite(Type.KING));
        addPiece("f3", Piece.createWhite(Type.PAWN)); // 같은 컬럼에 폰 추가
        addPiece("f4", Piece.createWhite(Type.PAWN)); // 같은 컬럼에 폰 추가
    }

    private void addPiece(String position, Piece piece) {
        board.move(new Position(position), piece);
    }
}
