package src.chess.board;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import src.chess.pieces.Piece;
import java.util.ArrayList;
import src.chess.pieces.Piece.Colors;
import src.chess.pieces.Piece.Type;
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
                .map(Rank::getAllPieceCount)
                .reduce(0, Integer::sum);
    }

    public String showBoard() {
        List<Rank> reversedBoard = new ArrayList<>(board);
        Collections.reverse(reversedBoard);

        return reversedBoard.stream()
                .map(rank -> StringUtils.appendNewLine(rank.toString()))
                .collect(Collectors.joining());
    }

    // 기물의 색, 종류를 인자로 받아서 기물의 개수를 구한다.
    public int getPieceCount(Colors colors, Type type) {
        return board.stream()
                .map(rank -> rank.getPieceCountBy(colors, type))
                .reduce(0, Integer::sum);
    }
}