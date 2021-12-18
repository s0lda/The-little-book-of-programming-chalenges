import java.util.Scanner;

class DrawStarsPyramid {
    
    static int readIntFromInput() {
        boolean isInt = false;
        int number = 0;
        while (!isInt) {
            System.out.print(">> ");
            Scanner sc_input = new Scanner(System.in);
            String usr_input = sc_input.nextLine();
            try {
                int usrInt = Integer.parseInt(usr_input);
                if ((usrInt % 2) == 0) {
                    number = usrInt;
                    isInt = true;
                } else {
                    System.out.println("Number must be odd.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You need to input a number.");
            }
        }
        return number;
    }

    static void drawLineOfStars(int space, int star) {
        StringBuilder line = new StringBuilder();
        String starString = "*";
        String spaceString = " ";

        int spaceEndIndex = space - 1;
        int starStartIndex = space;
        int starEndIndex = spaceEndIndex + star;

        for (int spaceI = 0; spaceI <= spaceEndIndex; spaceI++) {
            line.insert(spaceI, spaceString);
        }
        for (int starI = starStartIndex; starI <= starEndIndex; starI++) {
            line.insert(starI, starString);
        }
        System.out.println(line);
    }

    static void drawPyramidOfStars(int base) {
        int baseSpace = 0;
        int space = (base - 1) / 2;
        int star = 1;
        while (star != base) {
            drawLineOfStars(space, star);
            star += 2;
            space -= 1;
        }
        drawLineOfStars(baseSpace, base);
    }

    public static void main(String[] args) {
        System.out.println("How many stars would you like in the base of your pyramid?");
        int base = readIntFromInput();
        drawPyramidOfStars(base);
    }
}
