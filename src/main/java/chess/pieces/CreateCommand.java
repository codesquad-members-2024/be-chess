package chess.pieces;

import static chess.common.Color.*;
import static chess.pieces.Piece.*;

import chess.common.Color;
import java.util.Arrays;
import java.util.function.Function;

public enum CreateCommand {
    PAWN(color -> color.equals(WHITE) ? PieceFactory.createWhitePawn() : PieceFactory.createBlackPawn()),
    KNIGHT(color -> color.equals(WHITE) ? PieceFactory.createWhiteKnight() : PieceFactory.createBlackKnight()),
    BISHOP(color -> color.equals(WHITE) ? PieceFactory.createWhiteBishop() : PieceFactory.createBlackBishop()),
    ROOK(color -> color.equals(WHITE) ? PieceFactory.createWhiteRook() : PieceFactory.createBlackRook()),
    QUEEN(color -> color.equals(WHITE) ? PieceFactory.createWhiteQueen() : PieceFactory.createBlackQueen()),
    KING(color -> color.equals(WHITE) ? PieceFactory.createWhiteKing() : PieceFactory.createBlackKing()),
    NO_PIECE(noUsedColor -> PieceFactory.createBlank()),
    ;

    private final Function<Color, Piece> createByColor;

    CreateCommand(Function<Color, Piece> createByColor) {
        this.createByColor = createByColor;
    }

    public static Piece create(Color color, Type type) {
        return Arrays.stream(CreateCommand.values())
                .filter(command -> command.name().equals(type.name()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .createByColor.apply(color);
    }
}
