public class Main {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		User user = new User("Roberth");
		
		
		BlackJack game = new BlackJack();
		GameBoard board = new GameBoard(game);
		
		new BlackJackController(game, board);
	}

}
