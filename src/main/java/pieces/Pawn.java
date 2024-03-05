package pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = 'P';
    public static final char BLACK_REPRESENTATION = 'p';
    private String teamColor;
    private char pieceRepresent;
    public Pawn(String teamColor, char pieceRepresent){
        if (rightColor(teamColor) && rightPiece(pieceRepresent)) {
            this.teamColor = teamColor;
            this.pieceRepresent = pieceRepresent;
        }
    }
    public Pawn(){
        this.teamColor = WHITE_COLOR;
        this.pieceRepresent = WHITE_REPRESENTATION;
    }
    public String getColor(){
        return teamColor;
    }
    public char getRepresentation(){
        return pieceRepresent;
    }
    private boolean rightColor(String teamColor){ //팀 색이 올바른지 체크한다.
        return teamColor.equals(WHITE_COLOR)||teamColor.equals(BLACK_COLOR);
    }
    private boolean rightPiece(char pieceRepresent){ //피스들의 심블이 올바른지 체크한다.
        return pieceRepresent == WHITE_REPRESENTATION||pieceRepresent == BLACK_REPRESENTATION;
    }
}
