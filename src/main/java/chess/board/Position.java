package chess.board;

import chess.pieces.Piece;
import java.util.Arrays;

public class Position {
    private static final Piece BLANK = Piece.createBlank();
    private int[] rankAndFile = new int[2];
    private Piece piece = BLANK;

    private Position(int rank, int file) {
        rankAndFile[0] = rank;
        rankAndFile[1] = file;
    }

    public static Position init(int rank, int file) {
        return new Position(rank, file);
    }

    public int getRank() {
        return rankAndFile[0];
    }

    public int getFile() {
        return rankAndFile[1];
    }

    public int[] getRankAndFile() {
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

    public Position changePiece(Piece piece) {
        this.piece = piece;
        return this;
    }

    public boolean isBlank() {
        return piece.equals(BLANK);
    }

    public Position movePieceToTargetPosition(Position that) {
        Piece pick = this.pick();
        that.changePiece(pick);

        return that;
    }

    public boolean isSamePos(String pos) {
        return Arrays.equals(rankAndFile, convertPosToRankAndFile(pos));
    }

    public static int[] convertPosToRankAndFile(String pos) {
        int[] rankAndFile = new int[2];

        rankAndFile[0] = convertPosToRank(pos);
        rankAndFile[1] = convertPosToFile(pos);

        return rankAndFile;
    }

    public static int convertPosToRank(String pos) {
        char rank = pos.charAt(1);
        return Character.getNumericValue(rank) - 1;
    }

    public static int convertPosToFile(String pos) {
        char file = pos.charAt(0);
        return file - 'a';
    }

    public static String convertRankAndFileToPos(int rank, int file) {
        return convertFileToPos(file) + convertRankToPos(rank);
    }

    public static String convertRankToPos(int rank) {
        return String.valueOf(rank + 1);
    }

    public static String convertFileToPos(int file) {
        return Character.toString((char) file + 'a');
    }
}
