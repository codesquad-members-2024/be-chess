public class Pawn {
     private String color;

    Pawn(String color) {
        this.color = Validator.isColor(color);
    }

    String getColor() {
        return color;
    }
}