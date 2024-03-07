package chess.pieces;

public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final String WHITE_REPRESENTATION = "p";
    public static final String BLACK_REPRESENTATION = "P";
    private String color;
    private String representation;


    public Pawn(String color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    // 색상을 입력하지 않으면 기본적으로 화이트가 생성된다.
    public Pawn() {
        this.color = WHITE;
        this.representation = WHITE_REPRESENTATION;
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}

