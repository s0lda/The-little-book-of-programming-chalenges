import java.util.Random;
import java.util.Scanner;

class GuessTheNumber {
    static int secretNumber;
    static int guessAttempts = 0;
    static Computer COMPUTER = new Computer();
    static Player PLAYER = new Player();

    final static String getUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    final static int findRandomNumberInRange(int min, int max) {
        Random r = new Random();
        // max number inclusive
        max += 1;
        return r.nextInt(max - min) + min;
    }

    static String startTheGame() {
        boolean isChoosingPlayer = true;
        String whoIsPlaying = "";

        System.out.println("Do you want to guess the number or do you want me to guess?");
        System.out.println("Choose H for Human if you want to guess or C for Computer if you want computer to guess.");

        while (isChoosingPlayer) {
            String input = getUserInput();
            switch (input.toUpperCase()) {
                case "H":
                    whoIsPlaying = "Player";
                    isChoosingPlayer = false;
                    break;
                case "C":
                    whoIsPlaying = "Computer";
                    isChoosingPlayer = false;
                    break;
                default:
                    System.out.println("You need to choose who is playing.");
            }
        }
        return whoIsPlaying;
    }

    static void computerIsPlaying() {
        boolean playerChoosingSecretNumber = true;
        System.out.println("OK, pick a number between 1 and 100 and let me guess it.");

        while (playerChoosingSecretNumber) {
            int playerSecretNumber = PLAYER.playerChoice();
            if ((playerSecretNumber >= 1) && (playerSecretNumber <= 100)) {
                secretNumber = playerSecretNumber;
                playerChoosingSecretNumber = false;
            } else {
                System.out.println("You need to choose number between 1 and 100.");
            }
        }
        int computerNumber = COMPUTER.computerChoice();
        guessAttempts += 1;

        while (computerNumber != secretNumber) {
            System.out.println("Computer is guessing it could be " + computerNumber + ".");
            if (computerNumber > secretNumber) {
                COMPUTER.setComputerMaxRange(computerNumber - 1);

            } else {
                COMPUTER.setComputerMinRange(computerNumber + 1);
            }
            computerNumber = COMPUTER.computerChoice();
            guessAttempts += 1;
        }
        System.out.println("I found your number. Number of attempts: " + guessAttempts + ".");
        guessAttempts = 0;
        COMPUTER.setComputerMaxRange(100);
        COMPUTER.setComputerMinRange(1);
    }

    static void playerIsPlaying() {
        System.out.println("I've choosen number for you. Try to guess it.");
        secretNumber = COMPUTER.computerChoice();
        int playerNumber = PLAYER.playerChoice();
        guessAttempts += 1;
        while (playerNumber != secretNumber) {
            if (playerNumber > secretNumber) {
                System.out.println("Wrong guess. Number too high.");
            } else {
                System.out.println("Wrong guess. Number too low.");
            }
            playerNumber = PLAYER.playerChoice();
            guessAttempts += 1;
        }
        System.out.println("You found my number. Number of attempts: " + guessAttempts + ".");
        guessAttempts = 0;
    }

    static void playTheGame() {
        boolean isGameOn = true;
        System.out.println("Welcome to the Guess the Number Game.");
        while (isGameOn) {
            System.out.println("Do you want to play the game? Y/N");
            String usr_choice = getUserInput();
            switch (usr_choice.toUpperCase()) {
                case "Y":
                    String whoIsPlaying = startTheGame();
                    switch (whoIsPlaying) {
                        case "Player":
                            playerIsPlaying();
                            break;
                        case "Computer":
                            computerIsPlaying();
                            break;
                    }
                    break;
                case "N":
                    isGameOn = false;
                    break;
                default:
                    System.out.println("You need to choose Y or N.");
            }
        }
    }

    static class Player {

        int playerChoice() {
            boolean isChoosing = true;
            int choice = 0;

            while (isChoosing) {
                String input = GuessTheNumber.getUserInput();
                try {
                    choice = Integer.parseInt(input);
                    isChoosing = false;
                } catch (NumberFormatException e) {
                    System.out.println("You need to input a number.");
                }
            }
            return choice;
        }
    }

    static class Computer {
        static int computerMaxRange = 100;
        static int computerMinRange = 1;

        int getComputerMaxRange() {
            return computerMaxRange;
        }

        void setComputerMaxRange(int num) {
            computerMaxRange = num;
        }

        int getComputerMinRange() {
            return computerMinRange;
        }

        void setComputerMinRange(int num) {
            computerMinRange = num;
        }

        int computerChoice() {
            return GuessTheNumber.findRandomNumberInRange(computerMinRange, computerMaxRange);
        }

    }

    public static void main(String[] args) {
        playTheGame();
    }
}
