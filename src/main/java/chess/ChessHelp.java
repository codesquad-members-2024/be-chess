package chess;

import chess.pieces.Piece;

import java.util.List;
import java.util.function.Supplier;

public class ChessHelp {
    static final int MIN_RANK = 1;
    static final int MIN_FILE = 1;
    static final int MAX_RANK = 8;
    static final int MAX_FILE = 8;

    static final List<Supplier<Piece>> blackPieceSequence = List.of(
            Piece::createBlackRook,
            Piece::createBlackKnight,
            Piece::createBlackBishop,
            Piece::createBlackQueen,
            Piece::createBlackKing,
            Piece::createBlackBishop,
            Piece::createBlackKnight,
            Piece::createBlackRook
    );

    static final List<Supplier<Piece>> whitePieceSequence = List.of(
            Piece::createWhiteRook,
            Piece::createWhiteKnight,
            Piece::createWhiteBishop,
            Piece::createWhiteQueen,
            Piece::createWhiteKing,
            Piece::createWhiteBishop,
            Piece::createWhiteKnight,
            Piece::createWhiteRook
    );

    static int[] getRankFile(String position) {
        char file = position.charAt(0);
        int rank = MAX_RANK - Integer.parseInt(position.substring(1));
        int fileInt = file - 'a' + MIN_FILE;

        return new int[]{rank, fileInt};
    }
}
