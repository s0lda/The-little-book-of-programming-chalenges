import java.util.Scanner;

class SayHello {
    public static void main(String[] args) {
        System.out.println("Please enter your name: ");
        try (Scanner sc_input = new Scanner(System.in)) {
            String input = sc_input.nextLine();
            System.out.println("Hello " + input + ".");
        }
    }
}
