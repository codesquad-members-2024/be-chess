package view;

import static chess.Board.LIST_TO_STRING_DELIMITER;
import static utils.StringUtils.NEWLINE;

import chess.Board;
import java.util.stream.Collectors;
import pieces.Piece;

public class ChessView {
    private final Board board;

    public ChessView(Board board) {
        this.board = board;
    }

    public void showBoard() {
        String result = generateCurrentBoard();
        System.out.println(result);
    }

    public String generateCurrentBoard() {
        return board.getBoard().stream()
                .map(rank -> rank.getPieces().stream().map(this::getSymbol)
                        .collect(Collectors.joining(LIST_TO_STRING_DELIMITER)))
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
}
