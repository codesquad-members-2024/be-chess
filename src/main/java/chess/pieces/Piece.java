package chess.pieces;

public class Piece {
    public enum Color {
        WHITE, BLACK;
    }

    public enum Name {
        PAWN(), KNIGHT(), ROOK(), BISHOP(), QUEEN(), KING();
    }

    public enum represent {
        WHITE_PAWN_REPRESENTATION("p"),
        BLACK_PAWN_REPRESENTATION("P"),
        WHITE_KNIGHT_REPRESENTATION("n"),
        BLACK_KNIGHT_REPRESENTATION("N"),
        WHITE_BISHOP_REPRESENTATION("b"),
        BLACK_BISHOP_REPRESENTATION("B"),
        WHITE_ROOK_REPRESENTATION("r"),
        BLACK_ROOK_REPRESENTATION("R"),
        WHITE_QUEEN_REPRESENTATION("q"),
        BLACK_QUEEN_REPRESENTATION("Q"),
        WHITE_KING_REPRESENTATION("k"),
        BLACK_KING_REPRESENTATION("K");
        final String value;

        represent(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private final Color color;
    private final Name name;
    private final String representation;

    private Piece(Color color, Name name) {
        this.name = name;
        this.color = color;
        this.representation =
                represent.valueOf(color.toString() + "_" + name.toString() + "_" + "REPRESENTATION").value;
    }

    public Color getColor() {
        return color;
    }

    public boolean isBlack(){ return color==Color.BLACK;}
    public boolean isWhite(){ return color==Color.WHITE;}


    public String getRepresentation() {
        return this.representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Name.PAWN);
    }

    public static Piece createBlackPawn() { return new Piece(Color.BLACK, Name.PAWN); }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Name.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Name.KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Name.BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Name.BISHOP);
    }

    public static Piece createWhiteRook() { return new Piece(Color.WHITE, Name.ROOK); }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Name.ROOK);
    }

    public static Piece createWhiteQueen() { return new Piece(Color.WHITE, Name.QUEEN); }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Name.QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Name.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Name.KING);
    }


}
