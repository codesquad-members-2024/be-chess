package pieces;

public class Piece {
    private final Color color;
    public enum Color {
        WHITE("p"), BLACK("P");
        private final String representation;

        Color(String representation) {
            this.representation = representation;
        }

        public String getRepresentation() {
            return representation;
        }
    }

    public Piece() {
        this.color = Color.WHITE;
    }

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}