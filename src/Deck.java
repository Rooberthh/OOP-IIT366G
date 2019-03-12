import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * Constructor Function
     * A deck consists of 3 suits and 13 cards in each suit
     */
    public Deck() {
        for ( int suit = 0; suit <= 3; suit++ ) {
            for ( int value = 1; value <= 13; value++ ) {
                Card card = new Card(suit,value);
                cards.add(card);
            }
        }
        
        this.shuffle();
    }

    /**
     * Shuffles the deck using a randomly created variable
     * and a simple swap technique that swaps the position of the randomized with the currently looped one
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public int getNumCards() {
    	return cards.size();
    }

    /**
     * Increments cardsUsed so a card is not used multiple times.
     * @return Card
     */
    public Card dealCard() {
        return cards.remove(0);
    }
}
