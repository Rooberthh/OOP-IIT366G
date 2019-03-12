import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CardPanel extends JPanel{
	  private Image backgroundImage;

	  public CardPanel(String fileName) throws IOException {
		  System.out.println(getClass().getResource(fileName).toString());
		  backgroundImage = ImageIO.read(new File(getClass().getResource(fileName).getFile()));
		  
		  this.setPreferredSize(new Dimension(100,200));
	  }

	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.white);
	    g.fillRect(0, 0, 100, 150);
	  
	    g.drawImage(backgroundImage.getScaledInstance(100, -1, Image.SCALE_SMOOTH), 0, 0, this);
	  }
}
