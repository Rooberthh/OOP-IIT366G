
public class BlackJack {
	private User player;
	private Dealer dealer;
	private Deck deck;
	
	BlackJack(){
		this.player= new User("Roberth");
		this.dealer = new Dealer();
		this.deck = new Deck();
		deal();
	}
	
	public Player getUser() {
		return player;
	}
	
	public Dealer getDealer() {
		return dealer;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	private void deal() {
		if(deck.getNumCards() < 10) {
			deck = new Deck();
		}
		
		for(int i = 0; i < 2; i++) {
			player.getHand().addCard(deck.dealCard());
			dealer.getHand().addCard(deck.dealCard());
		}
		
		isWin();
	}
	
	void dealerHit() {
		while(dealer.getHand().totalHandValue() < 17) {
			dealer.getHand().addCard(deck.dealCard());
		}
		
	}
	
	void playerHit() {
		player.getHand().addCard(deck.dealCard());
		
		if(player.getHand().isBust()) {
			System.out.println("Player Busted");
		}
	}
	
	boolean isWin() {
		if ((player.getHand().totalHandValue() > dealer.getHand().totalHandValue() && player.getHand().totalHandValue() <= 21) || dealer.getHand().totalHandValue() > 21) {
			return true;
		}
		
		return false;
	}
	
	void stay() {
		dealerHit();
		isWin();
	}
}
