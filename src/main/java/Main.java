import java.util.Scanner;

public class Main {
    private static final String START_COMMAND = "START";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Game game = new Game();

        if (getUserCommand().equals(START_COMMAND)) {
            game.start();
        }

        while(!getUserCommand().equals(END_COMMAND)) {

        }
    }

    private static String getUserCommand() {
        return new Scanner(System.in).nextLine().toUpperCase();
    }
}