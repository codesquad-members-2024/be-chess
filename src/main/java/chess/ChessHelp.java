package chess;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;

import java.util.List;
import java.util.function.Supplier;

public class ChessHelp {
    static final int MIN_RANK = 1;
    static final int MIN_FILE = 1;
    static final int MAX_RANK = 8;
    static final int MAX_FILE = 8;

    static final List<Supplier<Piece>> blackPieceSequence = List.of(
            PieceFactory::createBlackRook,
            PieceFactory::createBlackKnight,
            PieceFactory::createBlackBishop,
            PieceFactory::createBlackQueen,
            PieceFactory::createBlackKing,
            PieceFactory::createBlackBishop,
            PieceFactory::createBlackKnight,
            PieceFactory::createBlackRook
    );

    static final List<Supplier<Piece>> whitePieceSequence = List.of(
            PieceFactory::createWhiteRook,
            PieceFactory::createWhiteKnight,
            PieceFactory::createWhiteBishop,
            PieceFactory::createWhiteQueen,
            PieceFactory::createWhiteKing,
            PieceFactory::createWhiteBishop,
            PieceFactory::createWhiteKnight,
            PieceFactory::createWhiteRook
    );

    static int[] getRankFile(String position) {
        char file = position.charAt(0);
        int rank = MAX_RANK - Integer.parseInt(position.substring(1));
        int fileInt = file - 'a' + MIN_FILE;

        return new int[]{rank, fileInt};
    }
}
