package pieces;

public class Piece {
    public static final char WHITE_PAWN = 'p';
    public static final char BLACK_PAWN = 'P';

    private final PieceColor color;
    private final String name;

    public Piece(PieceColor color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public PieceColor getColor() {
        return color;
    }


    public static Piece makeWhitePawn(){
        return new Piece(PieceColor.WHITE, "pawn");
    }
    public static Piece makeBlackPawn(){
        return new Piece(PieceColor.BLACK, "pawn");
    }

    public static Piece makeWhiteKnight(){
        return new Piece(PieceColor.WHITE, "knight");
    }
    public static Piece makeBlackKnight(){
        return new Piece(PieceColor.BLACK, "knight");
    }

    public static Piece makeWhiteRook(){
        return new Piece(PieceColor.WHITE, "rook");
    }
    public static Piece makeBlackRook(){
        return new Piece(PieceColor.BLACK, "rook");
    }

    public static Piece makeWhiteBishop(){
        return new Piece(PieceColor.WHITE, "bishop");
    }
    public static Piece makeBlackBishop(){
        return new Piece(PieceColor.BLACK, "bishop");
    }

    public static Piece makeWhiteQueen(){
        return new Piece(PieceColor.WHITE, "queen");
    }
    public static Piece makeBlackQueen(){
        return new Piece(PieceColor.BLACK, "queen");
    }

    public static Piece makeWhiteKing(){
        return new Piece(PieceColor.WHITE, "king");
    }
    public static Piece makeBlacKing(){
        return new Piece(PieceColor.BLACK, "king");
    }
}
