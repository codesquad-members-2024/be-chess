import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> pawns;

    Board() {
        this.pawns = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int order) {
        return pawns.get(order);
    }
}
