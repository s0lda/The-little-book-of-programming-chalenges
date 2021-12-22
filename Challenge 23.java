import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class FindTheTreasure {
    static int getRandomNumber(int start_range, int end_range) {
        Random r = new Random();
        // Make max number inclusive.
        end_range += 1;
        return r.nextInt(end_range - start_range) + start_range;
    }

    static String readUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    static int readUserIntInput(String usrIntInput) {
        boolean isChecking = true;
        int number = 34404;
        while (isChecking) {
            try {
                number = Integer.parseInt(usrIntInput);
                isChecking = false;
            } catch (NumberFormatException e) {
                System.out.println("You need to input a number.");
            }
        }
        return number;
    }
    
    static int[][] createTheBoard() {
        int[][] board = new int[10][10];
        int treasureX = getRandomNumber(0, 9);
        int treasureY = getRandomNumber(0, 9);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if ((x == treasureX) && (y == treasureY)) {
                    board[x][y] = 1;
                } else {
                    board[x][y] = 0;
                }
            }
        }
        // Line below to display the board is for testing purposes. comment it out or remove
        // to play.
        System.out.println(Arrays.deepToString(board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        return board;
    }

    static void play() {
        int[][] board = createTheBoard();
        boolean isPlaying = true;
        while (isPlaying) {
            System.out.println("Press enter to find treasure or type exit to exit.");
            String usrInput = readUserInput();
            if (usrInput.toLowerCase().equals("exit")) {
                isPlaying = false;
                break;
            } else {
                System.out.println("Enter coordinates.");
                System.out.println("X: ");
                int x = readUserIntInput(readUserInput());
                System.out.println("Y:");
                int y = readUserIntInput(readUserInput());
                if (board[x][y] == 1) {
                    System.out.println("Treasure is yours.");
                    board = createTheBoard();
                } else {
                    System.out.println("Keep looking.");
                }
            }
        }
    }
    public static void main(String[] args) {
        play();
    }
}