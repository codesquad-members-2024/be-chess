package pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    public static final char WHITE_REPRESENTATION = '\u2659';
    public static final char BLACK_REPRESENTATION = '\u265F';

    private String color;
    private char representation;
    public Pawn() {
        color = WHITE_COLOR;
        representation = (WHITE_REPRESENTATION);
    }

    public Pawn(String color) {
        this.color = color;
    }

    public Pawn(String color, char representation) {
        this(color);
        if(color.equals("white")) {
            this.representation = WHITE_REPRESENTATION;
        } else if (color.equals("black")) {
            this.representation = BLACK_REPRESENTATION;
        } else {
            throw new IllegalArgumentException("색이 없습니다.");
        }
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
