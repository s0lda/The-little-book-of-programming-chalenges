import java.util.Scanner;

class ReverseSentence {
    static String getUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    static String reverseText(String sentence) {
        String reversed = new StringBuilder(sentence).reverse().toString();
        return reversed;
    }

    static int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }
        String[] words = sentence.split("\\s+");
        return words.length;
    }
    public static void main(String[] args) {
        System.out.println("Input your sentence.");
        String usr_input = getUserInput();
        int word_count = countWords(usr_input);
        System.out.println("Number of words: " + word_count);
        String reversed = reverseText(usr_input);
        System.out.println("Reversed sentence: " + reversed);
    }
}
