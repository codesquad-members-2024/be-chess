import java.util.ArrayList;

public class Board {
    ArrayList<Pawn> whitePawns = new ArrayList<Pawn>();
    ArrayList<Pawn> blackPawns = new ArrayList<Pawn>();

    public Board() {
        initialize();
    }

    void initialize() {
        // 검은색 폰과 흰색 폰을 각각 8개씩 가지도록 초기화
        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn("white"));
            blackPawns.add(new Pawn("black"));
        }

    }

    void print() {
        StringBuilder sb = new StringBuilder();

    }

    public void add(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.WHITE_COLOR)) {
            whitePawns.add(pawn);
        } else if (pawn.getColor().equals(Pawn.BLACK_COLOR)) {
            blackPawns.add(pawn);
        }
    }

    public int size() {
        return 1;
    }

//    public Pawn findPawn(int i) {
//
//    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        whitePawns.stream().map(Pawn::getRepresentation).forEach(sb::append);
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        blackPawns.stream().map(Pawn::getRepresentation).forEach(sb::append);
        return sb.toString();
    }
}
