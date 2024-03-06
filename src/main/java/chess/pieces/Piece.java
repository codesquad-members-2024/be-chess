package chess.pieces;

import java.util.Objects;

public class Piece {
    private final Color color;
    private final Type type;
    private final String representation;

    private Piece(Color color, Type type) {
        this.type = type;
        this.color = color;

        if(color==Color.BLACK) this.representation = String.valueOf((char)(type.getRepresentation().charAt(0)+6));
        else this.representation = type.getRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }


    public String getRepresentation() {
        return this.representation;
    }

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.BLANK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type && Objects.equals(representation, piece.representation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, representation);
    }

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN(1.0 ,"♙"){
            @Override
            public boolean verifyMovePosition(int[] now, int[] destination) {
                return Math.abs(now[0]-destination[0]) + Math.abs(now[1]-destination[1]) == 1;
                // 1칸 이동만 구현 , 이후에 대각선 공격 , 2칸 전진 추가해야함
            }
        },
        KNIGHT(2.5, "♘") {
            @Override
            public boolean verifyMovePosition(int[] now, int[] destination) {
                return Math.abs(Math.abs(now[0]-destination[0]) - Math.abs(now[1]-destination[1])) == 1;
            }
        },
        ROOK(5.0, "♖") {
            @Override
            public boolean verifyMovePosition(int[] now, int[] destination) {
                return now[0]==destination[0] || now[1]==destination[1]; // 일자 이동 가능
            }
        },
        BISHOP(3.0, "♗") {
            @Override
            public boolean verifyMovePosition(int[] now, int[] destination) {
                return Math.abs(now[0]-destination[0]) != Math.abs(now[1]-destination[1]); // 대각선 이동 가능
            }
        },
        QUEEN(9.0, "♕") {
            @Override
            public boolean verifyMovePosition(int[] now, int[] destination) {
                if(now[0]==destination[0] || now[1]==destination[1]) return true; // 일자 이동 가능
                return Math.abs(now[0]-destination[0]) != Math.abs(now[1]-destination[1]); // 대각선 이동 가능
            }
        },
        KING(0, "♔") {
            @Override
            public boolean verifyMovePosition(int[] now, int[] destination) {
                return Math.abs(now[0]-destination[0])<=1 && Math.abs(now[1]-destination[1])<=1; // 1칸씩 이동 가능
            }
        },
        BLANK(0, " ") {
            @Override
            public boolean verifyMovePosition(int[] now, int[] destination) {
                return false;
            }
        };

        private final double score;
        final String representation;

        Type(double score, String representation) {
            this.score = score;
            this.representation = representation;
        }
        public double getScore(){
            return score;
        }
        public String getRepresentation() {
            return representation;
        }

        public abstract boolean verifyMovePosition(int[] now , int[] destination);
    }
}
