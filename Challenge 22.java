import java.util.Arrays;
import java.util.Random;

class RandomMatrix {
    static int getRandomNumber(int start_range, int end_range) {
        Random r = new Random();
        // Make max number inclusive.
        end_range += 1;
        return r.nextInt(end_range - start_range) + start_range;
    }
    
    static void run() {
        int[][] twoDArray = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                twoDArray[x][y] = getRandomNumber(0, 15);
            }
        }
        System.out.println(Arrays.deepToString(twoDArray).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }

    public static void main(String[] args) {
        run();
    }
}