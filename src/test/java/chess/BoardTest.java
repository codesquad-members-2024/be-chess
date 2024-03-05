package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    static Board board;

    @BeforeEach
    @AfterEach
    void clearBoard(){
        board = new Board();
    }

    @Test
    @DisplayName("초기화 시 알맞은 위치에 기물들이 놓여져야 한다")
    public void initialize() throws Exception {
        Board board = new Board();
        board.init();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
    @Test
    @DisplayName("보드에 기물이 정상적으로 추가되어야 한다")
    void addPawn(){
        verifyAddPawn(Piece::createWhitePawn);
        verifyAddPawn(Piece::createBlackPawn);
    }

    private void verifyAddPawn(Supplier<Piece> createPiece) {
        int size = board.size();
        Piece piece = createPiece.get();
        board.add(piece);
        assertEquals(size+1, board.size());
    }

    @Test
    void create() throws Exception {
        board.init();
        assertEquals(32, board.size());
        String blankRank = appendNewLine("........");
        assertEquals(
            appendNewLine("RNBQKBNR") +
            appendNewLine("PPPPPPPP") +
            blankRank + blankRank + blankRank + blankRank +
            appendNewLine("pppppppp") +
            appendNewLine("rnbqkbnr"),
            board.showBoard());
    }
}
