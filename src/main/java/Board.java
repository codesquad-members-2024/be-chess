import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> pieces = new ArrayList<>();

    public void add(Pawn piece){
        pieces.add(piece);
    }

    public int size(){
        return pieces.size();
    }

    public Pawn findPiece(int index){
        return pieces.get(index);
    }
}
