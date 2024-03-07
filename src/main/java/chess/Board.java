package chess;

import pieces.Piece;
import pieces.PieceColor;
import pieces.PieceType;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.*;

public class Board {
    private final int BOARD_WIDTH = 8;
    private final int BOARD_HEIGHT = 8;
    private int pieceCount = 0;
    private List<Piece> whitePawns = new ArrayList<Piece>();
    private List<Piece> blackPawns = new ArrayList<Piece>();
    private List<Piece> whitePieces = new ArrayList<Piece>();
    private List<Piece> blackPieces = new ArrayList<Piece>();
    public void addPiece(Piece piece) {
        if(piece.getPieceType().equals(PieceType.PAWN)){
            if(piece.isWhite()){
                whitePawns.add(piece);
            }else{
                blackPawns.add(piece);
            }
            pieceCount++;
        }else{
            if(piece.isWhite()){
                whitePieces.add(piece);
            }else{
                blackPieces.add(piece);
            }
            pieceCount++;
        }
    }
    public int totalSize(){
        return pieceCount;
    }
    public Piece findWhitePawn(int index){
        return whitePawns.get(index);
    }
    public Piece findBlackPawn(int index){
        return blackPawns.get(index);
    }
    public void initialize(){
        //White init
        for(int i = 0; i < BOARD_WIDTH; i++) {
            addPiece(Piece.createWhitePawn());
        }
        addPiece(Piece.createWhiteRook());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteQueen());
        addPiece(Piece.createWhiteKing());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteRook());
        //Black init
        for(int i = 0; i < BOARD_WIDTH; i++) {
            addPiece(Piece.createBlackPawn());
        }
        addPiece(Piece.createBlackRook());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackQueen());
        addPiece(Piece.createBlackKing());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackRook());
    }
    private String getWhitePawnsResult() {
        return getPieceString(whitePawns);
    }
    private String getBlackPawnsResult() {
        return getPieceString(blackPawns);
    }
    private String getWhitePiecesResult() {
        return getPieceString(whitePieces);
    }
    private String getBlackPiecesResult() {
        return getPieceString(blackPieces);
    }
    private String getPieceString(List<Piece> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Piece pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }
    public String showBoard(){
        String emptyLine = "........";
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getBlackPiecesResult()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        for (int i = 0; i<4 ; i++){
            sb.append(appendNewLine(emptyLine));
        }
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(getWhitePiecesResult());
        return sb.toString();
    }
}
