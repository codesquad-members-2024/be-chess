package chess;

import static utils.StringUtils.NEWLINE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;

public class Board {
    private List<Piece> pieces;
    private List<Rank> board;

    public Board() {
        pieces = new ArrayList<>();
        board = new ArrayList<>(8);
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public void initialize() {
        initializeExceptPawns(Color.BLACK.getColor());
        initializePawns(Color.BLACK.getColor());
        IntStream.range(0, 4).forEach(i -> initializeBlank());
        initializePawns(Color.WHITE.getColor());
        initializeExceptPawns(Color.WHITE.getColor());
    }

    private void initializeBlank() {
        List<Piece> blanks = new ArrayList<>();
        IntStream.range(0, 8).forEach(i -> blanks.add(Piece.createBlank()));
        board.add(new Rank(blanks));
    }

    private void initializePawns(String color) {
        List<Piece> pawns = new ArrayList<>();
        IntStream.range(0, 8).forEach(i -> pawns.add(generatePawn(color)));
        pieces.addAll(pawns);
        board.add(new Rank(pawns));
    }

    private Piece generatePawn(String color) {
        if (color.equals(Color.WHITE.getColor())) {
            return Piece.createWhitePawn();
        }
        return Piece.createBlackPawn();
    }

    private void initializeExceptPawns(String color) {
        List<Piece> piecesExceptPawns = generatePiecesExceptPawns(color);
        pieces.addAll(piecesExceptPawns);
        board.add(new Rank(piecesExceptPawns));
    }

    private ArrayList<Piece> generatePiecesExceptPawns(String color) {
        ArrayList<Piece> piecesExceptPawns = new ArrayList<>();
        if (color.equals(Color.WHITE.getColor())) {
            piecesExceptPawns.add(Piece.createWhiteRook());
            piecesExceptPawns.add(Piece.createWhiteKnight());
            piecesExceptPawns.add(Piece.createWhiteBishop());
            piecesExceptPawns.add(Piece.createWhiteQueen());
            piecesExceptPawns.add(Piece.createWhiteKing());
            piecesExceptPawns.add(Piece.createWhiteBishop());
            piecesExceptPawns.add(Piece.createWhiteKnight());
            piecesExceptPawns.add(Piece.createWhiteRook());
        } else if (color.equals(Color.BLACK.getColor())) {
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
        pieces.clear();
        board.clear();
        IntStream.range(0, 8).forEach(i -> initializeBlank());
    }

    public int pieceCount() {
        return pieces.size();
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
                .filter(piece -> piece.getColor().equals(color.getColor()) &&
                        piece.getPieceSymbol().equals(pieceSymbol))
                .count();
    }

    public Piece findPiece(String position) {
        int row = 8 - Character.getNumericValue(position.charAt(1));
        int col = position.charAt(0) - 'a';

        return board.get(row).getPiece(col);
    }

    public void move(String position, Piece piece) {
        int row = 8 - Character.getNumericValue(position.charAt(1));
        int col = position.charAt(0) - 'a';
        pieces.remove(piece);
        board.get(row).getPieces().set(col, piece);
    }
}