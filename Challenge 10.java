import java.util.Random;
import java.util.Scanner;

class RockPaperScissors {
    static int wins = 0;
    static int losses = 0;
    static int ties = 0;

    public static String getUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    public static void getResult(String player, String computer) {
        if (player.equals(computer)) {
            System.out.println("It's a tie.");
            ties += 1;
        } else if (player.toLowerCase().equals("r") && computer.equals("s")) {
            System.out.println("You win.");
            wins += 1;
        } else if (player.toLowerCase().equals("p") && computer.equals("r")) {
            System.out.println("You win.");
            wins += 1;
        } else if (player.toLowerCase().equals("s") && computer.equals("p")) {
            System.out.println("You win.");
            wins += 1;
        } else {
            System.out.println("You loose.");
            losses += 1;
        }
    }

    public static String getComputerMove() {
        String[] hand = { "r", "p", "s" };
        Random r = new Random();
        int random_index = r.nextInt(hand.length);
        return hand[random_index];
    }

    public static void printChoices(String usr_choice, String cmp_choice) {
        if (usr_choice.equals("s")) {
            System.out.println("SCISSORS VS... ");
        } else if (usr_choice.equals("p")) {
            System.out.println("PAPER VS... ");
        } else if (usr_choice.equals("r")) {
            System.out.println("ROCK VS... ");
        } else {
            System.out.println("Are you trying to cheat?");
        }
        if (cmp_choice.equals("r")) {
            System.out.println("ROCK");
        } else if (cmp_choice.equals("s")) {
            System.out.println("SCISSORS");
        } else if (cmp_choice.equals("p")) {
            System.out.println("PAPER");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Enter your move: (r)ock, (p)aper, (s)cissors or (q)uit.");
        boolean run = true;
        while (run == true) {
            System.out.println(wins + " Wins. " + losses + " Losses. " + ties + " Ties. ");
            String usr_choice = getUserInput().toLowerCase();
            String cmp_choice = getComputerMove();
            if (usr_choice.equals("q")) {
                run = false;
            }
            if (run == true) {
                printChoices(usr_choice, cmp_choice);
                getResult(usr_choice, cmp_choice);
                System.out.println();
            }
        }
    }
}
