import java.util.ArrayList;

public class Board {
    ArrayList<Pawn> pawns;

    public Board() {
        pawns = new ArrayList<Pawn>();
    }

    void initialize() {
        // 검은색 폰과 흰색 폰을 각각 8개씩 가지도록 초기화
        for (int i = 0; i < 8; i++) {
            pawns.add(new Pawn("white"));
            pawns.add(new Pawn("black"));
        }
    }

    void print() {
        StringBuilder sb = new StringBuilder();

    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        pawns.stream().filter(pawn -> pawn.getColor().equals(Pawn.WHITE_COLOR))
                .forEach(pawn -> sb.append(pawn.getRepresentation()));
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        pawns.stream().filter(pawn -> pawn.getColor().equals(Pawn.BLACK_COLOR))
                .forEach(pawn -> sb.append(pawn.getRepresentation()));
        return sb.toString();
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int i) {
        return pawns.get(i);
    }

}