package chess.pieces;

public enum Representation {

    WHITE_PAWN("p"),
    BLACK_PAWN("P");

    private final String representation;

    Representation(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}
