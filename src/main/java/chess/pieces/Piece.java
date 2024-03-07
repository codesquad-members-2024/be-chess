package chess.pieces;

// 값 객체? 객체의 인스턴스가 아닌 그 객체가 가지고 있는 값으로 동일성 판단 , 불변
// 로직이 더 명확해지고, 오류 가능성이 줄어들고, 일관성을 유지할 수 있다.
public class Piece {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final String WHITE_PAWN_REPRESENTATION = "p";
    public static final String BLACK_PAWN_REPRESENTATION = "P";
    public static final String WHITE_KNIGHT_REPRESENTATION = "k";
    public static final String BLACK_KNIGHT_REPRESENTATION = "K";
    public static final String WHITE_ROOK_REPRESENTATION = "r";
    public static final String BLACK_ROOK_REPRESENTATION = "R";
    public static final String WHITE_BISHOP_REPRESENTATION = "b";
    public static final String BLACK_BISHOP_REPRESENTATION = "B";
    public static final String WHITE_QUEEN_REPRESENTATION = "q";
    public static final String BLACK_QUEEN_REPRESENTATION = "Q";
    public static final String WHITE_KING_REPRESENTATION = "k";
    public static final String BLACK_KING_REPRESENTATION = "K";

    private String color;

    private String representation;


    private Piece(String color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}

