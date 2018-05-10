package tictactoegame.shubham.com;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import java.awt.Color;

@SuppressWarnings("serial")
public class Play extends JFrame implements MouseListener
{	
	public static Plate plate = new Plate();
	public static Block clicked = null;
	public static CircleCross circleCross = null;
	public Random rand = new Random();
	
	public static int crossJ = 0, circleJ = 0, pattern[][] = new int[2][8];
	public int N, row, col;
	public String mode = "circle";
	public static String pMode = "withComuter";
//	public static String pMode = "withFriend";
	public static boolean chance = true;
	public static int win;
		
	public Play()
	{
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 8; j++)
				pattern[i][j] = 0;
		getContentPane().add(plate);
		plate.initializePlate();
		selectActiveBlock();
	}
	
	void selectActiveBlock()
	{
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				plate.block[i][j].addMouseListener(this);
	}
	
	void updatePattern(int i, int I, int J)
	{
		if(J == 0)
		{
			pattern[i][0]++;
		}
		if(J == 1)
		{
			pattern[i][1]++;
		}
		if(J == 2)
		{
			pattern[i][2]++;
		}
		if(I == 0)
		{
			pattern[i][3]++;
		}
		if(I == 1)
		{
			pattern[i][4]++;
		}
		if(I == 2)
		{
			pattern[i][5]++;
		}
		if(I == J)
		{
			pattern[i][6]++;
		}
		if((I + J) == 2)
		{
			pattern[i][7]++;
		}
	}
	
	boolean checkWinner(int i)
	{
		for(int j = 0; j < 8; j++)
		{
			if(pattern[i][j] == 3)
			{
				win = j;
				for(int m = 0; m < 3; m++)
					for(int n = 0; n < 3; n++)
						plate.block[m][n].removeMouseListener(this);
				return true;
			}
		}
		return false;
	}
	
	void showWinner(int pattern)
	{
		switch(pattern)
		{
		//horizontal
		case 0:
			plate.block[0][0].setBackground(Color.BLACK);
			plate.block[1][0].setBackground(Color.BLACK);
			plate.block[2][0].setBackground(Color.BLACK);
			break;
		case 1:
			plate.block[0][1].setBackground(Color.BLACK);
			plate.block[1][1].setBackground(Color.BLACK);
			plate.block[2][1].setBackground(Color.BLACK);
			break;
		case 2:
			plate.block[0][2].setBackground(Color.BLACK);
			plate.block[1][2].setBackground(Color.BLACK);
			plate.block[2][2].setBackground(Color.BLACK);
			break;
		//vertical	
		case 3:
			plate.block[0][0].setBackground(Color.BLACK);
			plate.block[0][1].setBackground(Color.BLACK);
			plate.block[0][2].setBackground(Color.BLACK);
			break;
		case 4:
			plate.block[1][0].setBackground(Color.BLACK);
			plate.block[1][1].setBackground(Color.BLACK);
			plate.block[1][2].setBackground(Color.BLACK);
			break;
		case 5:
			plate.block[2][0].setBackground(Color.BLACK);
			plate.block[2][1].setBackground(Color.BLACK);
			plate.block[2][2].setBackground(Color.BLACK);
			break;
		//diagonal	
		case 6:
			plate.block[0][0].setBackground(Color.BLACK);
			plate.block[1][1].setBackground(Color.BLACK);
			plate.block[2][2].setBackground(Color.BLACK);
			break;
		case 7:
			plate.block[2][0].setBackground(Color.BLACK);
			plate.block[1][1].setBackground(Color.BLACK);
			plate.block[0][2].setBackground(Color.BLACK);
			break;

		}
	}
	
	void comPlay()
	{
		int i = -1, j = -1, max = 2, x = 0, count = 0;
		int index[] = new int[8];
		for(int l = 0; l < 8 ; l++)
		{
			if(pattern[1][l] == max)
			{
				index[x] = l;
				x++;
			}
		}
		for(int l = 0 ; l < x ; l++)
		{
			count = 0;
			switch(index[l])
			{
				case 0 :
					j = 0;
					break;
				case 1 :
					j = 1;
					break;
				case 2 :
					j = 2;
					break;
				case 3 :
					i = 0;
					break;
				case 4 :
					i = 1;
					break;
				case 5 :
					i = 2;
					break;
				case 6 :
					do
					{
						count++;
						if(i < 2)
						{
							i++;
						    j++;
						}    
					}while(plate.block[i][j].getStatus() == false && count < 4);
					break;
				case 7 :
					i = -1;
					j = 3;
					do
					{
						count++;
						if(i < 2)
						{
							i++;
							j--;
						}
					}while(plate.block[i][j].getStatus() == false && count < 4);	
					break;
				default :
					i = -1;
					j = -1;
					break;
			}
			count = 0;
			if(i == -1 && j != -1)
			{
				do
				{
					count++;
					if(i < 2)
						i++;
				}while(plate.block[i][j].getStatus() == false && count < 4);
			}
			if(i != -1 && j == -1)
			{
				do
				{
					count++;
					if(j < 2)
						j++;
				}while(plate.block[i][j].getStatus() == false && count < 4);
			}
			if(plate.block[i][j].getStatus() == true)
				break;
			else
			{
				i = -1;
				j = -1;
			}
		}
		/******************************************************************************/
		if(i == -1 && j == -1)
		{
			for(int l = 0; l < 8 ; l++)
			{
				if(pattern[0][l] == max)
				{
					index[x] = l;
					x++;
				}
			}
			for(int l = 0 ; l < x ; l++)
			{
				count = 0;
				switch(index[l])
				{
					case 0 :
						j = 0;
						break;
					case 1 :
						j = 1;
						break;
					case 2 :
						j = 2;
						break;
					case 3 :
						i = 0;
						break;
					case 4 :
						i = 1;
						break;
					case 5 :
						i = 2;
						break;
					case 6 :
						do
						{
							count++;
							if(i < 2)
							{
								i++;
							    j++;
							}    
						}while(plate.block[i][j].getStatus() == false && count < 4);
						break;
					case 7 :
						i = -1;
						j = 3;
						do
						{
							count++;
							if(i < 2)
							{
								i++;
								j--;
							}
						}while(plate.block[i][j].getStatus() == false && count < 4);	
						break;
					default :
						i = -1;
						j = -1;
						break;
				}
				count = 0;
				if(i == -1 && j != -1)
				{
					do
					{
						count++;
						if(i < 2)
							i++;
					}while(plate.block[i][j].getStatus() == false && count < 4);
				}
				if(i != -1 && j == -1)
				{
					do
					{
						count++;
						if(j < 2)
							j++;
					}while(plate.block[i][j].getStatus() == false && count < 4);
				}
				if(plate.block[i][j].getStatus() == true)
					break;
				else
				{
					i = -1;
					j = -1;
				}
			}
		}
		if(i == -1 && j == -1)
		{
			do
			{
				i = rand.nextInt(3);
				j = rand.nextInt(3);
			}while(plate.block[i][j].getStatus() == false);	
		}
		row = i;
		col = j;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent event)
	{
		clicked = (Block) event.getSource();
		if(pMode == "withFriend")
		{
			if(clicked.getStatus() == true)
			{
				if(chance == true)
				{
					System.out.println("Cross");
					circleCross = plate.circleCross[0][crossJ];
					crossJ++;
				}
				else
				{
					System.out.println("Circle");
					circleCross = plate.circleCross[1][circleJ];
					circleJ++;
				}
				System.out.println("Valid");
				System.out.println(circleCross.playerNo);
				chance = ! chance;
				row = clicked.getRow();
				col = clicked.getCol();
				plate.block[row][col].setCircleCross(circleCross);
				plate.block[row][col].add(circleCross);
				plate.block[row][col].setCircleCross(circleCross);
				plate.block[row][col].setStatus(false);
				if(chance == true)
				{
					updatePattern(0, row, col);
					if(checkWinner(0) == true)
					{
						System.out.println("Cross Wins!!!");
						showWinner(win);
					}
				}
				else
				{
					updatePattern(1, row, col);
					if(checkWinner(1) == true)
					{
						System.out.println("Circle Wins!!!");
						showWinner(win);
					}
				}
				clicked.revalidate();
				plate.repaint();
			}
			else
			{
				System.out.println("Invalid");
			}
			System.out.println("Clicked: (" + row + ", " + col + ")\n");
		}
		else
		{
			if(clicked.getStatus() == true)
			{
				System.out.println("Cross");
				circleCross = plate.circleCross[0][crossJ];
				crossJ++;
				row = clicked.getRow();
				col = clicked.getCol();
				plate.block[row][col].setCircleCross(circleCross);
				plate.block[row][col].add(circleCross);
				plate.block[row][col].setCircleCross(circleCross);
				plate.block[row][col].setStatus(false);
				System.out.println("You: (" + row + ", " + col + ")\n");
				clicked.revalidate();
				plate.repaint();
				updatePattern(0, row, col);
				if(checkWinner(0) == true)
				{
					System.out.println("You Win!!!");
					showWinner(win);
				}
				else
				{
					int a = 0;
					for(int m = 0; m < 3; m++)
						for(int n = 0; n < 3; n++)
							if(plate.block[m][n].getStatus() == true)
								a = 1;
					if(a == 0)
					{
						System.out.println("-----Draw-----");
						for(int m = 0; m < 3; m++)
							for(int n = 0; n < 3; n++)
								plate.block[m][n].removeMouseListener(this);
					}
					else
					{
						System.out.println("Circle");
						circleCross = plate.circleCross[1][circleJ];
						circleJ++;
						comPlay();
						plate.block[row][col].setCircleCross(circleCross);
						plate.block[row][col].add(circleCross);
						plate.block[row][col].setCircleCross(circleCross);
						plate.block[row][col].setStatus(false);
						System.out.println("Computer: (" + row + ", " + col + ")\n");
						plate.repaint();
						updatePattern(1, row, col);
						if(checkWinner(1) == true)
						{
							System.out.println("Computer Wins!!!");
							showWinner(win);
						}
					}
				}
			}
			else
			{
				System.out.println("Invalid");
			}
		}	
	}
	
	public static void main(String args[])
	{
		JFrame frame = new Play();
		frame.setVisible(true);
		frame.setSize(450, 450);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Tic Tac Toe");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}	