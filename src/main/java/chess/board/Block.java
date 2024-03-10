package chess.board;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Block {
    private static final Piece BLANK = PieceFactory.createBlank();
    private static final Map<Integer, Integer> rankMap = IntStream.rangeClosed(1, 8).boxed().collect(Collectors.toMap(i -> i, i -> 8 - i));
    private final int rank;
    private final int file;
    private Piece piece = BLANK;

    private Block(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public static Block init(int rank, int file) {
        return new Block(rank, file);
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    public int[] getRankAndFile() {
        int[] rankAndFile = new int[2];
        rankAndFile[0] = rank;
        rankAndFile[1] = file;

        return rankAndFile;
    }

    public String getPos() {
        return convertFileToPos(getFile()) + convertRankToPos(getRank());
    }

    public Piece getPiece() {
        return piece;
    }

    public Piece pick() {
        Piece pick;
        pick = piece;
        piece = BLANK;
        return pick;
    }

    public Block changePiece(Piece piece) {
        this.piece = piece;
        return this;
    }

    public boolean isBlank() {
        return piece.equals(BLANK);
    }

    public Block movePieceToTargetBlock(Block that) {
        Piece pick = this.pick();
        that.changePiece(pick);

        return that;
    }

    public boolean isSamePos(String pos) {
        return this.rank == convertPosToRank(pos) && this.file == convertPosToFile(pos);
    }

    public static int[] convertPosToRankAndFile(String pos) {
        int[] rankAndFile = new int[2];

        rankAndFile[0] = convertPosToRank(pos);
        rankAndFile[1] = convertPosToFile(pos);

        return rankAndFile;
    }

    public static int convertPosToRank(String pos) {
        char rank = pos.charAt(1);
        return rankMap.get(Character.getNumericValue(rank));
    }

    public static int convertPosToFile(String pos) {
        char file = pos.charAt(0);
        return file - 'a';
    }

    public static String convertRankAndFileToPos(int rank, int file) {
        return convertFileToPos(file) + convertRankToPos(rank);
    }

    public static String convertRankToPos(int rank) {
        return String.valueOf(8 - rank);
    }

    public static String convertFileToPos(int file) {
        return Character.toString((char) file + 'a');
    }
}
