package pieces;

import static pieces.PieceColor.*;
//import static pieces.Piece.PieceColor.*;
import static pieces.PieceType.*;

public class Piece {
    private final PieceColor teamColor;
    private final PieceType pieceType;
    private Piece(PieceColor color, PieceType pieceType){
        this.teamColor = color;
        this.pieceType = pieceType;
    }
    public PieceColor getColor(){
        return teamColor;
    }
    public PieceType getPieceType(){return pieceType;}
    public boolean isWhite(){
        return teamColor.equals(WHITE);
    }
    public char getRepresentation(){
        if (isWhite()){
            return pieceType.getWhiteRepresentation();
        }else {
            return pieceType.getBlackRepresentation();
        }
    }
    // 팩토리 메서드
    public static Piece createWhitePawn() {
        return new Piece(WHITE, PAWN);
    }
    public static Piece createBlackPawn() {
        return new Piece(BLACK, PAWN);
    }
    public static Piece createWhiteKnight() {
        return new Piece(WHITE, KNIGHT);
    }
    public static Piece createBlackKnight() {
        return new Piece(BLACK, KNIGHT);
    }
    public static Piece createWhiteRook() {
        return new Piece(WHITE, ROOK);
    }
    public static Piece createBlackRook() {
        return new Piece(BLACK, ROOK);
    }
    public static Piece createWhiteBishop() {
        return new Piece(WHITE, BISHOP);
    }
    public static Piece createBlackBishop() {
        return new Piece(BLACK, BISHOP);
    }
    public static Piece createWhiteQueen() {
        return new Piece(WHITE, QUEEN);
    }
    public static Piece createBlackQueen() {
        return new Piece(BLACK, QUEEN);
    }
    public static Piece createWhiteKing() {
        return new Piece(WHITE, KING);
    }
    public static Piece createBlackKing() {
        return new Piece(BLACK, KING);
    }
}
