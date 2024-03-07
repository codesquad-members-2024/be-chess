package chess;

import chess.board.Board;
import chess.board.BoardView;
import chess.enums.Color;
import chess.enums.Position;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;
import chess.pieces.implement.Blank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static chess.board.Board.RANK_CNT;

public class ChessGame {

    private final Board board = Board.getInstance();

    //오버로딩
    public void move(String position, Piece piece) {
        board.replace(Position.valueOf(position.toUpperCase()), piece);
    }

    //오버로딩
    public void move(String sourcePosition, String targetPosition) {
        Piece source = board.get(Position.valueOf(sourcePosition.toUpperCase()));
        Piece blank = Blank.blank.create(Color.NO_COLOR);

        board.replace(Position.valueOf(targetPosition.toUpperCase()), source);
        board.replace(Position.valueOf(sourcePosition.toUpperCase()), blank);

        BoardView view = new BoardView(getChessBoard());
        view.printBoard();
    }

    public double calculatePoint(Color color) {
        double result = 0.0;

        for (int startFile = 'A'; startFile <= 'H'; startFile++) {
            int pawnCnt = 0;
            for (int nowRank = RANK_CNT; nowRank > 0; nowRank--) {
                StringBuilder index = new StringBuilder();
                index.append((char)startFile).append(nowRank);
                Piece now = board.get(Position.valueOf(index.toString().toUpperCase()));
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
        List<Piece> toReturn = getChessBoard().values()
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

    private Map<Position, Piece> getChessBoard() {
        return board.getChessBoard();
    }
}
