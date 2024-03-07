package chess;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

import static chess.ChessHelp.MAX_FILE;
import static chess.ChessHelp.MIN_FILE;

public class Rank {
    final List<Piece> rank = new ArrayList<>(MAX_FILE);

    public Rank() { // 기본값 : 다 비워져있음
        for (int file = 1; file <= MAX_FILE; file++) {
            this.rank.add(PieceFactory.createBlank());
        }
    }

    public Piece getPiece(int file) {
        return rank.get(file - MIN_FILE);
    }

    public void setPiece(int file, Piece piece) {
        rank.set(file - MIN_FILE, piece);
    }

    public Stream<Piece> stream() {
        return rank.stream();
    }

    public String getRankResult() {
        StringJoiner sj = new StringJoiner("");
        stream().forEach(p -> sj.add(p.getRepresentation()));

        return sj.toString();
    }
}
