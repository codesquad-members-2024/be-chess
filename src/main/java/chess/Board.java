package chess;

import static chess.utils.StringUtils.appendNewLine;

import chess.pieces.Piece;
import java.util.ArrayList;

public class Board {
    private static final int COL_NUMS = 8;
    private static final String BLANKS = "•".repeat(COL_NUMS);
    ArrayList<Piece> whitePieces;
    ArrayList<Piece> blackPieces;
    ArrayList<Piece> whitePawns;
    ArrayList<Piece> blackPawns;
    private int pieceCount;

    public Board() {
        pieceCount = 0;
        whitePieces = new ArrayList<Piece>();
        blackPieces = new ArrayList<Piece>();
        whitePawns = new ArrayList<Piece>();
        blackPawns = new ArrayList<Piece>();
    }

    public void start() {
        initialize();
        print();
    }

    public void end() {
        System.out.println("게임 종료");
    }

    void initialize() {
        for (int i = 0; i < 8; i++) {
            whitePawns.add(Piece.createWhitePawn());
            blackPawns.add(Piece.createBlackPawn());
        } // 16개
        pieceCount += 16;
        createWhitePieces(); //8개
        createBlackPieces(); //8개
    }

    private void createWhitePieces() {
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());
        pieceCount += 8;
    }

    private void createBlackPieces() {
        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());
        pieceCount += 8;
    }

    public void print() {
        // 현재 체스판의 결과를 출력
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(BLANKS));
        sb.append(appendNewLine(getPieceResult(blackPawns)));
        for (int i = 0; i < 4; i++) {
            sb.append(appendNewLine(BLANKS));
        }
        sb.append(appendNewLine(getPieceResult(whitePawns)));
        sb.append(appendNewLine(BLANKS));
        System.out.println(sb);
    }

    public String getPieceResult(ArrayList<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        pieces.stream().map(Piece::getRepresentation).forEach(sb::append);
        return sb.toString();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getPieceResult(blackPieces)));
        sb.append(appendNewLine(getPieceResult(blackPawns)));
        for (int i = 0; i < 4; i++) {
            sb.append(appendNewLine(BLANKS));
        }
        sb.append(appendNewLine(getPieceResult(whitePawns)));
        sb.append(appendNewLine(getPieceResult(whitePieces)));
        return sb.toString();
    }

    public void add(Piece piece) {
        if (piece.getColor().equals(Piece.WHITE_COLOR)) {
            whitePawns.add(piece);
        } else if (piece.getColor().equals(Piece.BLACK_COLOR)) {
            blackPawns.add(piece);
        }
        pieceCount++;
    }

    public Piece findWhitePawn(int i) {
        return whitePawns.get(i);
    }

    public Piece findBlackPawn(int i) {
        return blackPawns.get(i);
    }

    public ArrayList<Piece> getWhitePieces() {
        return whitePieces;
    }

    public ArrayList<Piece> getBlackPieces() {
        return blackPieces;
    }

    public ArrayList<Piece> getWhitePawns() {
        return whitePawns;
    }

    public ArrayList<Piece> getBlackPawns() {
        return blackPawns;
    }

    public int getPieceCount() {
        return pieceCount;
    }
}