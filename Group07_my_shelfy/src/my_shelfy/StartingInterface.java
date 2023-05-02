																																			package my_shelfy;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartingInterface extends JFrame {
 
	final int WIDTH = 750;
	final int HEIGHT = 750;
	
	public StartingInterface() {
		super("MY SHELFIE");
		init();
	}
	
	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel sfondo = new JLabel(new ImageIcon("Resources/Images/coverImage.jpg"));
		this.add(sfondo);
		this.setResizable(false);
		this.setVisible(true);
		}
}
