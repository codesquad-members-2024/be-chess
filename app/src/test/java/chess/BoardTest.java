package chess;

import chess.Board;
import chess.pieces.ChessPieceColor;
import chess.pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private Board board;

    @Nested
    @DisplayName("Board 클래스는 생성 후")
    class CreatingBoard {
        @BeforeEach
        void setBoard(){
             board = new Board();
        }

        @Nested
        @DisplayName("기본 폰 한 개를 추가한다면")
        class AddOneStandardPawn {
            @BeforeEach
            void onePawn(){
                Pawn whitePawn = new Pawn();
                board.addPawn(whitePawn);
            }
            @Test
            @DisplayName("보드 위의 폰의 갯수는 1개이다")
            void getBoardSize(){
                assertThat(board.getNumOfPawn()).isEqualTo(1);
            }

            @Test
            @DisplayName("폰의 색상은 하얀색이다")
            void findPawnColorOnBoard(){
                assertThat(board.findPawn(0)).isEqualTo(ChessPieceColor.WHITE.getColorName());
            }
        }

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        @DisplayName("하얀 말 하나, 검은 말 하나를 추가한다면")
        class AddWhiteBlackPawn {
            Board board = new Board();

            @BeforeAll
            void addPawns(){
                Pawn whitePawn = new Pawn(ChessPieceColor.WHITE.getColorName());
                Pawn blackPawn = new Pawn(ChessPieceColor.BLACK.getColorName());
                board.addPawn(whitePawn);
                board.addPawn(blackPawn);
            }

            @Test
            @DisplayName("보드 위의 폰의 갯수는 1개이다")
            void getBoardSize(){
                assertThat(board.getNumOfPawn()).isEqualTo(2);
            }

            @Nested
            @DisplayName("폰의 색상은")
            class ColorOfPawn {
                @Test
                @DisplayName("첫 번째는 하얀색이다")
                void findFirstPawnColorOnBoard(){
                    assertThat(board.findPawn(0)).isEqualTo(ChessPieceColor.WHITE.getColorName());
                }

                @Test
                @DisplayName("두 번째는 검은색이다")
                void findSecondPawnColorOnBoard(){
                    assertThat(board.findPawn(1)).isEqualTo(ChessPieceColor.BLACK.getColorName());

                }
            }
        }
    }
}