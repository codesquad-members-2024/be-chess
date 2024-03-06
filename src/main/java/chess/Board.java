package chess;

import static utils.StringUtils.NEWLINE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;
import utils.Position;

public class Board {
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;
    private final List<Rank> board;

    public Board() {
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        board = new ArrayList<>(8);
    }

    public void addPieces(Color color, List<Piece> piece) {
        if (color.equals(Color.WHITE)) {
            whitePieces.addAll(piece);
            return;
        }
        blackPieces.addAll(piece);
    }

    public void initialize() {
        initializeExceptPawns(Color.BLACK);
        initializePawns(Color.BLACK);
        IntStream.range(0, 4).forEach(i -> initializeBlank());
        initializePawns(Color.WHITE);
        initializeExceptPawns(Color.WHITE);
    }

    private void initializeBlank() {
        List<Piece> blanks = new ArrayList<>();
        IntStream.range(0, 8).forEach(i -> blanks.add(Piece.createBlank()));
        board.add(new Rank(blanks));
    }

    private void initializePawns(Color color) {
        List<Piece> pawns = new ArrayList<>();
        IntStream.range(0, 8).forEach(i -> pawns.add(generatePawn(color)));
        addPieces(color, pawns);
        board.add(new Rank(pawns));
    }

    private Piece generatePawn(Color color) {
        if (color.equals(Color.WHITE)) {
            return Piece.createWhitePawn();
        }
        return Piece.createBlackPawn();
    }

    private void initializeExceptPawns(Color color) {
        List<Piece> piecesExceptPawns = generatePiecesExceptPawns(color);
        addPieces(color, piecesExceptPawns);
        board.add(new Rank(piecesExceptPawns));
    }

    private ArrayList<Piece> generatePiecesExceptPawns(Color color) {
        ArrayList<Piece> piecesExceptPawns = new ArrayList<>();
        if (color.equals(Color.WHITE)) {
            piecesExceptPawns.add(Piece.createWhiteRook());
            piecesExceptPawns.add(Piece.createWhiteKnight());
            piecesExceptPawns.add(Piece.createWhiteBishop());
            piecesExceptPawns.add(Piece.createWhiteQueen());
            piecesExceptPawns.add(Piece.createWhiteKing());
            piecesExceptPawns.add(Piece.createWhiteBishop());
            piecesExceptPawns.add(Piece.createWhiteKnight());
            piecesExceptPawns.add(Piece.createWhiteRook());
        } else if (color.equals(Color.BLACK)) {
            piecesExceptPawns.add(Piece.createBlackRook());
            piecesExceptPawns.add(Piece.createBlackKnight());
            piecesExceptPawns.add(Piece.createBlackBishop());
            piecesExceptPawns.add(Piece.createBlackQueen());
            piecesExceptPawns.add(Piece.createBlackKing());
            piecesExceptPawns.add(Piece.createBlackBishop());
            piecesExceptPawns.add(Piece.createBlackKnight());
            piecesExceptPawns.add(Piece.createBlackRook());
        }
        return piecesExceptPawns;
    }

    public void initializeEmpty() {
        whitePieces.clear();
        blackPieces.clear();
        board.clear();
        IntStream.range(0, 8).forEach(i -> initializeBlank());
    }

    public int pieceCount() {
        return whitePieces.size() + blackPieces.size();
    }

    public String showBoard() {
        return IntStream.range(0, 8)
                .mapToObj(row -> IntStream.range(0, 8)
                        .mapToObj(col -> getSymbol(board.get(row).getPiece(col)))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(NEWLINE)).concat(NEWLINE);
    }

    private String getSymbol(Piece piece) {
        if (piece.isWhite()) {
            return piece.getPieceSymbol().getSymbol();
        } else if (piece.isBlack()) {
            return Piece.convertToBlackPiece(piece.getPieceSymbol().getSymbol());
        }
        return piece.getPieceSymbol().getSymbol();
    }

    public int getPieceCount(Color color, PieceSymbol pieceSymbol) {
        return (int) board.stream().flatMap(rank -> rank.getPieces().stream())
                .filter(piece -> piece.equalsPiece(color, pieceSymbol))
                .count();
    }

    public Piece findPiece(String position) {
        Position pos = new Position(position);
        return board.get(pos.getRow()).getPiece(pos.getCol());
    }

    public void move(String position, Piece piece) {
        Position pos = new Position(position);
        whitePieces.remove(piece);
        blackPieces.remove(piece);
        board.get(pos.getRow()).getPieces().set(pos.getCol(), piece);
    }

    public double calculatePoint(Color color) {
        return board.stream()
                .flatMap(rank -> rank.getPieces().stream())
                .filter(piece -> piece.matchColor(color))
                .mapToDouble(piece -> getPawnPoint(color, piece))
                .sum();
    }

    private double getPawnPoint(Color color, Piece piece) {
        double defaultPoint = piece.getPieceSymbol().getDefaultPoint();
        if (hasSameVerticalPawns(color) && piece.equalsPawn(color)) {
            return defaultPoint / 2.0;
        }
        return defaultPoint;
    }

    public boolean hasSameVerticalPawns(Color color) {
        Set<Integer> cols = new HashSet<>();

        return board.stream().anyMatch(rank -> rank.getPieces().stream()
                .filter(piece -> piece.equalsPawn(color) && !cols.add(rank.getPieces().indexOf(piece)))
                .isParallel());
    }
}