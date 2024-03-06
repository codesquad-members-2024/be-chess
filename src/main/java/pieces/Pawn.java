package pieces;

public class Pawn {
    private final PawnColor color;

    Pawn() {
        this.color = PawnColor.WHITE;
    }

    public Pawn(PawnColor color) {
        this.color = color;
    }

    public PawnColor getColor() {
        return color;
    }
}
