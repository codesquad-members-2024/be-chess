package pieces;

public class Pawn {

    public enum Color {
        BLACK('P'), WHITE('p');

        private final char symbol;

        Color(char symbol) {
            this.symbol = symbol;
        }
    }

    private final Color color;

    public Pawn(Color color) {
        this.color = color;
    }

    public Pawn() {
        this.color = Color.WHITE;
    }

    public Color getColor() {
        return color;
    }

    public char getSymbol() {
        return color.symbol;
    }

}
