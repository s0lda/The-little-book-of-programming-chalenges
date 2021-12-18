import java.util.Scanner;

class ASconverter {
    static String readUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    static int readIntFromInput(String usr_input) {
        boolean isInt = false;
        int number = 0;
        while (!isInt) {
            try {
                number = Integer.parseInt(usr_input);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println("You need to input a number.");
            }
        }
        return number;
    }

    static char asConverter(int mark, int maxMark) {
        char grade = 'Z';
        double pointScore = maxMark / 100;
        if (mark >= (pointScore * 80)) {
            grade = 'A';
        } else if (mark >= (pointScore * 70)) {
            grade = 'B';
        } else if (mark >= (pointScore * 60)) {
            grade = 'C';
        } else if (mark >= (pointScore * 50)) {
            grade = 'D';
        } else if (mark >= (pointScore * 40)) {
            grade = 'E';
        } else if (mark >= (pointScore * 30)) {
            grade = 'F';
        } else {
            grade = 'U';
        }
        return grade;
    }

    static void runConverter() {
        boolean isRunning = true;
        while (isRunning){
            System.out.println("Enter to start or type Exit to exit.");
            String usr_cmd = readUserInput();
            if (usr_cmd.toLowerCase().equals("exit")){
                isRunning = false;
                break;
            } else {
                System.out.println("Enter maximum possible mark.");
                int maxMark = readIntFromInput(readUserInput());
                System.out.println("Enter mark for Module A.");
                int moduleA = readIntFromInput(readUserInput());
                System.out.println("Enter mark for Module B.");
                int moduleB = readIntFromInput(readUserInput());
                int avgScore = (moduleA + moduleB) / 2;
                System.out.println();
                System.out.println("Score for module A: " + asConverter(moduleA, maxMark));
                System.out.println("Score for module B: " + asConverter(moduleB, maxMark));
                System.out.println("Your AS level is: " + asConverter(avgScore, maxMark));
            }
        }
    }

    public static void main(String[] args) {
        runConverter();
    }
}
