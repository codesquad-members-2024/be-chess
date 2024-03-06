import java.util.ArrayList;

public class Board {
    private static final String WHITE_COLOR = "white";
    private static final String BLACK_COLOR = "black";
    private static final int COL_NUMS = 8;
    private static final String BLANKS = "•".repeat(COL_NUMS);
    ArrayList<Pawn> whitePawns;
    ArrayList<Pawn> blackPawns;
    ArrayList<Object> whitePieces;
    ArrayList<Object> blackPieces;

    public Board() {
        whitePawns = new ArrayList<Pawn>();
        blackPawns = new ArrayList<Pawn>();
        whitePieces = new ArrayList<Object>();
        blackPieces = new ArrayList<Object>();
        //   initialize();
    }

    void initialize() {
        // 검은색 폰과 흰색 폰을 각각 8개씩 가지도록 초기화
        for (int i = 0; i < COL_NUMS; i++) {
            whitePieces.add('•');
            blackPieces.add('•');
            whitePawns.add(new Pawn(WHITE_COLOR));
            blackPawns.add(new Pawn(BLACK_COLOR));
        }
    }

    public void print() {
        // 현재 체스판의 결과를 출력
        StringBuilder sb = new StringBuilder();
        sb.append(getBlackPieceResult()).append("\n");
        sb.append(getBlackPawnsResult()).append("\n");
        for (int i = 0; i < 4; i++) {
            sb.append(BLANKS).append("\n");
        }
        sb.append(getWhitePawnsResult()).append("\n");
        sb.append(getWhitePieceResult()).append("\n");
        System.out.println(sb);
    }

    public String getWhitePieceResult() {
        StringBuilder sb = new StringBuilder();
        whitePieces.stream().map(Object::toString).forEach(sb::append);
        return sb.toString();
    }

    public String getBlackPieceResult() {
        StringBuilder sb = new StringBuilder();
        blackPieces.stream().map(Object::toString).forEach(sb::append);
        return sb.toString();
    }

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

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findWhitePawn(int i) {
        return whitePawns.get(i);
    }

    public Pawn findBlackPawn(int i) {
        return blackPawns.get(i);
    }

    public void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }
}