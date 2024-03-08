package chess;

import pieces.Piece;
import pieces.PieceColor;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board {
    public static final int CHESSBOARD_MAX_LENGTH = 8;
    public static final int WHITE_PAWN_START_ROW = 1;
    public static final int WHITE_OTHER_START_ROW = 0;
    public static final int BLACK_PAWN_START_ROW = 6;
    public static final int BLACK_OTHER_START_ROW = 7;

    //private List<Piece> pieces;
    private List<List<Piece>> chessboard;

    Board(){
        //pieces = new ArrayList<Piece>();
        chessboard = new ArrayList<>();
        IntStream.range(0, 8)
                .forEach(i -> chessboard.add(new ArrayList<>()));
    }

    public void initialize(){
        initializePiece(PieceColor.WHITE);
        initializePiece(PieceColor.BLACK);
        initializeEmpty(2);
        initializeEmpty(3);
        initializeEmpty(4);
        initializeEmpty(5);
    }

    public void initializePiece(PieceColor color){ // 매개변수로 받은 색의 Piece 위치 초기화
        int pawnRow = WHITE_PAWN_START_ROW; // 기본으로 white 일때 위치
        int otherRow = WHITE_OTHER_START_ROW; // 기본으로 white 일때 위치
        if(color == PieceColor.BLACK){
            pawnRow = BLACK_PAWN_START_ROW;
            otherRow = BLACK_OTHER_START_ROW;
        }

        initializePawn(pawnRow, color);
        initializeOther(otherRow, color);
    }

    public void initializePawn(int row, PieceColor color){
        List<Piece> pawnRow;
        if(color == PieceColor.WHITE){
            pawnRow = IntStream.range(0, 8)
                    .mapToObj(i -> Piece.makeWhitePawn())
                    .toList();
        }else{
            pawnRow = IntStream.range(0, 8)
                    .mapToObj(i -> Piece.makeWhitePawn())
                    .toList();
        }
        chessboard.set(row, pawnRow);
    }

    public void initializeOther(int row, PieceColor color){
        List<Piece> otherRow = new ArrayList<>();
        if(color == PieceColor.WHITE){
            otherRow.add(Piece.makeWhiteRook());
            otherRow.add(Piece.makeWhiteKnight());
            otherRow.add(Piece.makeWhiteBishop());
            otherRow.add(Piece.makeWhiteQueen());
            otherRow.add(Piece.makeWhiteKing());
            otherRow.add(Piece.makeWhiteBishop());
            otherRow.add(Piece.makeWhiteKnight());
            otherRow.add(Piece.makeWhiteRook());
        }else{
            otherRow.add(Piece.makeBlackRook());
            otherRow.add(Piece.makeBlackKnight());
            otherRow.add(Piece.makeBlackBishop());
            otherRow.add(Piece.makeBlackQueen());
            otherRow.add(Piece.makeBlackKing());
            otherRow.add(Piece.makeBlackBishop());
            otherRow.add(Piece.makeBlackKnight());
            otherRow.add(Piece.makeBlackRook());
        }
        chessboard.set(row, otherRow);
    }

    public void initializeEmpty(int row){
        List<Piece> enmptyRow = IntStream.range(0, 8)
                .mapToObj(i -> (Piece)null)
                .toList();
        chessboard.set(row, enmptyRow);
    }


    public String print(){ // chessboard 상태 string 으로 변환 후 반환
        StringBuilder stringBuilder = new StringBuilder(); // chessboard 상태 출력 위해
        for(List<Piece> row : chessboard) {
            for(Piece piece : row) {
                stringBuilder.append(getPieceFigure(piece));
            }
            stringBuilder.append(StringUtils.getNewLine());
        }
        return stringBuilder.toString();
    }

    public char getPieceFigure(Piece piece){
        if(piece == null){
            return '.';
        }
        return piece.getPieceRepresentation();
    }

}
