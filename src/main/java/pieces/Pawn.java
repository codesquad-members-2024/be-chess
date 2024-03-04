package pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    String teamColor;
    public Pawn(String teamColor){
        this.teamColor = teamColor;
    }
    public Pawn(){
        this.teamColor = "white";
    }
    public String getColor(){
        return teamColor;
    }
}
