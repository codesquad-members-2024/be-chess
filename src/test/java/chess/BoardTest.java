package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    static Board board;

    @BeforeEach
    @AfterEach
    void clearBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("초기화 시 알맞은 위치에 기물들이 놓여져야 한다")
    public void initialize() throws Exception {
        Board board = new Board();
        board.init();
        assertEquals("♙♙♙♙♙♙♙♙", board.getWhitePawnsResult());
        assertEquals("♟♟♟♟♟♟♟♟", board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("보드에 기물이 정상적으로 추가되어야 한다")
    void addPawn() {
        verifyAddPawn(Piece::createWhitePawn);
        verifyAddPawn(Piece::createBlackPawn);
    }

    private void verifyAddPawn(Supplier<Piece> createPiece) {
        int size = board.size();
        Piece piece = createPiece.get();
        board.add(piece);
        assertEquals(size + 1, board.size());
    }

    @Test
    void create() throws Exception {
        board.init();
        assertEquals(32, board.size());
        String blankRank = appendNewLine("        ");
        assertEquals(
                appendNewLine("♜♞♝♛♚♝♞♜") +
                        appendNewLine("♟♟♟♟♟♟♟♟") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("♙♙♙♙♙♙♙♙") +
                        appendNewLine("♖♘♗♕♔♗♘♖"),
                board.showBoard());
    }

    @Test
    void move() throws Exception {
        board.initEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.addPieceAt(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    void findPiece() throws Exception {
        board.init();

        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }

    @Test
    void calculatePoint() throws Exception {
        board.initEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());
        addPiece("b4", Piece.createBlackPawn());
        addPiece("b3", Piece.createBlackPawn());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertEquals(15.5, board.calculatePoint(Piece.Color.BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(Piece.Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.addPieceAt(position, piece);
    }

    @Test
    @DisplayName("보드의 기물들을 정렬했을 때 점수가 높은 순서 , 검은색 -> 흰색 순서로 정렬 되어야 함")
    void sortPieces(){
        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("f2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());

        List<Piece> result = List.of(
                board.findPiece("e6"),
                board.findPiece("b6"),
                board.findPiece("e1"),
                board.findPiece("f2")
        );

        assertThat(board.sortPieces()).isEqualTo(result);
    }
}
