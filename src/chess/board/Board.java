package src.chess.board;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import src.chess.pieces.Piece;
import java.util.ArrayList;
import src.utils.StringUtils;

public class Board {
    private List<Piece> pieces = new ArrayList<>();
    private List<Rank> board = new ArrayList<>();

    public void add(Piece piece) {
        this.pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public Piece findPawn(int index) {
        return pieces.get(index);
    }

    public void initialize() {
        board.add(Rank.createWhiteInitRank());
        board.add(Rank.createWhitePawnRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlackPawnRank());
        board.add(Rank.createBlackInitRank());
    }

    public int pieceCount() {
        return board.stream()
                .map(Rank::getPieceSize)
                .reduce(0, Integer::sum);
    }

    public String showBoard() {
        List<Rank> reversedBoard = new ArrayList<>(board);
        Collections.reverse(reversedBoard);

        return reversedBoard.stream()
                .map(rank -> StringUtils.appendNewLine(rank.toString()))
                .collect(Collectors.joining());
    }
}