package chess.pieces;

public enum PawnColor {
    WHITE('p'),
    BLACK('P');

    private final char representation;

    PawnColor(char representation) {
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }
}
