package chess.pieces;

public class Pawn {
    private ChessPieceColor color;

    public Pawn(String color){
        this.color = ChessPieceColor.findMatchingColor(color);
    }
    public Pawn(){
        this.color = ChessPieceColor.WHITE;
    }

    public String getColor() {
        return color.getColorName();
    }
}
