public class Card {
    /*
    * Final Static Variables for Constants such as Suits and Face Cards
    * */
    private final static int SPADES = 0;
    private final static int HEARTS = 1;
    private final static int DIAMONDS = 2;
    private final static int CLUBS = 3;

    private final static int ACE = 1;
    private final static int JACK = 11;
    private final static int QUEEN = 12;
    private final static int KING = 13;

    private int suit;
    private int value;

    /**
     * @param theSuit the suit of the card
     * @param theValue a cards value eg 7
     * Constructor for a card
     */
    public Card (int theSuit, int theValue)
    {
        if ((theValue < 1 || theValue > 13)) {
            throw new IllegalArgumentException("The value of the playing card is not correct");
        }
               
        this.suit = theSuit;
        this.value = theValue;
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

    /**
     * @return String representation of a cards suit
     */
    public String getSuitAsString() {
        switch (suit) {
            case SPADES:   return "Spades";
            case HEARTS:   return "Hearts";
            case DIAMONDS: return "Diamonds";
            case CLUBS:    return "Clubs";
            default:       return "Spades";
        }
    }

    /**
     * @return String representation of a cards value
     */
    public String getValueAsString() {
        switch (value) {
            case ACE:   return "Ace";
            case 2:   return "2";
            case 3:   return "3";
            case 4:   return "4";
            case 5:   return "5";
            case 6:   return "6";
            case 7:   return "7";
            case 8:   return "8";
            case 9:   return "9";
            case 10:  return "10";
            case JACK:  return "Jack";
            case QUEEN:  return "Queen";
            case KING:  return "King";
            default: return "There was an error getting the Value of the card!";
        }
    }

    /**
     * @return String representation of a card object
     */
    public String toString() {
        return getValueAsString().toLowerCase() + "_of_" + getSuitAsString().toLowerCase() + ".png";
    }
}
