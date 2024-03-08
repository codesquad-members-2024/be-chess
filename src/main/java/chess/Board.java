package chess;

import chess.pieces.Pawn;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private static final int BOARD_SIZE = 8;
    private static final int PAWNS_SIZE = 8;
    private static final int WHITE_PAWNS_INDEX = 6;
    private static final int BLACK_PAWNS_INDEX = 1;
    private final List<Pawn> pawns = new ArrayList<>(PAWNS_SIZE); //final 변경
    private final List<List<Pawn>> board = new ArrayList<>(BOARD_SIZE);

    public void add(final Pawn pawn) {
        this.pawns.add(pawn);
    }

    public int size() {
        return this.pawns.size();
    }

    public Pawn findPawn(final int index) {
        return this.pawns.get(index);
    }

    public void initialize() { // 중복 삭제
        for (int column = 0; column < BOARD_SIZE; column++) {
            if (column == BLACK_PAWNS_INDEX) {
                makePawns(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION);
            }
            if(column == WHITE_PAWNS_INDEX){
                makePawns(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
            }
            addBoard();
        }
    }

    private void makePawns(String color, char representation) {
        for (int row = 0; row < PAWNS_SIZE; row++) {
            add(new Pawn(color, representation));
        }
    }

    private void addBoard() {
        //pawns리스트를 copiedPawns에 복사한다 :: clear하면 리스트 내의 모든 값이 사라지므로 복사하여 저장
        List<Pawn> copiedPawns = pawns.stream()
                .map(pawn -> new Pawn(pawn.getColor(), pawn.getRepresentation()))
                .collect(Collectors.toList());

        board.add(copiedPawns);
        pawns.clear();
    }

    public String getWhitePawnsResult() {
        return makeRepresentations(board.get(WHITE_PAWNS_INDEX));
    }

    public String getBlackPawnsResult() {
        return makeRepresentations(board.get(BLACK_PAWNS_INDEX));
    }

    private String makeRepresentations(List<Pawn> pawns) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pawn pawn : pawns) {
            stringBuilder.append(pawn.getRepresentation());
        }
        return String.valueOf(stringBuilder);
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int column = 0; column < BOARD_SIZE; column++) {
            if(column == WHITE_PAWNS_INDEX){
                stringBuilder.append(getWhitePawnsResult()).append("\n");
            }
            if(column == BLACK_PAWNS_INDEX) {
                stringBuilder.append(getBlackPawnsResult()).append("\n");
            }
            if (column != WHITE_PAWNS_INDEX && column != BLACK_PAWNS_INDEX) {
                stringBuilder.append("........").append("\n");
            }
        }
        return String.valueOf(stringBuilder);
    }

}

