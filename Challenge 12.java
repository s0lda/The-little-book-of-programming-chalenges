import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NumberFactors {
    static int getUserIntInput() {
        boolean check = false;
        int output = 34404;
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        while (check == false) {
            String usr_input = sc_input.nextLine();
            try {
                int number = Integer.parseInt(usr_input);
                if (number > 2) {
                    output = number;
                    check = true;
                } else {
                    System.out.println("You need to input number bigger than 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You need to input a number.");
            }
        }
        return output;
    }

    static void printNumberFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        for (int i: factors) {
            System.out.print(i + ", ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Factors of what number do you want to know?");
        int usr_number = getUserIntInput();
        System.out.println("Factor of number " + usr_number + ":");
        printNumberFactors(usr_number);
    }
}
