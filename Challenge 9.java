import java.util.Random;
import java.util.Scanner;

class CardPicker {
    static String[] types = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public static String getRandomElement(String[] array) {
        Random r = new Random();
        int random_index = r.nextInt(array.length);
        return array[random_index];
    }

    public static String getInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    public static void main(String[] args) {
        boolean run = true;
        System.out.println("Press any key to pick a card, Exit to exit.");
        while (run == true) {
            String type = getRandomElement(types);
            String rank = getRandomElement(ranks);
            String result = rank + " " + type;
            String input = getInput();
            if (input.toLowerCase().equals("exit")) {
                run = false;
            } else {
                System.out.println(result);                
            }
        }
    }
}
