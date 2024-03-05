package chess;

import static utils.StringUtils.NEWLINE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;

public class Board {
    private List<Piece> pieces;
    private Piece[][] board;

    public Board() {
        pieces = new ArrayList<>();
        board = new Piece[8][8];
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public void initialize() {
        initializeExceptPawns(Color.WHITE.getColor(), 7);
        initializePawns(Color.WHITE.getColor(), 6);
        initializePawns(Color.BLACK.getColor(), 1);
        initializeExceptPawns(Color.BLACK.getColor(), 0);
    }

    private void initializePawns(String color, int row) {
        IntStream.range(0, 8).forEach(col -> {
            Piece piece = generatePawn(color);
            add(piece);
            board[row][col] = piece;
        });
    }

    private Piece generatePawn(String color) {
        if (color.equals(Color.WHITE.getColor())) {
            return Piece.createWhitePawn();
        }
        return Piece.createBlackPawn();
    }

    private void initializeExceptPawns(String color, int row) {
        Piece[] piecesExceptPawns = generatePiecesExceptPawns(color);
        IntStream.range(0, 8).forEach(col -> {
            add(piecesExceptPawns[col]);
            board[row][col] = piecesExceptPawns[col];
        });
    }

    private Piece[] generatePiecesExceptPawns(String color) {
        Piece[] result = new Piece[8];
        if (color.equals(Color.WHITE.getColor())) {
            result[0] = Piece.createWhiteRook();
            result[1] = Piece.createWhiteKnight();
            result[2] = Piece.createWhiteBishop();
            result[3] = Piece.createWhiteQueen();
            result[4] = Piece.createWhiteKing();
            result[5] = Piece.createWhiteBishop();
            result[6] = Piece.createWhiteKnight();
            result[7] = Piece.createWhiteRook();
        } else if (color.equals(Color.BLACK.getColor())) {
            result[0] = Piece.createBlackRook();
            result[1] = Piece.createBlackKnight();
            result[2] = Piece.createBlackBishop();
            result[3] = Piece.createBlackQueen();
            result[4] = Piece.createBlackKing();
            result[5] = Piece.createBlackBishop();
            result[6] = Piece.createBlackKnight();
            result[7] = Piece.createBlackRook();
        }
        return result;
    }

    public int pieceCount() {
        return pieces.size();
    }

    public String showBoard() {
        return IntStream.range(0, 8)
                .mapToObj(row -> IntStream.range(0, 8)
                        .mapToObj(col -> getSymbol(board[row][col]))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(NEWLINE)).concat(NEWLINE);
    }

    private String getSymbol(Piece piece) {
        if (Objects.isNull(piece)) {
            return PieceSymbol.NO_PIECE.getSymbol();
        }

        if (piece.isWhite()) {
            return piece.getPieceSymbol().getSymbol();
        }
        return Piece.convertToBlackPiece(piece.getPieceSymbol().getSymbol());
    }
}