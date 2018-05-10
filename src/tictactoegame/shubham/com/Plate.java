package tictactoegame.shubham.com;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Plate extends JPanel
{
	public Block block[][] = new Block[3][3];
	public CircleCross circleCross[][] = new CircleCross[2][5];

	public Plate() 
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				this.block[i][j] = new Block(i, j);
				this.block[i][j].setBackground(Color.white);
			}
		}	
		setLayout(new GridLayout(3, 3, 15, 15));
		for (int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				block[i][j].setPosition(i, j);
				add(block[i][j]);
			}
		}
		for (int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(i == 0)
					circleCross[i][j] = new CircleCross(true);
				else
					circleCross[i][j] = new CircleCross(false);
			}
		}
	}
	
	public void initializePlate()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				this.block[i][j].setStatus(true);
			}
		}
	}	
}