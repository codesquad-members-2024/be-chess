package piece;

public class Pawn extends Piece {
    public Pawn(String color, Pieces pieces) {
        if (!isValidColor(color)) {
            throw new IllegalArgumentException("폰의 색은 하얀색과 검은색만 가능합니다.");
        }

        this.color = color;
        this.logo = pieces.getPresentation();
    }
}
