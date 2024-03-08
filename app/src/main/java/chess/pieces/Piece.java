package chess.pieces;

public class Piece {
    private final String name;
    private final Color color;
    private final String representation;

    private Piece(String name, Color color){
        this.name = name;
        this.color = color;
        this.representation = Representation.of(name, color);
    }

    private Piece(){
        this.name = "empty";
        this.color = null;
        this.representation = "•";
    }

    public static Piece createWhitePawn(){
        return new Piece(Name.PAWN, Color.WHITE);
    }

    public static Piece createWhiteKnight(){
        return new Piece(Name.KNIGHT, Color.WHITE);
    }

    public static Piece createWhiteRook(){
        return new Piece(Name.ROOK, Color.WHITE);
    }

    public static Piece createWhiteBishop(){
        return new Piece(Name.BISHOP, Color.WHITE);
    }

    public static Piece createWhiteQueen(){
        return new Piece(Name.QUEEN, Color.WHITE);
    }

    public static Piece createWhiteKing(){
        return new Piece(Name.KING, Color.WHITE);
    }

    public static Piece createBlackPawn(){
        return new Piece(Name.PAWN, Color.BLACK);
    }

    public static Piece createBlackKnight(){
        return new Piece(Name.KNIGHT, Color.BLACK);
    }

    public static Piece createBlackRook(){
        return new Piece(Name.ROOK, Color.BLACK);
    }

    public static Piece createBlackBishop(){
        return new Piece(Name.BISHOP, Color.BLACK);
    }

    public static Piece createBlackQueen(){
        return new Piece(Name.QUEEN, Color.BLACK);
    }

    public static Piece createBlackKing(){
        return new Piece(Name.KING, Color.BLACK);
    }

    public static Piece createEmpty(){
        return new Piece();
    }

    public boolean isBlack(){
        return color.equals(Color.BLACK);
    }

    public boolean isWhite(){
        return color.equals(Color.WHITE);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
