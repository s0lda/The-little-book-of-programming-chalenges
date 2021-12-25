import java.util.Scanner;

class Hangman {
    static String readUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    static void play() {
        int lives = 5;
        boolean isPLaying = true;
        System.out.println("Type a secret word:");
        String secretWord = readUserInput();
        while ((lives != 0) && (isPLaying)) {
            System.out.println("Lives left: " + lives + ".");
            System.out.println("Your guess:");
            String usrGuess = readUserInput();
            if (secretWord.equals(usrGuess)) {
                System.out.println("That is correct.");
                isPLaying = false;
            } else {
                char[] secretWordCharList = secretWord.toCharArray();
                char[] usrGuessCharList = usrGuess.toCharArray();
                if (secretWordCharList.length == usrGuessCharList.length) {
                    for (int i = 0; i < secretWordCharList.length; i++) {
                        if (secretWordCharList[i] != usrGuessCharList[i]) {
                            System.out.print("*");
                        } else {
                            System.out.print(secretWordCharList[i]);
                        }
                    }
                    System.out.println();
                } else if (secretWordCharList.length > usrGuessCharList.length) {
                    System.out.println("Not enough characters.");
                } else {
                    System.out.println("Too many characters.");
                }
            }
            lives -= 1;
        }
    }
    public static void main(String[] args) {
        play();
    }
}
