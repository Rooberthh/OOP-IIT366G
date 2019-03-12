import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameBoard extends JFrame{
	
	private JFrame frame = this;
	private static BlackJack game;
	
	JLabel gameMessage = new JLabel();
	JPanel centerPanel = new JPanel();
	
	JButton btnHit = new JButton("Hit");
	JButton btnStay = new JButton("Stay");
	
	JPanel UserPanel = new JPanel();
	JPanel DealerPanel = new JPanel();

	/**
	 * Create the application.
	 */
	public GameBoard(BlackJack game) {
		GameBoard.game = game;
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initialize() throws IOException {
		frame.setBounds(100, 100, 600, 600);
		
		
		frame.getContentPane().add(DealerPanel, BorderLayout.NORTH);
		DealerPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		
		frame.getContentPane().add(UserPanel, BorderLayout.SOUTH);
		UserPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel ActionPanel = new JPanel();
		frame.getContentPane().add(ActionPanel, BorderLayout.EAST);
		ActionPanel.setLayout(new MigLayout("", "[][][]", "[][25:n][]"));
		
		
		ActionPanel.add(btnHit, "cell 1 1");
		ActionPanel.add(btnStay, "cell 1 2");
		
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		centerPanel.add(gameMessage);
		
		Dealer dealer = game.getDealer();
		for (int i = 0; i < dealer.getHand().cardCount(); i++) {
            String cardName = dealer.getHand().getCards().get(i).toString();
            
            if (i == 0) {
                DealerPanel.add(new CardPanel("back.png"));
            } else {
            	DealerPanel.add(new CardPanel(cardName));
            }
        }
		
		Player player = game.getUser();
		for (int i = 0; i < player.getHand().cardCount(); i++) {
            String cardName = player.getHand().getCards().get(i).toString();
      
            UserPanel.add(new CardPanel(cardName));
        }
		
		showGameMessage("Welcome " + ((User) player).getName()  + " currently have: " + player.getHand().totalHandValue());
		
		frame.setVisible(true);

	}
	
	public void showGameMessage(String message) {
        //Receives a String and sends it to the central label.
        this.gameMessage.setText(message);
        centerPanel.repaint();
    }
	
	void addHitListener(ActionListener StartListener) {
		btnHit.addActionListener(StartListener);
	}
	
	void addStayListener(ActionListener StayListener) {
		btnStay.addActionListener(StayListener);
	}


}
