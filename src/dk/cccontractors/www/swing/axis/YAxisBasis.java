package dk.cccontractors.www.swing.axis;

import java.awt.Color;
import java.awt.Graphics2D;

public class YAxisBasis
{
	Graphics2D g;
	double x; 
	double maxHigh;
	double minLow;
	
	double y_win_max;
	double y_win_min;
	double x_win_width;
	double x_win_start;
	double scale;
	double val;
	
	public YAxisBasis(Graphics2D g, double x, double maxHigh, double minLow, double y_win_max ,double y_win_min,double x_win_width, double x_win_start , double scale, double val)
	{
		super();
		this.g = g;
		this.x = x;
		this.maxHigh = maxHigh;
		this.minLow = minLow;
		this.y_win_max = y_win_max;
		this.y_win_min = y_win_min;
		this.x_win_start= x_win_start;
		this.x_win_width = x_win_width;
		this.scale = scale;
		this.val = val;
	}
	
	public void draw()
	{
		
		g.setColor(Color.RED);
		// Draw the stock values on the right.
		double units = ( (y_win_max-(y_win_min+10)) / 20); // Twenty pixels between each value
		
		double increment = (((maxHigh )- minLow) / units);			
		x = x_win_width + x_win_start;
		
		// Calculations for getting an even numbers scale	    
		g.drawLine( (int)x-1, (int)y_win_min-10 ,(int)x-1 , (int) y_win_max+10);
		String text;
		java.text.NumberFormat nf1 = new java.text.DecimalFormat();
		nf1.setMaximumFractionDigits(1);
			while(minLow < (maxHigh) )
			{
			    g.drawLine((int)x-3, (int)(y_win_max-((scale*minLow)-val)), (int)x, (int)(y_win_max-((scale*minLow)-val)));
			    if(/*(Math.exp(minLow) > 100 ) || */(minLow > 100 ))
			    {	
					    text = Integer.toString((int)Math.round(minLow));
			    }
			    else
			    {
					    text = nf1.format(minLow);
			    }
			    g.drawString(text, (int)x-30, (int)(y_win_max-((scale*minLow)-val)));
			    minLow += increment;
			}
	}
}
