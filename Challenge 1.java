import java.util.Scanner;

class Joke {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
        System.out.println("Press ENTER if you want to see a joke.");
        System.out.println("Type EXIT to exit.");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        
        tellJoke(input);
        sc_input.close();
    }

    public static void tellJoke(String input) {
        if (!input.equals("exit")) {
            System.out.println(ANSI_RED + "Why don't scientists trust atoms?");
            System.out.println(ANSI_GREEN + "Because they make up everything." + ANSI_RESET);
        }
    }
}