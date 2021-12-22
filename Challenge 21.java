import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.function.Consumer;

class Challenge21 {
    static String readUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    static void printDuplicates(String[] duplicates) {
        Map<String, Integer> duplicatesMap = new HashMap<String, Integer>();
        for (int i = 0; i < duplicates.length; i++) {
            if (duplicatesMap.containsKey(duplicates[i])) {
                duplicatesMap.merge(duplicates[i], 1, Integer::sum);
            } else {
                duplicatesMap.put(duplicates[i], 1);
            }
        }
        duplicatesMap.forEach((key, value) -> {
            if (value > 1) {
                System.out.println("Name: " + key + " is " + value + " times in the list.");
            }});
    }

    static void run(){
        boolean isAcceptingNames = true;
        System.out.println("Enter the names or exit to exit.");
        String[] names = {};
        while (isAcceptingNames) {
            String usrInput = readUserInput();
            if (usrInput.toLowerCase().equals("exit")) {
                isAcceptingNames = false;
                break;
            } else {
                int namesLastIndex = names.length;
                names = Arrays.copyOf(names, names.length + 1);
                names[namesLastIndex] = usrInput;
            }
        }
        printDuplicates(names);
    }

    public static void main(String[] args) {
        run();
    }
}
