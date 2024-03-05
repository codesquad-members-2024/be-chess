package chess.pieces;

public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    private String color;

    public Pawn(String color) {
        this.color = color;
    }

    // 색상을 입력하지 않으면 기본적으로 화이트가 생성된다.
    public Pawn() {
        this.color = WHITE;
    }

    public String getColor() {
        return color;
    }
}

