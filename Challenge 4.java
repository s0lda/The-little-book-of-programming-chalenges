import java.util.InputMismatchException;
import java.util.Scanner;

class TravelAssistant {
    public static int getNumber () {
        int input = 0;
        boolean correct = true;
        while (correct) {
            try {
                System.out.print(">> ");
                Scanner sc_input = new Scanner(System.in);
                input = sc_input.nextInt();
                correct = false;
            } catch (InputMismatchException Integer) {
                System.out.println("You need to use numbers.");
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("How far you traveled, press 1.");
        System.out.println("How fast you need to drive to arrive on time, press 2.");
        System.out.println("Press 3 to Exit.");
        boolean run = true;
        while (run == true) {
            int choice = getNumber();
            if (choice == 1) {
                System.out.println("What was your speed?");
                double speed = getNumber();
                System.out.println("How long have you been driving for? In minutes.");
                double time = getNumber();
                double distance = (speed / 60) * time;
                System.out.println("Distance you have traveled is " + Math.round(distance) + " km.");
            }
            else if (choice == 2) {
                System.out.println("How far do you want to travel? in km.");
                double distance = getNumber();
                System.out.println("How long do you have to get there? In minutes.");
                double time = getNumber();
                double speed = (distance / time) * 60;
                System.out.println("You need to drive " + Math.round(speed) + " km/h to get there on time.");
            }
            else if (choice == 3) {
                run = false;
            }
            else {
                System.out.println("You need to choose 1, 2 or 3.");
            }
        }
    }
}
