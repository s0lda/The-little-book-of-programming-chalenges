import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

class LogicGate {

    static String getUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    static boolean checkForLogicType(String usr_input) {
        String[] logic_type = { "BUFFER", "NOT", "AND", "OR", "NAND", "NOR", "XOR", "XNOR" };
        boolean confirm_type = false;
        for (String i : logic_type) {
            if (usr_input.toUpperCase().equals(i)) {
                confirm_type = true;
            }
        }
        return confirm_type;
    }

    static int getIntFromUsrInput(String num_choice) {
        boolean correct = false;
        int value = 0;
        while (correct == false) {
            System.out.println("Input your" + num_choice + "number:");
            String usr_input = getUserInput();
            try {
                int number = Integer.parseInt(usr_input);
                if (number == 0 || number == 1) {
                    value = number;
                    correct = true;
                } else {
                    System.out.println("You need to choose 0 or 1.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You need to input a number.");
            }
        }
        return value;
    }

    static int getLogicGateOutput(String type, int first_num, int second_num) {
        int output = 0;
        switch (type) {
            case "BUFFER":
                if (first_num == 0) {
                    output = 0;
                    break;
                } else {
                    output = 1;
                    break;
                }
            case "NOT":
                if (first_num == 0) {
                    output = 1;
                    break;
                } else {
                    output = 0;
                    break;
                }
            case "AND":
                if (first_num == 0 && second_num == 0) {
                    output = 0;
                    break;
                } else if (first_num == 1 && second_num == 0) {
                    output = 0;
                    break;
                } else if (first_num == 0 && second_num == 1) {
                    output = 0;
                    break;
                } else {
                    output = 1;
                    break;
                }
            case "OR":
                if (first_num == 0 && second_num == 0) {
                    output = 0;
                    break;
                } else if (first_num == 1 && second_num == 0) {
                    output = 1;
                    break;
                } else if (first_num == 0 && second_num == 1) {
                    output = 1;
                    break;
                } else {
                    output = 1;
                    break;
                }
            case "NAND":
                if (first_num == 0 && second_num == 0) {
                    output = 1;
                    break;
                } else if (first_num == 1 && second_num == 0) {
                    output = 1;
                    break;
                } else if (first_num == 0 && second_num == 1) {
                    output = 1;
                    break;
                } else {
                    output = 0;
                    break;
                }
            case "NOR":
                if (first_num == 0 && second_num == 0) {
                    output = 1;
                    break;
                } else if (first_num == 1 && second_num == 0) {
                    output = 0;
                    break;
                } else if (first_num == 0 && second_num == 1) {
                    output = 0;
                    break;
                } else {
                    output = 0;
                    break;
                }
            case "XOR":
                if (first_num == 0 && second_num == 0) {
                    output = 0;
                    break;
                } else if (first_num == 1 && second_num == 0) {
                    output = 1;
                    break;
                } else if (first_num == 0 && second_num == 1) {
                    output = 1;
                    break;
                } else {
                    output = 0;
                    break;
                }
            case "XNOR":
                if (first_num == 0 && second_num == 0) {
                    output = 1;
                    break;
                } else if (first_num == 1 && second_num == 0) {
                    output = 0;
                    break;
                } else if (first_num == 0 && second_num == 1) {
                    output = 0;
                    break;
                } else {
                    output = 1;
                    break;
                }

        }
        return output;
    }
    
    public static void main(String[] args) {
        boolean run = true;
        
        System.out.println("BUFFER, NOT, AND, OR, NAND, NOR, XOR, XNOR");
        System.out.println("Input can be either 0 or 1.");
        System.out.println("EXIT to exit.");

        while (run == true) {
            System.out.println("What logic gate do you want to work with?");
            String usr_logic = getUserInput();
            usr_logic = usr_logic.toUpperCase();

            if (usr_logic.equals("EXIT")) {
                run = false;
            }
            if (run == true) {
                if (checkForLogicType(usr_logic) == true) {
                    // If output won't be 0 or 1, then I know there is and error.
                    int result = 34404;
                    if (usr_logic.equals("BUFFER") || usr_logic.equals("NOT")) {
                        int first_num = getIntFromUsrInput(" ");
                        // Pass 0 as second parameter, as method requires. BUFFER and NOT 
                        // have only one parameter. Second one will be unused.
                        result = getLogicGateOutput(usr_logic, first_num, 0);
                    } else {
                        int first_num = getIntFromUsrInput(" first ");
                        int second_num = getIntFromUsrInput(" second ");
                        result = getLogicGateOutput(usr_logic, first_num, second_num);
                    }
                    System.out.println("Output: " + result);
                } else {
                    System.out.println("Wrong input, please choose from the list: ");
                    System.out.println("BUFFER, NOT, AND, OR, NAND, NOR, XOR, XNOR");
                }
            }
        }
    }
}