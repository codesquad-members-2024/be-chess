package chess.pieces;

public class Pawn {
    private final Color color;

    public Pawn(String color){
        this.color = Color.findMatchingColor(color);
    }
    public Pawn(){
        this.color = Color.WHITE;
    }

    public String getColor() {
        return color.getColorName();
    }
}
