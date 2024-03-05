package board;

import org.example.chess.Board;
import org.example.piece.Pawn;
import org.example.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @DisplayName("보드에 Pawn을 넣는다.")
    @Test
    void test1(){

        Piece whitePawn = new Pawn(Pawn.WHTIE);
        Board board = new Board();
        board.add(whitePawn);

        assertThat(whitePawn).isEqualTo(board.findPiece(0));

        Piece blackPawn = new Pawn(Pawn.BLACK);
        board.add(blackPawn);

        assertThat(blackPawn).isEqualTo(board.findPiece(1));
    }

    @DisplayName("보드의 Pawn과 다른 Pawn가 동일한지 확인한다.")
    @Test
    void test2(){

        Piece whitePawn = new Pawn(Pawn.WHTIE);
        Board board = new Board();
        board.add(whitePawn);

        Piece blackPawn = new Pawn(Pawn.BLACK);
        board.add(blackPawn);
        assertThat(whitePawn).isNotEqualTo(board.findPiece(1));
    }

//
//    @DisplayName("Piece가 아닌 다른 것을 보드에 넣으면 실패한다.")
//    @Test
//    void test3(){
//        Board board = new Board();
//        board.add(1);
//    }-->컴파일에러



}
