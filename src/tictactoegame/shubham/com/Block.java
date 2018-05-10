package tictactoegame.shubham.com;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Block extends JPanel
{
	private boolean status = true;
	private CircleCross circleCross;
	private int row;
	private int col;
	
	public Block(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public boolean getStatus()
	{
		return this.status;
	}
	
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	
	public CircleCross getCircleCross()
	{
		return this.circleCross;
	}
	
	public void setCircleCross(CircleCross circleCross)
	{
		this.circleCross = circleCross;
	}

	public void setPosition(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public int getRow()
	{
		return this.row;
	}

	public int getCol()
	{
		return this.col;
	}
}
