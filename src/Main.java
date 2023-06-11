import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.print("Please enter your input: ");
            input = scanner.nextLine();

            if (input.toLowerCase().equals("quit"))
                break;
            
            if (input.toLowerCase().equals("pass"))
                continue;

            System.out.println("Your input was " + input);
        }

        scanner.close();
    }
}