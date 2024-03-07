package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

@Nested
@DisplayName("Board 클래스는 생성 후")
public class BoardTest {
    private Board board;
    @BeforeEach
    void setBoard(){
             board = new Board();
        }

        @Nested
        @DisplayName("기본 폰 한 개를 추가한다면")
        class AddOneStandardPiece {
            @BeforeEach
            void onePawn(){
                Piece whitePiece = new Piece();
                board.addPawn(whitePiece);
            }
            @Test
            @DisplayName("보드 위의 폰의 갯수는 1개이다")
            void getBoardSize(){
                assertThat(board.getNumOfPawn()).isEqualTo(1);
            }

            @Test
            @DisplayName("폰의 색상은 하얀색이다")
            void findPawnColorOnBoard(){
                assertThat(board.findPawn(0)).isEqualTo(Color.WHITE.getColorName());
            }
        }

        @Nested
        @DisplayName("하얀 말 하나, 검은 말 하나를 추가한다면")
        class AddWhiteBlackPiece {

            @BeforeEach
            void addPawns(){
                Piece whitePiece = new Piece(Color.WHITE.getColorName());
                Piece blackPiece = new Piece(Color.BLACK.getColorName());
                board.addPawn(whitePiece);
                board.addPawn(blackPiece);
            }

            @Test
            @DisplayName("보드 위의 폰의 갯수는 2개이다")
            void getBoardSize(){
                assertThat(board.getNumOfPawn()).isEqualTo(2);
            }

            @Nested
            @DisplayName("폰의 색상은")
            class ColorOfPiece {
                @Test
                @DisplayName("첫 번째는 하얀색이다")
                void findFirstPawnColorOnBoard(){
                    assertThat(board.findPawn(0)).isEqualTo(Color.WHITE.getColorName());
                }

                @Test
                @DisplayName("두 번째는 검은색이다")
                void findSecondPawnColorOnBoard(){
                    assertThat(board.findPawn(1)).isEqualTo(Color.BLACK.getColorName());

                }
            }
        }

        @Nested
        @DisplayName("보드를 초기화하면")
        class initializationTest {

            @BeforeEach
            void initializeBoard(){
                board.initialize();
            }

            @Test
            @DisplayName("위에서 두번째 줄은 검은색 폰들 8개가 있다")
            void getBlackPawnResult(){
                final int BLACK_PAWN_ROW = 1;
                String candidate = board.print().split("\n")[BLACK_PAWN_ROW];
                assertThat(candidate).isEqualTo("♟♟♟♟♟♟♟♟");
            }

            @Test
            @DisplayName("위에서 일곱번째 줄은 검은색 폰들 8개가 있다")
            void getWhitePawnResult(){
                final int WHITE_PAWN_ROW = 6;
                String candidate = board.print().split("\n")[WHITE_PAWN_ROW];
                assertThat(candidate).isEqualTo("♙♙♙♙♙♙♙♙");
            }
    }
}