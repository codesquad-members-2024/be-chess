package chess.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';
    public String name; // 종류: pawn, knight, rook, bishop, queen, king
    public String color;
    public char representation;

    private Piece(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // 정적 팩토리 메서드
    public static Piece of(String name, String color) {
        return new Piece(name, color);
    }

    public static Piece creaeteWhitePawn() {
        return new Piece("white", "pawn");
    }

    public static Piece creaeteBlackPawn() {
        return new Piece("black", "pawn");
    }

    public Piece(final String color) {
        this.color = color;
        if (color.equals(WHITE_COLOR)) {
            this.representation = WHITE_REPRESENTATION;
        } else if (color.equals(BLACK_COLOR)) {
            this.representation = BLACK_REPRESENTATION;
        }
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
