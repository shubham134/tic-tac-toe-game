package tictactoegame.shubham.com;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CircleCross extends JLabel
{
	public ImageIcon imageIcon;
	public int playerNo;
	
	public CircleCross(boolean n)
	{
		if(n == true)
		{
			this.playerNo = 1;
			imageIcon = new ImageIcon("tic-tac-toe-game-master/images/cross.png");
			setIcon(imageIcon);
		}
		else if(n == false)
		{
			this.playerNo = 2;
			imageIcon = new ImageIcon("tic-tac-toe-game-master/images/circle.png");
			setIcon(imageIcon);
		}
	}
}