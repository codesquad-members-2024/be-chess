package pieces;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PieceTest {
    @ParameterizedTest
    @MethodSource("whitePieceTypeProvider")
    void createWhitePieces(Piece piece,PieceType pieceType){
        verifyPiece(piece,PieceColor.WHITE, pieceType);
    }
    static Stream<Arguments> whitePieceTypeProvider() {
        return Stream.of(
                arguments(Piece.createWhitePawn(), PieceType.PAWN),
                arguments(Piece.createWhiteRook(), PieceType.ROOK),
                arguments(Piece.createWhiteKnight(), PieceType.KNIGHT),
                arguments(Piece.createWhiteBishop(), PieceType.BISHOP),
                arguments(Piece.createWhiteQueen(), PieceType.QUEEN),
                arguments(Piece.createWhiteKing(), PieceType.KING)
        );
    }
    @ParameterizedTest
    @MethodSource("blackPieceTypeProvider")
    void createBlackPieces(Piece piece,PieceType pieceType){
        verifyPiece(piece,PieceColor.BLACK, pieceType);
    }
    static Stream<Arguments> blackPieceTypeProvider() {
        return Stream.of(
                arguments(Piece.createBlackPawn(), PieceType.PAWN),
                arguments(Piece.createBlackRook(), PieceType.ROOK),
                arguments(Piece.createBlackKnight(), PieceType.KNIGHT),
                arguments(Piece.createBlackBishop(), PieceType.BISHOP),
                arguments(Piece.createBlackQueen(), PieceType.QUEEN),
                arguments(Piece.createBlackKing(), PieceType.KING)
        );
    }
    void verifyPiece(final Piece piece,final PieceColor color, final PieceType pieceType) {
        assertEquals(color, piece.getColor());
        if (piece.isWhite()){
            assertEquals(pieceType.getWhiteRepresentation(), piece.getRepresentation());
        }else{
            assertEquals(pieceType.getBlackRepresentation(), piece.getRepresentation());
        }
    }
}