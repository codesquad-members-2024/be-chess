package chess;

import static chess.utils.StringUtils.*;

import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<List<Piece>> pieces = new ArrayList<>(32);

    public int size() {
        return this.pieces.size();
    }

    public void initialize() {
        initRank8();

        initRank7();

        initBlankRanks();

        initRank2();

        initRank1();
    }

    private void initRank1() {
        List<Piece> rank2 = new ArrayList<>();
        rank2.add(Piece.createWhiteRook());
        rank2.add(Piece.createWhiteKnight());
        rank2.add(Piece.createWhiteBishop());
        rank2.add(Piece.createWhiteQueen());
        rank2.add(Piece.createWhiteKing());
        rank2.add(Piece.createWhiteBishop());
        rank2.add(Piece.createWhiteKnight());
        rank2.add(Piece.createWhiteRook());
        pieces.add(rank2);
    }

    private void initRank2() {
        List<Piece> rank1 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            rank1.add(Piece.createWhitePawn());
        }
        pieces.add(rank1);
    }

    private void initBlankRanks() {
        //빈칸들 만들기
        for (int i = 0; i < 4; i++) {
            List<Piece> blankRank = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                blankRank.add(Piece.createBlank());
            }
            pieces.add(blankRank);
        }
    }

    private void initRank7() {
        List<Piece> rank7 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            rank7.add(Piece.createBlackPawn());
        }
        pieces.add(rank7);
    }

    private void initRank8() {
        List<Piece> rank8 = new ArrayList<>();
        rank8.add(Piece.createBlackRook());
        rank8.add(Piece.createBlackKnight());
        rank8.add(Piece.createBlackBishop());
        rank8.add(Piece.createBlackQueen());
        rank8.add(Piece.createBlackKing());
        rank8.add(Piece.createBlackBishop());
        rank8.add(Piece.createBlackKnight());
        rank8.add(Piece.createBlackRook());
        pieces.add(rank8);
    }

    public int pieceCount() {
        int size = 0;
        for (List<Piece> rank : pieces) {
            if (!isBlankRank(rank)) {
                size += rank.size();
            }
        }
        return size;
    }

    private boolean isBlankRank(List<Piece> rank) {
        long count = rank.stream()
                .filter(Piece::isBlank)
                .count();

        return count == 8;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (List<Piece> rank : pieces) {
            for (Piece piece : rank) {
                sb.append(piece.getRepresentation(piece.getColor()));
            }
            appendNewLine(sb);
        }
        return sb.toString();
    }
}