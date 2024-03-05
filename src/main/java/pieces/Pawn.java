package pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    private String teamColor;
    public Pawn(String teamColor){
        if (rightColor(teamColor)) {
            this.teamColor = teamColor;
        }
    }
    public Pawn(){
        this.teamColor = "white";
    }
    public String getColor(){
        return teamColor;
    }
    private boolean rightColor(String teamColor){
        return teamColor.equals(WHITE_COLOR)||teamColor.equals(BLACK_COLOR);
    }
}
