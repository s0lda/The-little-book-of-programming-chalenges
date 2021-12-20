import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class Secret {

    static int getRandomNumber(int start_range, int end_range) {
        Random r = new Random();
        // Make max number inclusive.
        end_range += 1;
        return r.nextInt(end_range - start_range) + start_range;
    }

    static void encryptoDecryptor(String text, String mode, String key) throws Exception {
        switch (mode) {
            case "encrypt":
                List<Character> encryptedMessage = new ArrayList<Character>();
                List<Integer> offSetList = new ArrayList<Integer>();
                for (int i = 0; i < text.length(); i++) {
                    char letter = text.charAt(i);
                    int ascii = (int) letter;
                    int randomOffSet = getRandomNumber(1, 5);
                    ascii += randomOffSet;
                    char encryptedLetter = (char) ascii;
                    encryptedMessage.add(encryptedLetter);
                    offSetList.add(randomOffSet);
                }
                String offSetString = offSetList.stream().map(Object::toString).collect(Collectors.joining(", "));
                offSetString = offSetString.replace(", ", "");
                System.out.println("Key: " + offSetString);
                String encryptedMsg = encryptedMessage.stream().map(Object::toString).collect(Collectors.joining(", "));
                encryptedMsg = encryptedMsg.replace(", ", "");
                System.out.println("Message: " + encryptedMsg);
                break;
            case "decrypt":
                List<Character> decryptedMessageList = new ArrayList<Character>();
                for (int i = 0; i < text.length(); i++) {
                    char encryptedLetter = text.charAt(i);
                    char offSet = key.charAt(i);
                    int offSetInt = Integer.parseInt(String.valueOf(offSet));
                    int ascii = (int) encryptedLetter;
                    ascii -= offSetInt;
                    char letter = (char) ascii;
                    decryptedMessageList.add(letter);
                }
                String decryptedMessage = decryptedMessageList.stream().map(Object::toString).collect(Collectors.joining(", "));
                decryptedMessage = decryptedMessage.replace(", ", "");
                System.out.println(decryptedMessage);
                break;
            default:
                throw new Exception("Wrong mode. Please check your mode parameter.");
        }

    }
    public static void main(String[] args) throws Exception {
        encryptoDecryptor("Hello", "encrypt", "key");
        encryptoDecryptor("Minot", "decrypt", "54235");
    }
}
