import java.util.Scanner;

public class Main {
    private static final String START_COMMAND = "START";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Game game = new Game();

        if (getUserCommand().equals(START_COMMAND)) {
            game.start();
        }

        while(true) {
            String userCommand = getUserCommand();
            if (userCommand.equals(END_COMMAND)) {
                game.end();
            }
            // 게임 진행
        }
    }

    private static String getUserCommand() {
        return new Scanner(System.in).nextLine().toUpperCase();
    }
}