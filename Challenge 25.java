import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class DealCard {
    private static final String[] types = { "CLubs", "Diamonds", "Hearts", "Spades" };
    private static final String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
    private static final String[] deckOfCards = new String[52];

    static String readUserInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    static int getRandomNumber(int min, int max) {
        Random r = new Random();
        // Make max number inclusive.
        max += 1;
        return r.nextInt(max - min) + min;
    }

    static void generateDeckOfCards() {
        int deckCount = 0;
        for (int t = 0; t < types.length; t++) {
            for (int r = 0; r < ranks.length; r++) {
                String newCard = ranks[r] + " " + types[t];
                deckOfCards[deckCount] = newCard;
                deckCount += 1;
            }
        }
    }

    static int checkCardForPoints(String card) {
        int points = 0;
        if (card.contains("Ace")) {
            points = 1;
        } else if (card.contains("1")) {
            points = 1;
        } else if (card.contains("2")) {
            points = 2;
        } else if (card.contains("3")) {
            points = 3;
        } else if (card.contains("4")) {
            points = 4;
        } else if (card.contains("5")) {
            points = 5;
        } else if (card.contains("6")) {
            points = 6;
        } else if (card.contains("7")) {
            points = 7;
        } else if (card.contains("8")) {
            points = 8;
        } else if (card.contains("9")) {
            points = 9;
        } else {
            points = 10;
        }
        return points;
    }

    static void play() {
        boolean isPlaying = true;
        boolean isServed = false;
        String[] dealtCards = new String[0];
        String card = "Card";
        int turn = 0;
        int playerOnePoints = 0;
        int playerTwoPoints = 0;
        while (isPlaying) {
            System.out.println("Do you want to draw a card? Type Exit to exit");
            String usrInput = readUserInput();
            if (usrInput.toLowerCase().equals("exit")) {
                isPlaying = false;
            } else {
                while (!isServed) {
                    card = deckOfCards[getRandomNumber(0, 51)];
                    if (!Arrays.asList(dealtCards).contains(card)) {
                        dealtCards = Arrays.copyOf(dealtCards, dealtCards.length + 1);
                        dealtCards[turn] = card;
                        isServed = true;
                        System.out.println(card);
                    }
                }
                isServed = false;
            }
            int cardPoints = checkCardForPoints(card);
            if (turn % 2 == 0) {
                if (cardPoints == 1) {
                    if ((playerOnePoints - 11) <= 21) {
                        cardPoints = 11;
                    }
                }
                playerOnePoints += cardPoints;
            } else {
                if (cardPoints == 1) {
                    if ((playerTwoPoints - 11) <= 21) {
                        cardPoints = 11;
                    }
                }
                playerTwoPoints += cardPoints;
            }
            if (playerOnePoints == 21) {
                System.out.println("Player One won.");
                isPlaying = false;
            } else if (playerOnePoints > 21) {
                System.out.println("Player Two won.");
                isPlaying = false;
            } else if (playerTwoPoints == 21) {
                System.out.println("Player Two won.");
                isPlaying = false;
            } else if (playerTwoPoints > 21) {
                System.out.println("Player One won.");
                isPlaying = false;
            }
            System.out.println("Player One: " + playerOnePoints + " Player Two: " + playerTwoPoints);
            turn += 1;
        }
    }

    public static void main(String[] args) {
        generateDeckOfCards();
        play();
    }
}
