package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;
import utils.Position;

public class ChessGame {
    public static final int SOURCE_POS_INDEX = 1;
    private static final int TARGET_POS_INDEX = 2;
    public static final double DIVIDE_IN_HALF = 2.0;
    private static final String MOVE = "move";
    private static final String BLANK = "\\s+";

    private final Board chessBoard;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;
    private final List<Rank> board;

    public ChessGame(Board chessBoard) {
        this.chessBoard = chessBoard;
        this.whitePieces = chessBoard.getWhitePieces();
        this.blackPieces = chessBoard.getBlackPieces();
        this.board = chessBoard.getBoard();
    }

    public void moveBoard(String userInput) {
        String[] commands = convertToPos(userInput);
        move(commands[SOURCE_POS_INDEX], commands[TARGET_POS_INDEX]);
    }

    public String[] convertToPos(String userInput) {
        return userInput.replaceAll(MOVE, BLANK).split(BLANK);
    }

    public void addPiece(String position, Piece piece) {
        Position pos = new Position(position);
        chessBoard.setPiece(pos, piece);
    }

    public void move(String sourcePosition, String targetPosition) {
        Position sourcePos = new Position(sourcePosition);
        Position targetPos = new Position(targetPosition);
        Piece piece = chessBoard.findPiece(sourcePos);

        if (!piece.verifyMovePosition(targetPos)) {
            System.out.println("이동할 수 없는 위치값입니다.");
            return;
        }
        if (piece.isObstacleInPath(targetPos, getObstacle(piece))) {
            System.out.println("같은 색의 기물이 존재하여 움직일 수 없습니다.");
            return;
        }

        piece.move(targetPos);
        chessBoard.move(piece, sourcePos, targetPos);
    }

    public List<Position> getObstacle(Piece piece) {
        if (piece.matchSymbol(PieceSymbol.PAWN)) {
            return getPawnObstacle(piece);
        }
        List<Position> positions = piece.getPositions();
        return positions.stream()
                .filter(pos -> chessBoard.findPiece(pos).matchColor(piece.getColor()))
                .toList();
    }

    public List<Position> getPawnObstacle(Piece piece) {
        List<Position> positions = piece.getPositions();
        return positions.stream()
                .filter(pos -> chessBoard.findPiece(pos).matchColor(piece.getColor()) ||
                        (!chessBoard.findPiece(pos).matchColor(piece.getColor()) &&
                                piece.getPosition().getCol() == chessBoard.findPiece(pos).getPosition().getCol()))
                .toList();
    }

    public double calculatePoint(Color color) {
        return board.stream()
                .mapToDouble(rank -> rank.findSameColorPieces(color).stream()
                        .mapToDouble(this::getPoint).sum())
                .sum();
    }

    private double getPoint(Piece piece) {
        double defaultPoint = piece.getPieceSymbol().getDefaultPoint();
        if (piece.isPawn() && hasSameVerticalPawns(piece)) {
            return defaultPoint / DIVIDE_IN_HALF;
        }
        return defaultPoint;
    }

    private boolean hasSameVerticalPawns(Piece piece) {
        return board.stream().anyMatch(rank -> rank.hasSameColorPawn(piece));
    }

    public List<String> sortPieces(Color color) {
        Stream<Piece> piecesStream = color.equals(Color.WHITE) ? whitePieces.stream() : blackPieces.stream();
        List<String> copyPieces = new ArrayList<>(sortPiecesInternal(piecesStream));
        Collections.reverse(copyPieces);
        return copyPieces;
    }

    public List<String> sortPiecesReversed(Color color) {
        Stream<Piece> piecesStream = color.equals(Color.WHITE) ? whitePieces.stream() : blackPieces.stream();
        return sortPiecesInternal(piecesStream);
    }

    private List<String> sortPiecesInternal(Stream<Piece> piecesStream) {
        return piecesStream.sorted(new PieceComparator())
                .map(piece -> piece.getPieceSymbol().getSymbol())
                .collect(Collectors.toList());
    }
}

class PieceComparator implements Comparator<Piece> {
    @Override
    public int compare(Piece piece1, Piece piece2) {
        return Double.compare(piece1.getPieceSymbol().getDefaultPoint(), piece2.getPieceSymbol().getDefaultPoint());
    }
}