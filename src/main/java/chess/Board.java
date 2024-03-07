package chess;

import chess.enums.Color;
import chess.enums.Position;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

import static chess.utils.StringUtils.appendNewLine;

import java.util.*;

public class Board {
    private final int RANK_CNT = 8;
    private final Map<Position, Piece> chessBoard = new HashMap<>();

    public void initialize() {
        Arrays.stream(Position.values())
                .forEach((Position pos) -> {
                    chessBoard.put(pos, pos.initPosition());
                });
    }

    public int pieceCount() {
        return (int)chessBoard.values().stream()
                                    .filter(piece -> !piece.isBlank())
                                    .count();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = RANK_CNT; i > 0; i--) {
            sb.append(appendNewLine((getRowString(i))));
        }

        return sb.toString();
    }

    private String getRowString(int row) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Position.values())
                .filter(position -> position.name().contains(String.valueOf(row)))
                .forEach(position -> sb.append(chessBoard.get(position).getRepresent()));
        return sb.toString();
    }

    public int numberOfSpecificPiece(TypeOfPiece type, Color color) {
        return (int)chessBoard.values().stream()
                                .filter(piece -> piece.getColor().equals(color) && piece.getType().equals(type))
                                .count();
    }

    public Piece findPiece(String index) {
        return chessBoard.get(Position.valueOf(index.toUpperCase()));
    }

    //Test만을 위한 메서드...??
    public void initializeEmpty() {
        chessBoard.keySet()
                .forEach(position -> chessBoard.replace(position, Piece.createBlank(TypeOfPiece.NO_PIECE)));
    }

    public void move(String position, Piece piece) {
        chessBoard.replace(Position.valueOf(position.toUpperCase()), piece);
    }

    public double calculatePoint(Color color) {
        double result = 0.0;

        for (int startFile = 'A'; startFile <= 'H'; startFile++) {
            int pawnCnt = 0;
            for (int nowRank = RANK_CNT; nowRank > 0; nowRank--) {
                StringBuilder index = new StringBuilder();
                index.append((char)startFile).append(nowRank);
                Piece now = chessBoard.get(Position.valueOf(index.toString().toUpperCase()));
                if (now.getColor().equals(color)) {
                    result += now.getType().getScore();
                    pawnCnt += now.getType().equals(TypeOfPiece.PAWN) ? 1 : 0;
                }
            }
            if (pawnCnt > 1) {
                result -= TypeOfPiece.PAWN.getScore() * pawnCnt;
                result += pawnCnt * (TypeOfPiece.PAWN.getScore() / 2);
            }
        }

        return result;
    }

    public List<Piece> sortPieceByScore(Color color, boolean reverse) {

        List<Piece> toReturn = chessBoard.values()
                .stream()
                .filter(piece -> piece.getColor().equals(color))
                .sorted((Piece piece1, Piece piece2) -> (int) (piece1.getType().getScore() - piece2.getType().getScore()))
                .toList();
        if (reverse) {
            toReturn = new ArrayList<>(toReturn);
            Collections.reverse(toReturn);
        }

        return toReturn;
    }
}
