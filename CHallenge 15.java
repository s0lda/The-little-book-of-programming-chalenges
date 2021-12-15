import java.util.Scanner;

class ReverseSentence {
    static String getUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    static String reverseText(String to_reverse) {
        String reversed = new StringBuilder(to_reverse).reverse().toString();
        return reversed;
    }
    public static void main(String[] args) {
        System.out.println("Input sentence you want to reverse.");
        String usr_input = getUserInput();
        String reversed = reverseText(usr_input);
        System.out.println(reversed);
    }
}
