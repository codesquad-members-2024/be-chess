package chess;

import pieces.Piece;
import pieces.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int CHESSBOARD_MAX_LENGTH = 8;
    public static final int WHITE_PAWN_START_ROW = 1;
    public static final int BLACK_PAWN_START_ROW = 6;

    private List<Piece> pieces;
    private Piece[][] chessboard;

    Board(){
        pieces = new ArrayList<Piece>();
        chessboard = new Piece[CHESSBOARD_MAX_LENGTH][CHESSBOARD_MAX_LENGTH];
    }

    public void initialize(){
        initializePawn(PieceColor.WHITE);
        initializePawn(PieceColor.BLACK);
    }

    public void initializePawn(PieceColor color){ // 매개변수로 받은 색의 pawn 위치 초기화
        int initRow = WHITE_PAWN_START_ROW; // pawn을 추가할 row, 기본으로 white일때 위치
        if(color == PieceColor.BLACK){
            initRow = BLACK_PAWN_START_ROW;
        }

        for(int i=0; i<CHESSBOARD_MAX_LENGTH; i++){
            Piece piece = new Piece(color);
            add(piece);
            chessboard[initRow][i] = piece;
        }
    }

    public String print(){ // chessboard 상태 string 으로 변환 후 반환
        StringBuilder stringBuilder = new StringBuilder(); // chessboard 상태 출력 위해
        for(int i=0; i<CHESSBOARD_MAX_LENGTH; i++){
            for(int j=0; j<CHESSBOARD_MAX_LENGTH; j++){
                stringBuilder.append(getPawnStatus(chessboard[i][j]));
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public char getPawnStatus(Piece piece){
        if(piece == null){
            return '.';
        }
        return piece.getChessPiece();
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public Piece findPawn(int index) {
        return pieces.get(index);
    }

    public String getWhitePawnsResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<CHESSBOARD_MAX_LENGTH; i++) {
            stringBuilder.append(getPawnStatus(chessboard[WHITE_PAWN_START_ROW][i]));
        }
        return stringBuilder.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<CHESSBOARD_MAX_LENGTH; i++) {
            stringBuilder.append(getPawnStatus(chessboard[BLACK_PAWN_START_ROW][i]));
        }
        return stringBuilder.toString();
    }
}
