package chess.pieces;

public enum Representation {

    WHITE_PAWN(Color.WHITE, "p"),
    BLACK_PAWN(Color.BLACK, "P");

    private final Color color;
    private final String representation;

    Representation(Color color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
