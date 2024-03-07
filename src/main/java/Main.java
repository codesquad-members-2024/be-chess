import java.util.Scanner;

public class Main {

    private static final String COMMAND_MESSAGE = "수행할 명령어를 입력해 주세요.";
    private static final String START_COMMAND = "START";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Game game = new Game();

        if (getUserCommand().equals(START_COMMAND)) {
            game.start();
        }

        while (true) {
            String userCommand = getUserCommand();
            if (userCommand.equals(END_COMMAND)) {
                break;
            }
            // 게임 진행
        }

        game.end();
    }

    private static String getUserCommand() {
        System.out.println(COMMAND_MESSAGE);
        return new Scanner(System.in).nextLine().toUpperCase();
    }
}