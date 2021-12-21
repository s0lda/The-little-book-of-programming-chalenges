import java.util.Arrays;

class Fibonacci {
    static int[] Generator(int num) {
        int[] fibNums = {0, 1};
        for (int i = 2; i <= num; i++) {
            int newFib = (fibNums[i - 1] + (fibNums[i - 2]));
            fibNums = Arrays.copyOf(fibNums, (fibNums.length + 1));
            fibNums[i] = newFib;
        }
        return fibNums;
    }

    public static void main(String[] args) {
        // Generate list of Fib Numbers.
        int[] listofFibNums = Generator(30);
        // Print number from position.
        System.out.println(listofFibNums[12]);
    }
}
