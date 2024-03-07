package chess;

import chess.board.Board;
import chess.board.Position;
import chess.game.Game;
import chess.view.View;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String ASK_MAIN_COMMAND = "> 메인 명령어를 입력해주세요.";
    private static final String ASK_MOVE_COMMAND = "> 이동 명령어를 입력해주세요.";
    private static final String NOT_FOUND_COMMAND = "일치하는 커맨드를 찾을 수 없습니다.";
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";
    private static final Pattern MOVE_COMMAND_PATTERN = Pattern.compile(
            "^move\\s+([a-zA-Z][0-9])\\s+([a-zA-Z][0-9])\\s*$", Pattern.CASE_INSENSITIVE);

    private static final View view = new View();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        board.initialize();
        String menuCommand = getOrRetry(Main::readMenuCommand);

        while (menuCommand.equals(START_COMMAND)) {
            print(view.showBoard(board));

            if (game.isOver()) {
                break;
            }

            runOrRetry(() -> move(game));
        }
    }

    private static String readMenuCommand() {
        System.out.println(ASK_MAIN_COMMAND);
        String menuCommand = sc.nextLine().toLowerCase();
        if (!menuCommand.equals(START_COMMAND) && !menuCommand.equals(END_COMMAND)) {
            throw new IllegalArgumentException(NOT_FOUND_COMMAND);
        }
        return menuCommand;
    }

    private static void print(String target) {
        System.out.println(target);
    }

    private static void move(Game game) {
        System.out.println(ASK_MOVE_COMMAND);
        String moveCommand = sc.nextLine();
        Matcher matcher = MOVE_COMMAND_PATTERN.matcher(moveCommand);
        if (!matcher.find()) {
            throw new IllegalArgumentException(NOT_FOUND_COMMAND);
        }
        Position source = new Position(matcher.group(1));
        Position target = new Position(matcher.group(2));

        game.move(source, target);
    }

    private static <T> T getOrRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void runOrRetry(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
