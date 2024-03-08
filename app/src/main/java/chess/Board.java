package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import utils.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToLongFunction;

public class Board {
    private List<List<Piece>> chessBoard;
    private List<Piece> pieces;
    private final int CHESS_BOARD_START_INDEX = 0;
    private final int CHESS_BOARD_END_INDEX = 8;

    public Board(){
        this.chessBoard = new ArrayList<>();
        this.pieces = new ArrayList<>();
    }

    public void initialize(){
        final int BLACK_RNBQKBNR_RANK = 0;
        final int BLACK_PAWN_RANK = 1;
        final int WHITE_PAWN_RANK = 6;
        final int WHITE_RNBQKBNR_RANK = 7;

        for (int i = CHESS_BOARD_START_INDEX; i < CHESS_BOARD_END_INDEX; i++){
            switch (i) {
                case BLACK_RNBQKBNR_RANK :
                    addBlackRNBQKBNRRank();
                    break;
                case BLACK_PAWN_RANK:
                    addPawnRank(Color.BLACK);
                    break;
                case WHITE_PAWN_RANK:
                    addPawnRank(Color.WHITE);
                    break;
                case WHITE_RNBQKBNR_RANK:
                    addWhiteRNBQKBNRRank();
                    break;
                default:
                    addEmptyRank();
            }}
    }

    private void addBlackRNBQKBNRRank(){
            chessBoard.add(Arrays.asList(
                    Piece.createBlackRook(),
                    Piece.createBlackKnight(),
                    Piece.createBlackBishop(),
                    Piece.createBlackQueen(),
                    Piece.createBlackKing(),
                    Piece.createBlackBishop(),
                    Piece.createBlackKnight(),
                    Piece.createBlackRook())
            );
        }

    private void addWhiteRNBQKBNRRank(){
            chessBoard.add(Arrays.asList(
                    Piece.createWhiteRook(),
                    Piece.createWhiteKnight(),
                    Piece.createWhiteBishop(),
                    Piece.createWhiteQueen(),
                    Piece.createWhiteKing(),
                    Piece.createWhiteBishop(),
                    Piece.createWhiteKnight(),
                    Piece.createWhiteRook())
            );
        }

    private void addPawnRank(Color color){
        List<Piece> pawnRank = new ArrayList<>();
        for (int i = CHESS_BOARD_START_INDEX; i < CHESS_BOARD_END_INDEX; i++){
            if (color.equals(Color.BLACK)){
                pawnRank.add(Piece.createBlackPawn());
            } else {
                pawnRank.add(Piece.createWhitePawn());
            }
        }
        chessBoard.add(pawnRank);
    }

    private void addEmptyRank(){
        List<Piece> emptyRank = new ArrayList<>();
        for (int i = CHESS_BOARD_START_INDEX; i < CHESS_BOARD_END_INDEX; i++){
            emptyRank.add(Piece.createEmpty());
        }
        chessBoard.add(emptyRank);
    }

    public String showBoard(){
        StringBuilder builder = new StringBuilder();
        chessBoard.forEach(row -> {
            String gatheredRep = String.join("", representationConversion.apply(row));
            builder.append(StringUtils.appendNewLine(gatheredRep));
        });
        return builder.toString();
    }

    private final Function<List<Piece>, List<String>> representationConversion =
            (pawnRank) -> pawnRank.stream()
                .map(Piece::getRepresentation)
                .toList();

    public void addPiece(Piece piece){
        pieces.add(piece);
    }

    public long pieceCount() {
        return chessBoard.stream().mapToLong(countNonEmptyPiece).sum();
    }

    private final ToLongFunction<List<Piece>> countNonEmptyPiece =
            rank -> rank.stream()
                    .filter(piece -> !piece.getName().equals("empty"))
                    .count();
}
