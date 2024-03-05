package pieces;
import pieces.Pawn.Color;


public class Validator {
    public static Pawn.Color isColor(Color color) {
        if (color != Pawn.Color.BLACK && color != Pawn.Color.WHITE) {
            throw new IllegalArgumentException("WHITE 와 BLACK 만 작성 가능합니다.");
        }
        return color;
    }
}
