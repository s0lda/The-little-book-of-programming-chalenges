import java.util.InputMismatchException;
import java.util.Scanner;

class Area {
    public static void main(String[] args) {
        System.out.println("What is the width of your rectangle?");
        int width = getNumber();
        System.out.println("What is the length of your rectangle?");
        int length = getNumber();
        int area = width * length;
        System.out.println("The are of your rectangle is: " + area + ".");

        System.out.println("Is this a cuboid? Yes/No");
        Scanner answer = new Scanner(System.in);
        String ans = answer.nextLine();
        if (ans.equals("yes")) {
            System.out.println("What is the height of your cuboid?");
            int height = getNumber();
            int volume = width * height * length;
            System.out.println("Volume of your cuboid is: " + volume + ".");

        }
        
    }

    public static Integer getNumber() {
        int input = 0;
        try {
            System.out.print(">> ");
            Scanner sc_input = new Scanner(System.in);
            input = sc_input.nextInt();
        } catch (InputMismatchException Integer) {
            System.out.println("You need to use numbers.");
        }
        return input;
    }
}
