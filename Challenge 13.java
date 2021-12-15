import java.util.Random;
import java.util.Scanner;

class Eliminator {
    static int turn = 0;
    static int starting_number;

    static int getRandomNumber(int start_range, int end_range) {
        Random r = new Random();
        // Make max number inclusive.
        end_range += 1;
        return r.nextInt(end_range - start_range) + start_range;
    }

    static int getAndValidateUserChoice() {
        boolean correct = false;
        int value = 0;
        while (correct == false) {
            System.out.print(">> ");
            Scanner sc_input = new Scanner(System.in);
            String usr_input = sc_input.nextLine();
            try {
                int number = Integer.parseInt(usr_input);
                if (number >= 1 && number <= 3) {
                    value = number;
                    correct = true;
                } else {
                    System.out.println("You need to choose between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You need to input a number.");
            }
        }
        return value;
    }

    public static void main(String[] args) {
        starting_number = getRandomNumber(20, 30);
        while (starting_number > 0) {
            System.out.println("The number is: " + starting_number);
            if (turn % 2 == 0) {
                System.out.println("Choose your number.");
                int player_choice = getAndValidateUserChoice();
                starting_number -= player_choice;
            } else {
                System.out.println("Computer is choosing.");
                int computer_choice = Computer.getComputerChoice();
                starting_number -= computer_choice;
                System.out.println(">> " + computer_choice);
            }
            turn += 1;
        }
        // As turn is added after every move, this one have to be the opposite.
        // If computer will go <= 0 that will still add turn at the end.
        if (turn % 2 == 0) {
            System.out.println("You won.");
        } else {
            System.out.println("Computer won.");
        }
    }
}

    class Computer {
        static int getComputerChoice() {
            return Eliminator.getRandomNumber(1, 3);
        }
    }
