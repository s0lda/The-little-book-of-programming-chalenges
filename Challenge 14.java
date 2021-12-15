import java.util.Random;
import java.util.Scanner;

class HigherLowerGame {
    static int lives = 2;
    static int turns_left = 10;
    static int correct_guesses = 0;
    static int current_number = getRandomNumber(1, 13);
    static int next_number;

    static int getRandomNumber(int start_range, int end_range) {
        Random r = new Random();
        // Make max number inclusive.
        end_range += 1;
        return r.nextInt(end_range - start_range) + start_range;
    }

    static void checkNextNumber() {
        while (next_number == current_number) {
            next_number = getRandomNumber(1, 13);
        }
    }

    static String getUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome in guess game. Let\'s see if you can guess if next number is lower or higher.");
        System.out.println("I will give you 10 numbers, all you need to do if next number is higher or lower.");
        System.out.println("If you think next number will be the same as current number, choose H.");
        System.out.println("You have 2 lives. Be careful. Numbers will be from 1 to 13.");

        while (turns_left > 0 && lives > 0) {
            next_number = getRandomNumber(1, 13);
            checkNextNumber();
            System.out.println("Current number is: " + current_number);
            System.out.println("Is next number going to be higher or lower? L or H?");
            String guess = getUserInput();
            switch (guess.toLowerCase()) {
                case "l":
                    if (next_number > current_number) {
                        lives -= 1;
                        System.out.println("Wrong guess.");
                        break;
                    } else {
                        correct_guesses += 1;
                        System.out.println("Right answer.");
                        break;
                    }
                case "h":
                    if (next_number > current_number) {
                        correct_guesses += 1;
                        System.out.println("Right answer.");
                        break;
                    } else {
                        lives -= 1;
                        System.out.println("Wrong answer.");
                        break;
                    }
                default:
                    System.out.println("Choose L or H.");
            }
            turns_left -= 1;
            current_number = next_number;

            if (lives == 0) {
                System.out.println("You've lost. No more lives left.");
            } else if (correct_guesses == 10) {
                System.out.println("Champ! All numbers guessed right.");
            }
            System.out.println();
        }
        System.out.println("Lives left: " + lives + " Correct Guesses: " + correct_guesses);
    }
}
