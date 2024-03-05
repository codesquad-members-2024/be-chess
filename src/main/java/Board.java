import java.util.Arrays;

public class Board {
    Object[][] chessPan;

    public Board() {
        chessPan = new Object[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(chessPan[i], '•');
        }
        initialize();
    }

    void initialize() {
        // 검은색 폰과 흰색 폰을 각각 8개씩 가지도록 초기화
        for (int i = 0; i < 8; i++) {
            chessPan[1][i] = new Pawn("white").getRepresentation();
            chessPan[6][i] = new Pawn("black").getRepresentation();
        }
    }

    public void print() {
        // 현재 체스판의 결과를 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                row.append(chessPan[i][j]);
            }
            row.append("\n");
            sb.append(row);
        }
        System.out.println(sb);
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

//    public void add(Pawn pawn) {
//    }

//    public int size() {
//        return pawns.size();
//    }

//    public Pawn findPawn(int i) {
//        return pawns.get(i);
//    }
}