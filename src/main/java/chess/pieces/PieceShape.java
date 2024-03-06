package chess.pieces;

import chess.common.Color;
import java.util.Arrays;

public enum PieceShape {
    PAWN_WHITE("♙", Pawn.class, Color.WHITE),
    PAWN_BLACK("♟", Pawn.class, Color.BLACK),
    ;

    private final String unicode;
    private final Class<? extends Pawn> pieceClass;
    private final Color color;

    PieceShape(String unicode, Class<Pawn> pieceClass, Color color) {
        this.unicode = unicode;
        this.pieceClass = pieceClass;
        this.color = color;
    }

    public String getUnicode() {
        return unicode;
    }

    public static PieceShape find(Pawn targetPiece) {
        return Arrays.stream(PieceShape.values())
                .filter(piece -> isSameType(piece, targetPiece) && isSameColor(piece, targetPiece))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없는 기물입니다."));
    }

    private static boolean isSameType(PieceShape piece, Pawn pawn) {
        return piece.pieceClass.equals(pawn.getClass());
    }

    private static boolean isSameColor(PieceShape piece, Pawn pawn) {
        return piece.color.equals(pawn.getColor());
    }
}
