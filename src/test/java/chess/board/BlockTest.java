package chess.board;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlockTest {

    private Block a1;

    @BeforeEach
    void setUp() {
        a1 = Block.init(7, 0);
    }

    @DisplayName("체스판의 위치를 나타내는 포지션을 0행, 5열(f8)로 생성할 수 있다")
    @Test
    void create() {
        // given
        Block block = Block.init(0, 5);

        // when
        int rank = block.getRank();
        int file = block.getFile();
        String pos = block.getPos();
        Piece blank = block.getPiece();

        // then
        assertThat(rank).isEqualTo(0);
        assertThat(file).isEqualTo(5);
        assertThat(pos).isEqualTo("f8");
        assertThat(blank).isEqualTo(PieceFactory.createBlank());
    }

    @DisplayName("5행 7열은 h4로 변환 할 수 있다")
    @Test
    void convert_rank_and_file_to_pos() {
        // given
        int rank = 4;
        int file = 7;

        // when
        String pos = Block.convertRankAndFileToPos(rank, file);

        // then
        assertThat(pos).isEqualTo("h4");
    }

    @DisplayName("a8은 0행 0열로 변환 할 수 있다")
    @Test
    void convert_pos_to_rank_and_file() {
        // given
        String pos = "a8";

        // when
        int[] rankAndFile = Block.convertPosToRankAndFile(pos);
        int rank = rankAndFile[0];
        int file = rankAndFile[1];

        // then
        assertThat(rank).isEqualTo(0);
        assertThat(file).isEqualTo(0);
    }

    @DisplayName("Block은 자신의 위치에 해당하는 기물을 뽑을 수 있다")
    @Test
    void pick() {
        // given
        a1.changePiece(PieceFactory.createBlackKnight());

        // when
        Piece pickedPiece = a1.pick();

        // then
        assertThat(pickedPiece).isEqualTo(PieceFactory.createBlackKnight());
    }

    @DisplayName("Block은 기물을 뽑으면 빈칸이 된다")
    @Test
    void isBlank() {
        // given
        a1.changePiece(PieceFactory.createBlackKnight());

        // when
        a1.pick();

        // then
        assertTrue(a1.isBlank());
    }

    @DisplayName("흰색 폰을 가진 Postion을 검정색 나이트로 바꿀 수 있다")
    @Test
    void changePiece() {
        // given & when
        Piece whitePawn = a1.changePiece(PieceFactory.createWhitePawn()).getPiece();
        Piece blackKnight = a1.changePiece(PieceFactory.createBlackKnight()).getPiece();

        // then
        assertThat(whitePawn).isNotEqualTo(blackKnight);
        assertThat(blackKnight).isEqualTo(PieceFactory.createBlackKnight());
    }

    @DisplayName("한 Block에 있는 검은색 킹을 다른 Block으로 옮길 수 있다")
    @Test
    void movePieceToTargetBlock() {
        // given
        Block one = a1.changePiece(PieceFactory.createBlackKing());
        Block other = Block.init(1, 1);

        // when
        one.movePieceToTargetBlock(other);

        // then
        assertAll(
                "기물을 다른 Postion에 옮긴 후엔 빈칸이 된다",
                () -> assertTrue(one.isBlank()),
                () -> assertThat(other.getPiece()).isEqualTo(PieceFactory.createBlackKing())
        );
    }

    @DisplayName("a8을 가진 Block과 똑같은 위치를 가졌는지 알 수 있다")
    @Test
    void isSameBlock() {
        // given
        int[] rankAndFile = Block.convertPosToRankAndFile("a8");
        Block block = Block.init(rankAndFile[0], rankAndFile[1]);

        // when & then
        assertTrue(block.isSamePos("a8"));
        assertFalse(block.isSamePos("a7"));
    }
}