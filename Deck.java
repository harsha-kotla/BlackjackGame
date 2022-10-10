import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public static ArrayList<Card> deck = new ArrayList<Card>();
    String[] possibleRanks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    int[] possibleValues = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1 };
    String[] possibleSuits = { "Heart", "Spade", "Club", "Diamond" };

    public Deck() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(possibleSuits[j], possibleRanks[i], possibleValues[i]));
            }
        }
        Collections.shuffle(deck);
    }

    public void removeCardFromDeck(Card card) {
        deck.remove(card);
    }
}
