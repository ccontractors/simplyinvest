package dk.cccontractors.www.swing.axis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Calendar;

import dk.cccontractors.www.swing.ScreenDivider;
import dk.cccontractors.www.swing.YBorder;
import dk.cccontractors.www.swing.dimension.ScreenControl;
import dk.cccontractors.www.swing.dimension.ScreenControlBean;
import dk.cccontractors.www.swing.plot.PlotType;
import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.Stock;
import dk.contractors.www.model.TimeSeries;



public class XAxisBasisAtTop implements PlotType//extends PlotType
{
	LoopBackData<? extends TimeSeries> loopBackData;
	
	public Color FORGROUND = Color.black;
	public Color DATE = Color.gray;

	Graphics2D g;
	double x; 
	double y_date_min; 
	int month;
	
	Calendar cal;
	
	
	private ScreenControl screenControl;
	private ScreenDivider screenDivider;
	private ScreenControlBean screenControlBean;
	private YBorder yBorder;
	
	public XAxisBasisAtTop(ScreenControl screenControl, YBorder yBorder, int index,LoopBackData<? extends TimeSeries> loopBackData) {
		super();
		this.screenControl = screenControl;
		//this.screenDivider = screenDivider;
		this.g = screenControl.getG2d();
		
		//yBorder = screenDivider.getyBorder(false);
		Stock stock = loopBackData.get(index);
		Calendar cal = stock.getDate();
		this.y_date_min = yBorder.getyMin()+20;
		this.month = cal.get(Calendar.MONTH);
		this.loopBackData = loopBackData;
	}

	public void draw(int index)
	{
		int x=index*5;
		g.setColor(Color.red);
		Stock stock = (Stock)loopBackData.get(index);
		this.cal=stock.getDate();
		//this.cal=cal;
		
		if(cal.get(Calendar.MONTH) != month)
		{
		    month = cal.get(Calendar.MONTH);
		    g.drawLine((int)x, (int)(y_date_min), (int)x, (int)(y_date_min)-8);
		    //g.setColor(Color.LIGHT_GRAY);
		    //g.drawLine((int)x, (int)(y_date_min), (int)x, (int) y_win_max);//grid
		    g.setFont(new Font("SansSerif", Font.PLAIN, 9));
		    g.setColor(DATE);		    				    
		    String text_date = "";				    

		    if(month != 0)
		    {
				text_date = getTextMonth(month);
				g.drawString(text_date, (int)x+45, (int)y_date_min-5);
		    }
			else
			{										
				text_date = Integer.toString(cal.get(Calendar.YEAR)) + " " + getTextMonth(month);
				g.drawString(text_date, (int)x+40, (int)y_date_min-8);
			}

		    g.setColor(FORGROUND);		    
		    month = cal.get(Calendar.MONTH);			       				    
		 }
		 else 
		 {
		    g.drawLine((int)x, (int)(y_date_min), (int)x, (int)(y_date_min)-2);
		    //g.setColor(Color.LIGHT_GRAY);
		    //g.drawLine((int)x, (int)(y_date_min), (int)x, (int)y_win_max);//grid
		    g.setColor(FORGROUND);
		 }
    }		
		
	public String getTextMonth(int month) {
    	String text_date = "";
    	if(month == 0)
    	    text_date = "Jan";
    	else if(month == 1)
    	    text_date = "Feb";
    	else if(month == 2)
    	    text_date = "Mar";
    	else if(month == 3)
    	    text_date = "Apr";
    	else if(month == 4)
    	    text_date = "May";
    	else if(month == 5)
    	    text_date = "Jun";
    	else if(month == 6)
    	    text_date = "Jul";
    	else if(month == 7)
    	    text_date = "Aug";
    	else if(month == 8)
    	    text_date = "Sep";
    	else if(month == 9)
    	    text_date = "Oct";
    	else if(month == 10)
    	    text_date = "Nov";
    	else if(month == 11)
    	    text_date = "Dec";
    	return text_date; 
        }	
}
