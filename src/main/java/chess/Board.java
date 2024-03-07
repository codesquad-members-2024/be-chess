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

    private void addWhitePawn(Piece piece) {
        whitePawns.add(piece);
    }

    private void addBlackPawn(Piece piece) {
        blackPawns.add(piece);
    }

    private void addWhiteNonPawnPiece(Piece piece) {
        whiteNonPawnPieces.add(piece);
    }

    private void addBlackNonPawnPiece(Piece piece) {
        blackNonPawnPieces.add(piece);
    }

    public int pieceCount() {
        return whitePawns.size() + blackPawns.size() + whiteNonPawnPieces.size() + blackNonPawnPieces.size();
    }

    // 흰색 : 룩 나이트 비숍 퀸 킹 비숍 나이트 룩
    // 흰색 폰
    // 검은색 : 룩 나이트 비숍 퀸 킹 비숍 나이트 룩
    // 검은색 폰
    public void initialize() {
        addWhiteNonPawnPiece(Piece.createWhiteRook());
        addWhiteNonPawnPiece(Piece.createWhiteKnight());
        addWhiteNonPawnPiece(Piece.createWhiteBishop());
        addWhiteNonPawnPiece(Piece.createWhiteQueen());
        addWhiteNonPawnPiece(Piece.createWhiteKing());
        addWhiteNonPawnPiece(Piece.createWhiteBishop());
        addWhiteNonPawnPiece(Piece.createWhiteKnight());
        addWhiteNonPawnPiece(Piece.createWhiteRook());

        for (int i = 0; i < DEFAULT_PAWN_COUNT; i++) {
            addWhitePawn(Piece.createWhitePawn());
        }

        for (int i = 0; i < DEFAULT_PAWN_COUNT; i++) {
            addBlackPawn(Piece.createBlackPawn());
        }

        addBlackNonPawnPiece(Piece.createBlackRook());
        addBlackNonPawnPiece(Piece.createBlackKnight());
        addBlackNonPawnPiece(Piece.createBlackBishop());
        addBlackNonPawnPiece(Piece.createBlackQueen());
        addBlackNonPawnPiece(Piece.createBlackKing());
        addBlackNonPawnPiece(Piece.createBlackBishop());
        addBlackNonPawnPiece(Piece.createBlackKnight());
        addBlackNonPawnPiece(Piece.createBlackRook());
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

    private String getPieceResult(List<Piece> pieces) {
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
