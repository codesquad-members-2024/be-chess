package chess.pieces;

public class Pawn {
    public enum Color {
        WHITE("p") , BLACK("P");
        private final String representation;

        Color(String representation) {
            this.representation = representation;
        }
    }
    private final Color color;
    public Pawn(Color color) {
        this.color = color;
    }

    public Pawn(){
        this.color = Color.WHITE;
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation(){
        return this.color.representation;
    }
}
