package pieces;

public class Pawn {
    private final PieceColor teamColor;
    private final Representation pieceRepresent;
    public Pawn(PieceColor color, Representation representation){
        this.teamColor = color;
        this.pieceRepresent = representation;
    }
    public Pawn(){
        this.teamColor = PieceColor.WHITE;
        this.pieceRepresent = Representation.P;
    }
    public PieceColor getColor(){
        return teamColor;
    }
    public Representation getRepresentation(){
        return pieceRepresent;
    }
}
