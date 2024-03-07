package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whiteNonPawnPieces = new ArrayList<>();
    private List<Piece> blackNonPawnPieces = new ArrayList<>();
    public static final int DEFAULT_PAWN_COUNT = 8;

    private void addPiece(final Piece piece, final List<Piece> pieces){
        pieces.add(piece);
    }

    // 흰색 : 룩 나이트 비숍 퀸 킹 비숍 나이트 룩
    // 흰색 폰
    // 검은색 : 룩 나이트 비숍 퀸 킹 비숍 나이트 룩
    // 검은색 폰
    public void initialize() {
        addPiece(Piece.createWhiteRook(), whiteNonPawnPieces);
        addPiece(Piece.createWhiteKnight(), whiteNonPawnPieces);
        addPiece(Piece.createWhiteBishop(), whiteNonPawnPieces);
        addPiece(Piece.createWhiteQueen(), whiteNonPawnPieces);
        addPiece(Piece.createWhiteKing(), whiteNonPawnPieces);
        addPiece(Piece.createWhiteBishop(), whiteNonPawnPieces);
        addPiece(Piece.createWhiteKnight(), whiteNonPawnPieces);
        addPiece(Piece.createWhiteRook(), whiteNonPawnPieces);

        for (int i = 0; i < DEFAULT_PAWN_COUNT; i++) {
            addPiece(Piece.createWhitePawn(), whitePawns);
        }

        for (int i = 0; i < DEFAULT_PAWN_COUNT; i++) {
            addPiece(Piece.createBlackPawn(), blackPawns);
        }

        addPiece(Piece.createBlackRook(), blackNonPawnPieces);
        addPiece(Piece.createBlackKnight(), blackNonPawnPieces);
        addPiece(Piece.createBlackBishop(), blackNonPawnPieces);
        addPiece(Piece.createBlackQueen(), blackNonPawnPieces);
        addPiece(Piece.createBlackKing(), blackNonPawnPieces);
        addPiece(Piece.createBlackBishop(), blackNonPawnPieces);
        addPiece(Piece.createBlackKnight(), blackNonPawnPieces);
        addPiece(Piece.createBlackRook(), blackNonPawnPieces);
    }

    public int getTotalPieceCount() {
        return whitePawns.size() + blackPawns.size() + whiteNonPawnPieces.size() + blackNonPawnPieces.size();
    }

    public String getWhiteNonPawnPieceResult() {
        return getPieceResult(whiteNonPawnPieces);
    }

    public String getBlackNonPawnPieceResult() {
        return getPieceResult(blackNonPawnPieces);
    }

    public String getWhitePawnResult() {
        return getPieceResult(whitePawns);
    }

    public String getBlackPawnResult() {
        return getPieceResult(blackPawns);
    }

    private String getPieceResult(List<Piece> pieces) { // whitePawns, blackPawns, whiteNonPawnPieces, blackNonPawnPieces . . .
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        String blankRank = appendNewLine("........");

        sb.append(appendNewLine(getBlackNonPawnPieceResult()));
        sb.append(appendNewLine(getBlackPawnResult()));
        sb.append(blankRank);
        sb.append(blankRank);
        sb.append(blankRank);
        sb.append(blankRank);
        sb.append(appendNewLine(getWhitePawnResult()));
        sb.append(appendNewLine(getWhiteNonPawnPieceResult()));

        return sb.toString();
    }
}
