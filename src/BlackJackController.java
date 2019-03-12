import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

public class BlackJackController {
	BlackJack game;
	GameBoard board;
	
	BlackJackController(BlackJack game, GameBoard board){
		this.game = game;
		this.board = board;
		
		this.board.addHitListener(new HitListener());
		this.board.addStayListener(new StayListener());
	}
	
	private void exit() {
		
		board.btnHit.setEnabled(false);
		board.btnStay.setEnabled(false);
		
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                System.exit(0);
		            }
		        }, 3000
		);
	}
	
	class HitListener implements ActionListener {
			
		public void actionPerformed(ActionEvent e) {
			
			board.UserPanel.removeAll();
			Player player = game.getUser();
			
			player.getHand().addCard(game.getDeck().dealCard());
			
			for (int i = 0; i < player.getHand().cardCount(); i++) {
	            String cardName = player.getHand().getCards().get(i).toString();
	      
	            try {
					board.UserPanel.add(new CardPanel(cardName));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
			
			if(player.getHand().isBust()) {
				board.showGameMessage("You busted with: " + player.getHand().totalHandValue() + " game auto-closes in approx 3s");
				exit();
				
				return;
			} else if (player.getHand().isBlackJack()) {
				board.showGameMessage("You got BlackJack!");
				exit();
				
				return;
			}
	
			board.showGameMessage("You currently have: " + player.getHand().totalHandValue());
			board.revalidate();
			
		}
	}

	class StayListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			board.DealerPanel.removeAll();
			Dealer dealer = game.getDealer();
			
			game.dealerHit();
			
			for (int i = 0; i < dealer.getHand().cardCount(); i++) {
	            String cardName = dealer.getHand().getCards().get(i).toString();
	      
	            try {
					board.DealerPanel.add(new CardPanel(cardName));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
			
			board.revalidate();
			
			if(game.isWin()) {
				board.showGameMessage("You won with: " + game.getUser().getHand().totalHandValue());
				exit();
			} else {
				board.showGameMessage("The dealer won with " + game.getDealer().getHand().totalHandValue());
				exit();
			}
		}
	
	}
}
