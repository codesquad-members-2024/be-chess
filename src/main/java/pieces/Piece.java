package pieces;

public class Piece {
    public static final char WHITE_PAWN = 'p';
    public static final char BLACK_PAWN = 'P';

    private final PawnColor color;
    private final String name;

    public Piece(PawnColor color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public PawnColor getColor() {
        return color;
    }


    public static Piece makeWhitePawn(){
        return new Piece(PawnColor.WHITE, "pawn");
    }
    public static Piece makeBlackPawn(){
        return new Piece(PawnColor.BLACK, "pawn");
    }

    public static Piece makeWhiteKnight(){
        return new Piece(PawnColor.WHITE, "knight");
    }
    public static Piece makeBlackKnight(){
        return new Piece(PawnColor.BLACK, "knight");
    }

    public static Piece makeWhiteRook(){
        return new Piece(PawnColor.WHITE, "rook");
    }
    public static Piece makeBlackRook(){
        return new Piece(PawnColor.BLACK, "rook");
    }

    public static Piece makeWhiteBishop(){
        return new Piece(PawnColor.WHITE, "bishop");
    }
    public static Piece makeBlackBishop(){
        return new Piece(PawnColor.BLACK, "bishop");
    }

    public static Piece makeWhiteQueen(){
        return new Piece(PawnColor.WHITE, "queen");
    }
    public static Piece makeBlackQueen(){
        return new Piece(PawnColor.BLACK, "queen");
    }

    public static Piece makeWhiteKing(){
        return new Piece(PawnColor.WHITE, "king");
    }
    public static Piece makeBlacKing(){
        return new Piece(PawnColor.BLACK, "king");
    }
}
