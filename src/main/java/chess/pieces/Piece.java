package chess.pieces;

public class Piece {
    private final Name name;
    private final Color color;
    private final Representation representation;

    private Piece(Name name, Color color, Representation representation) {
        this.name = name;
        this.color = color;
        this.representation = representation;
    }

    public static Piece createPiece(Name name, Color color) {
        return new Piece(name, color, Representation.of(name, color));
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public Name getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Representation getRepresentation() {
        return representation;
    }
}
