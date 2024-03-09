package src.chess.board;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import src.chess.pieces.Piece;
import java.util.ArrayList;
import src.chess.pieces.Piece.Colors;
import src.chess.pieces.Piece.Type;
import src.utils.StringUtils;

public class Board {
    private static final int MAX_BOARD_SIZE = 8;
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

    // 체스판을 전부 빈 칸으로 초기화한다.
    public void initializeEmpty() {
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
        board.add(Rank.createBlankRank());
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

    // 위치를 조회한다
    // row는 어떤 Rank를 조회할 것인지를 결정하고, cold은 Rank 내에서 몇번째 말인지를 결정한다
    public Piece findPieceBy(String location) {
        int col = StringUtils.parserToColIndex(location.charAt(0));
        int row = StringUtils.parserToRowIndex(location.charAt(1));
        return board.get(row).getPieceBy(col);
    }

    public void move(String position, Piece piece) {
        int col = StringUtils.parserToColIndex(position.charAt(0));
        int row = StringUtils.parserToRowIndex(position.charAt(1));
        board.get(row).setPiece(col, piece);
    }

    // 점수를 확인하기를 원하는 색을 받아서 해당 색의 점수를 계산한다.
    public double calculatePoint(Colors colors) {
        return board.stream()
                .mapToDouble(rank -> rank.calculateRankPoint(colors))
                .sum() - ((double) getPawnInCol(colors) / 2);
    }

    // 기물을 전체 리스트에 담는다.
    public List<Piece> getAllPiecesList(Colors colors) {
        return board.stream()
                .flatMap(rank -> rank.getAllPieceBy(colors).stream())
                .sorted(Comparator.comparing(Piece::getDefaultPoint,Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
    // 일직선상에 있는 같은 색 폰의 개수 구하기
    // 만들어진 (색상이 정해짐) 폰을 받아서 그 폰이랑 같은지를 보는걸로?
    // 추후 stream 으로도 한 번 바꿔보기
    public int getPawnInCol(Colors colors) {
        // 흰색인지 검은색인지 체크해서 확인해야 한다. colors와 같은 색인 것만 체크해야 함
        int count = 0;
        for (int i = 0; i < MAX_BOARD_SIZE; i++) {
            int countPawn = 0;
            for (int j = 0; j < MAX_BOARD_SIZE; j++) {
                if (board.get(j).getPieceBy(i).isWhite()) {
                    countPawn++;
                }
            }
            if (countPawn > 1) {
                count += countPawn;
            }
        }
        return count;
    }
}