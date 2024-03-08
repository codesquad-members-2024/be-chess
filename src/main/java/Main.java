import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();


        if (command.equals("start")) {
            while (true) {
                String secondCommand = scanner.nextLine();

                if (secondCommand.equals("end")) {
                    break;
                }
            }
        }
    }
}
