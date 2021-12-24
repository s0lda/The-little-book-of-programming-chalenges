import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class ScoreManager {
    private static Map<String, int[]> scores = new HashMap<String, int[]>();;
    
    static void addScore(String type, int score) {
        /** type: Home or Away, score: 2- win, 1- draw, 0- lost. */

        try {
            int[] typeScores = scores.get(type);
            int typeScoresSize = typeScores.length;
            typeScores = Arrays.copyOf(typeScores, typeScores.length + 1);
            typeScores[typeScoresSize] = score;
            scores.put(type, typeScores);
        } catch (NullPointerException e) {
            int[] firstScore = { score };
            scores.put(type, firstScore);
        }
    }

    static void printScores() {
        int[] homeScores = scores.get("Home");
        int[] awayScores = scores.get("Away");
        System.out.println("Home Scores:");
        int homeCount = 0;
        for (int i = 0; i < homeScores.length; i++) {
            homeCount += 1;
            System.out.print(homeScores[i] + ", ");
        }
        System.out.println("Games played at Home: " + homeCount);
        System.out.println("Away Scores: ");
        int awayCount = 0;
        for (int i = 0; i < awayScores.length; i++) {
            awayCount += 1;
            System.out.print(awayScores[i] + ", ");
        }
        System.out.println("Games played Away: " + awayCount);
    }

    static void test() {
        for (int i = 0; i < 10; i++) {
            addScore("Home", getRandomNumber(0, 2));
            addScore("Away", getRandomNumber(0, 2));
        }
    }

    static int getRandomNumber(int min, int max) {
        Random r = new Random();
        // Make max number inclusive.
        max += 1;
        return r.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        test();
        printScores();
    }
}
