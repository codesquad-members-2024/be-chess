public class Pawn {
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
