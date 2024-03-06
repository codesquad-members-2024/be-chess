package pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String WHITE_SYMBOL = PieceSymbol.WHITE_PAWN.getSymbol();
    public static final String BLACK_SYMBOL = PieceSymbol.BLACK_PAWN.getSymbol();

    private final String color;
    private final String symbol;

    public Pawn() {
        this.color = WHITE_COLOR;
        this.symbol = WHITE_SYMBOL;
    }

    public Pawn(String color, String symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }
}
