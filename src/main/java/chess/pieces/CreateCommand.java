package chess.pieces;

import static chess.common.Color.*;
import static chess.pieces.Piece.*;

import chess.common.Color;
import java.util.Arrays;
import java.util.function.Function;

public enum CreateCommand {
    PAWN(color -> color.equals(WHITE) ? createWhitePawn() : createBlackPawn()),
    KNIGHT(color -> color.equals(WHITE) ? createWhiteKnight() : createBlackKnight()),
    BISHOP(color -> color.equals(WHITE) ? createWhiteBishop() : createBlackBishop()),
    ROOK(color -> color.equals(WHITE) ? createWhiteRook() : createBlackRook()),
    QUEEN(color -> color.equals(WHITE) ? createWhiteQueen() : createBlackQueen()),
    KING(color -> color.equals(WHITE) ? createWhiteKing() : createBlackKing()),
    NO_PIECE(noUsedColor -> createBlank()),
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

    private static boolean isAllowedName(String requestName, CreateCommand commandName) {
        return commandName.name().toLowerCase().equals(requestName);
    }
}
