package pieces;

public class Pawn {
    public static final char WHITE_PAWN = 'p';
    public static final char BLACK_PAWN = 'P';

    private final char chessPiece;
    private final PawnColor color;

    Pawn() {
        this.chessPiece = WHITE_PAWN;
        this.color = PawnColor.WHITE;
    }

    public Pawn(PawnColor color) {
        if(color == PawnColor.WHITE){
            this.chessPiece = WHITE_PAWN;
        }else{
            this.chessPiece = BLACK_PAWN;
        }
        this.color = color;
    }

    public char getChessPiece(){
        return chessPiece;
    }

    public PawnColor getColor() {
        return color;
    }
}
