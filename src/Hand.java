import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int value;
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public int cardCount() {
		return cards.size();
	}
	
	public int totalHandValue() {
		this.value = 0;
				
		for(Card card : cards) {
			int cardValue = card.getValue();
			//Special case for aces, ace can be either 1 or 11
			 switch (cardValue) {
             case 1:
                 cardValue = 11;
                 if (value + cardValue > 21) {
                     cardValue = 1;
                 }
                 break;
             case 11:
                 cardValue = 10;
                 break;
             case 12:
                 cardValue = 10;
                 break;
             case 13:
                 cardValue = 10;
                 break;
             default:
                 break;
			 }
			

			
			value += cardValue;
		}
		return value;
	}
	
	public boolean isBust() {
		if(this.totalHandValue() > 21) {
			return true;
		}
		
		return false;
	}
	
	public boolean isBlackJack() {
		if(this.totalHandValue() == 21) {
			return true;
		}
		return false;
	}
}
