import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Challenge21 {
    static String readUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    static void printDuplicates(String[] listOfEntries) {
        Map<String, Integer> entriesMap = new HashMap<String, Integer>();
        for (int i = 0; i < listOfEntries.length; i++) {
            if (entriesMap.containsKey(listOfEntries[i])) {
                entriesMap.merge(listOfEntries[i], 1, Integer::sum);
            } else {
                entriesMap.put(listOfEntries[i], 1);
            }
        }
        entriesMap.forEach((key, value) -> {
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
