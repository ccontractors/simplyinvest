package dk.cccontractors.www.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class GraphicsCommand {

	
	private Graphics2D g2D;
	
	public Graphics2D getG2D() {
		return g2D;
	}

	public void setG2D(Graphics2D g2d) {
		g2D = g2d;
	}

	public GraphicsCommand(Graphics2D g2d) {
		super();
		g2D = g2d;
	}
	
	public void reset()
	{
		Color FORGROUND = Color.black;
		g2D.setColor(FORGROUND);		    
	    g2D.setFont(new Font("SansSerif", Font.PLAIN, 9));
	}
	
	public void setFont(String font, int fontLayout, int fontSize)
	{
		g2D.setFont(new Font(font, fontLayout, fontSize));
		
	}
	
	public void setColor(Color color)
	{
		g2D.setColor(color);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
