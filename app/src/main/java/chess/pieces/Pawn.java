package chess.pieces;

public class Pawn {
    private final Color color;
    private final String representation;

    public Pawn(String color){
        this.color = Color.findMatchingColor(color);
        this.representation = Representation.PAWN.inColor(this.color);
    }
    public Pawn(){
        this.color = Color.WHITE;
        this.representation = Representation.PAWN.inColor(Color.WHITE);
    }

    public String getColor() {
        return color.getColorName();
    }

    public String getRepresentation() {
        return representation;
    }
}
