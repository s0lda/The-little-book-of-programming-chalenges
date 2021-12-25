import java.util.Random;
import java.util.Scanner;

class Codebreaker {
    static String readUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }
    
    static int getRandomNumber(int min, int max) {
        Random r = new Random();
        // Make max number inclusive.
        max += 1;
        return r.nextInt(max - min) + min;
    }

    static void play(int secretNumber) {
        String secretNumberString = Integer.toString(secretNumber);
        boolean isGuessing = true;
        int guesses = 1;
        while ((guesses < 13) && (isGuessing)) {
            String usrGuess = readUserInput();
            if (usrGuess.equals(secretNumberString)) {
                isGuessing = false;
                System.out.println("That is corrects. Attempts: " + guesses);
            } else {
                char[] secretCharList = secretNumberString.toCharArray();
                char[] guessCharList = usrGuess.toCharArray();
                int minLength = Math.min(secretCharList.length, guessCharList.length);
                for (int i = 0; i < minLength; i++) {
                    if (secretCharList[i] != guessCharList[i]) {
                        System.out.print("*");
                    } else {
                        System.out.print(secretCharList[i]);
                    }
                }
                System.out.println();
            }
            guesses += 1;
        }
    }

    public static void main(String[] args) {
        int secretNumber = getRandomNumber(1000, 9999);
        System.out.println(secretNumber);
        play(secretNumber);
    }
}
