import java.util.Random;

public class babyBlackjack {

    public static void main(String[] args) {
        Random rand = new Random();

        int playerCard1 = rand.nextInt(10) +1;
        int playerCard2 = rand.nextInt(10) +1;
        int playerTotal = playerCard1 + playerCard2;

        int dealerCard1 = rand.nextInt(10) +1;
        int dealerCard2 = rand.nextInt(10) +1;
        int dealerTotal = dealerCard1 + dealerCard2;

        System.out.println("Baby Blackjack!\n");

        System.out.format("You drew %d and %d.\n", playerCard1, playerCard2);
        System.out.format("Your total is %d.\n\n", playerTotal);

        System.out.format("The dealer has a %d and %d.\n", dealerCard1, dealerCard2);
        System.out.format("Dealer's total is %d.\n\n", dealerTotal);

        if (playerTotal > dealerTotal) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("DEALER WINS!");
        }
    }
}
