package chess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.King;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Queen;
import pieces.Rook;
import utils.Position;
import view.ChessView;

class ChessGameTest {
    private Board board;
    private ChessGame chessGame;
    private ChessView chessView;

    @BeforeEach
    void setBoard() {
        this.board = new Board();
        this.chessGame = new ChessGame(board);
        this.chessView = new ChessView(board);
    }

    @Test
    @DisplayName("체스 프로그램에서 현재까지 남아 있는 기물에 따라 점수를 계산할 수 있다.")
    public void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Pawn.create(Color.BLACK, new Position("b6")));
        addPiece("e6", Queen.create(Color.BLACK, new Position("e6")));
        addPiece("b8", King.create(Color.BLACK, new Position("b8")));
        addPiece("c8", Rook.create(Color.BLACK, new Position("c8")));

        addPiece("a3", Pawn.create(Color.WHITE, new Position("a3")));
        addPiece("f2", Pawn.create(Color.WHITE, new Position("f2")));
        addPiece("f3", Pawn.create(Color.WHITE, new Position("f3")));
        addPiece("g2", Pawn.create(Color.WHITE, new Position("g2")));
        addPiece("e1", Rook.create(Color.WHITE, new Position("e1")));
        addPiece("f1", King.create(Color.WHITE, new Position("f1")));

        chessView.showBoard();

        assertThat(chessGame.calculatePoint(Color.BLACK)).isEqualTo(15.0, within(0.01));
        assertThat(chessGame.calculatePoint(Color.WHITE)).isEqualTo(8.0, within(0.01));

        chessView.showBoard();
    }

    private void addPiece(String position, Piece piece) {
        chessGame.addPiece(position, piece);
    }

    @Test
    @DisplayName("기물의 점수가 높은 순으로 정렬할 수 있다.")
    public void sortPieces() {
        board.initialize();

        assertThat(String.join("", chessGame.sortPieces(Color.WHITE))).isEqualTo("♕♖♖♗♗♘♘♙♙♙♙♙♙♙♙♔");
        assertThat(String.join("", chessGame.sortPieces(Color.BLACK))).isEqualTo("♕♖♖♗♗♘♘♙♙♙♙♙♙♙♙♔");
        assertThat(String.join("", chessGame.sortPiecesReversed(Color.WHITE))).isEqualTo("♔♙♙♙♙♙♙♙♙♘♘♗♗♖♖♕");
        assertThat(String.join("", chessGame.sortPiecesReversed(Color.BLACK))).isEqualTo("♔♙♙♙♙♙♙♙♙♘♘♗♗♖♖♕");
    }

//    @Test
//    @DisplayName("기물이 현재 위치에서 다른 위치로 이동할 수 있다.")
//    public void movePieceFromSourceToTarget() throws Exception {
//        board.initialize();
//        chessView.showBoard();
//
//        String sourcePosition = "b2";
//        String targetPosition = "b3";
//        chessGame.move(sourcePosition, targetPosition);
//        assertThat(Blank.create(new Position(sourcePosition)))
//                .isEqualTo(board.findPiece(new Position(sourcePosition)));
//        assertThat(Pawn.create(Color.WHITE, new Position(targetPosition)))
//                .isEqualTo(board.findPiece(new Position(targetPosition)));
//    }
}