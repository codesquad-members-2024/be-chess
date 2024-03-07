package chess.board;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    private Position a1;

    @BeforeEach
    void setUp() {
        a1 = Position.init(0, 0);    
    }

    @DisplayName("체스판의 위치를 나타내는 포지션을 0행, 5열(f1)로 생성할 수 있다")
    @Test
    void create() {
        // given
        Position position = Position.init(0, 5);

        // when
        int rank = position.getRank();
        int file = position.getFile();
        String pos = position.getPos();
        Piece blank = position.getPiece();

        // then
        assertThat(rank).isEqualTo(0);
        assertThat(file).isEqualTo(5);
        assertThat(pos).isEqualTo("f1");
        assertThat(blank).isEqualTo(Piece.createBlank());
    }

    @DisplayName("3행 7열은 h4로 변환 할 수 있다")
    @Test
    void convert_rank_and_file_to_pos() {
        // given
        int rank = 3;
        int file = 7;

        // when
        String pos = Position.convertRankAndFileToPos(rank, file);

        // then
        assertThat(pos).isEqualTo("h4");
    }

    @DisplayName("a8은 7행 0열로 변환 할 수 있다")
    @Test
    void convert_pos_to_rank_and_file() {
        // given
        String pos = "a8";

        // when
        int[] rankAndFile = Position.convertPosToRankAndFile(pos);
        int rank = rankAndFile[0];
        int file = rankAndFile[1];

        // then
        assertThat(rank).isEqualTo(7);
        assertThat(file).isEqualTo(0);
    }

    @DisplayName("Position은 자신의 위치에 해당하는 기물을 뽑을 수 있다")
    @Test
    void pick() {
        // given
        a1.changePiece(Piece.createBlackKnight());

        // when
        Piece pickedPiece = a1.pick();

        // then
        assertThat(pickedPiece).isEqualTo(Piece.createBlackKnight());
    }

    @DisplayName("Position은 기물을 뽑으면 빈칸이 된다")
    @Test
    void isBlank() {
        // given
        a1.changePiece(Piece.createBlackKnight());

        // when
        a1.pick();

        // then
        assertTrue(a1.isBlank());
    }

    @DisplayName("흰색 폰을 가진 Postion을 검정색 나이트로 바꿀 수 있다")
    @Test
    void changePiece() {
        // given & when
        Piece whitePawn = a1.changePiece(Piece.createWhitePawn()).getPiece();
        Piece blackKnight = a1.changePiece(Piece.createBlackKnight()).getPiece();

        // then
        assertThat(whitePawn).isNotEqualTo(blackKnight);
        assertThat(blackKnight).isEqualTo(Piece.createBlackKnight());
    }

    @DisplayName("한 Position에 있는 검은색 킹을 다른 Position으로 옮길 수 있다")
    @Test
    void movePieceToTargetPosition() {
        // given
        Position one = a1.changePiece(Piece.createBlackKing());
        Position other = Position.init(1, 1);

        // when
        one.movePieceToTargetPosition(other);

        // then
        assertAll(
                "기물을 다른 Postion에 옮긴 후엔 빈칸이 된다",
                () -> assertTrue(one.isBlank()),
                () -> assertThat(other.getPiece()).isEqualTo(Piece.createBlackKing())
        );
    }

    @DisplayName("a8을 가진 Position과 똑같은 위치를 가졌는지 알 수 있다")
    @Test
    void isSamePosition() {
        // given
        int[] rankAndFile = Position.convertPosToRankAndFile("a8");
        Position position = Position.init(rankAndFile[0], rankAndFile[1]);

        // when & then
        assertTrue(position.isSamePos("a8"));
        assertFalse(position.isSamePos("a7"));
    }
}