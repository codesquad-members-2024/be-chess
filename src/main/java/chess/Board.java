package chess;

import pieces.Piece;


import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {

    private final List<Piece> whitePawns;
    private final List<Piece> blackPawns;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;
    private static final int MAX_INDEX = 8;
    private static final int MIN_INDEX = 0;

    public Board() {
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        whitePawns = new ArrayList<>();
        blackPawns = new ArrayList<>();
    }

    int size() {
        return whitePieces.size() + blackPieces.size();
    }

    public void initialize() {
        whitePieceInitialize();
        blackPieceInitialize();
    }

    public String getResultToPrint() {
        String blankRank = appendNewLine("........");
        StringBuilder result = new StringBuilder();
        result.append(appendNewLine(getBlackPieceResult()))
                .append(appendNewLine(getBlackPawnResult()))
                .append(blankRank)
                .append(blankRank)
                .append(blankRank)
                .append(blankRank)
                .append(appendNewLine(getWhitePawnResult()))
                .append(appendNewLine(getWhitePieceResult()));
        return result.toString();
    }


    private void whitePieceInitialize() {
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            addWhitePawn(Piece.createWhitePawn());
        }
        addPiece(Piece.createWhiteRook());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteQueen());
        addPiece(Piece.createWhiteKing());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteRook());
    }

    private void blackPieceInitialize() {
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            addBlackPawn(Piece.createBlackPawn());
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

    private String getWhitePieceResult() {
        return getPiecesToPrint(whitePieces);
    }

    private String getBlackPieceResult() {
        return getPiecesToPrint(blackPieces);
    }

    private String getWhitePawnResult() {
        return getPiecesToPrint(whitePawns);
    }

    private String getBlackPawnResult() {
        return getPiecesToPrint(blackPawns);
    }

    private String getPiecesToPrint(List<Piece> pieces) {
        StringBuilder piecesToPrint = new StringBuilder();
        for (Piece piece : pieces) {
            piecesToPrint.append(piece.getRepresentation());
        }
        return piecesToPrint.toString();
    }


    private List<Piece> getPiecesByColor(Piece piece) {
        if (piece.isWhite()) {
            return whitePieces;
        }
        return blackPieces;
    }

    private void addWhitePawn(Piece pawn) {
        whitePawns.add(pawn);
    }

    private void addBlackPawn(Piece pawn) {
        blackPawns.add(pawn);
    }

    private void addPiece(Piece piece) {
        getPiecesByColor(piece).add(piece);
    }
}
