package src.chess;

public enum Colors {
    WHITE("white"),
    BLACK("black");

    private final String colorName;

    Colors(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}
