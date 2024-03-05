import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn){
        pawns.add(pawn);
    }

    public Pawn findPawn(int index){
        return pawns.get(index);
    }

    public int size(){
        return pawns.size();
    }
}
