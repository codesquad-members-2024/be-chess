package pieces;

public class Piece {
    public static final char WHITE_PAWN = 'p';
    public static final char BLACK_PAWN = 'P';

    private final PieceColor color;
    private final PieceName name;
    private final char pieceRepresentation;


    public Piece(PieceColor color, PieceName name) {
        this.color = color;
        this.name = name;
        if(color == PieceColor.WHITE){
            pieceRepresentation = name.getColorPiece(PieceColor.WHITE);
        }else{
            pieceRepresentation = name.getColorPiece(PieceColor.BLACK);
        }
    }

    public PieceColor getColor() {
        return color;
    }

    public char getPieceRepresentation(){
        return pieceRepresentation;
    }


    public static Piece makeWhitePawn(){
        return new Piece(PieceColor.WHITE, PieceName.PAWN);
    }
    public static Piece makeBlackPawn(){
        return new Piece(PieceColor.BLACK, PieceName.PAWN);
    }

    public static Piece makeWhiteKnight(){
        return new Piece(PieceColor.WHITE, PieceName.KNIGHT);
    }
    public static Piece makeBlackKnight(){
        return new Piece(PieceColor.BLACK, PieceName.KNIGHT);
    }

    public static Piece makeWhiteRook(){
        return new Piece(PieceColor.WHITE, PieceName.ROOK);
    }
    public static Piece makeBlackRook(){
        return new Piece(PieceColor.BLACK, PieceName.ROOK);
    }

    public static Piece makeWhiteBishop(){
        return new Piece(PieceColor.WHITE, PieceName.BISHOP);
    }
    public static Piece makeBlackBishop(){
        return new Piece(PieceColor.BLACK, PieceName.BISHOP);
    }

    public static Piece makeWhiteQueen(){
        return new Piece(PieceColor.WHITE, PieceName.QUEEN);
    }
    public static Piece makeBlackQueen(){
        return new Piece(PieceColor.BLACK, PieceName.QUEEN);
    }

    public static Piece makeWhiteKing(){
        return new Piece(PieceColor.WHITE, PieceName.KING);
    }
    public static Piece makeBlackKing(){
        return new Piece(PieceColor.BLACK, PieceName.KING);
    }
}
