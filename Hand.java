import java.util.ArrayList;
import java.util.Random;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private Deck deck = new Deck();
    private int value = 0;

    public Hand() {
        System.out.println();

        for (int i = 0; i < 2; i++) {
            // System.out.println("Value: " + value);

            addNewCard();
            // value += deck.deck.get(num).getValue();
        }

        // System.out.println(hand);
    }

    public void addNewCard() {
        Random rand = new Random();
        int num = rand.nextInt(0, deck.deck.size());
        Card card = deck.deck.get(num);
        hand.add(card);
        deck.removeCardFromDeck(card);
        // System.out.println("Number before: " + getHandValue());
        // System.out.println("Card suit: " + (deck.deck.get(num).displayCard()));
        // System.out.println("Value inside: " + value);
        value += card.getValue();

        // System.out.println("Added: " + card.getValue());
        // System.out.println("Value after: " + value);

        // System.out.println("Number increased by: " + deck.deck.get(num).getValue());
        // System.out.println("Value increased:" + value);

    }

    public ArrayList<Card> displayAllCards() {
        return hand;
    }

    public int getHandValue() {
        return this.value;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setVal(int val) {
        this.value = val;
    }
}
