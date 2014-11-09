package dk.cccontractors.www.swing.ta;

import java.awt.Color;
import java.awt.Graphics2D;

import dk.cccontractors.www.swing.YBorder;
import dk.cccontractors.www.swing.axis.YAxisBasis;
import dk.cccontractors.www.swing.dimension.ScreenConstants;
import dk.cccontractors.www.swing.dimension.ScreenControl;
import dk.cccontractors.www.swing.dimension.ScreenControlBean;
import dk.cccontractors.www.swing.plot.PlotType;
import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.Stock;
import dk.contractors.www.model.TimeSeries;

public class OCHL implements PlotType{//extends PlotType {

	private LoopBackData<? extends TimeSeries> loopBack;


	private ScreenControlBean screenControlBean;

	
	private YAxisBasis yaxis;
	
	public YAxisBasis getYaxis() {
		return yaxis;
	}

	public void setYaxis(YAxisBasis yaxis) {
		this.yaxis = yaxis;
	}
	
	public void drawYAxis()
	{
		yaxis.draw();
	}

	public OCHL(LoopBackData<? extends TimeSeries> loopBack, ScreenControl screenControl, YBorder yBorder) {
		super();
		this.loopBack = loopBack;

		//this.screenDivider = screenDivider;
		
		
		construct(screenControl, yBorder);
	    
	    //XAxisBasisAtTop xaxis = new XAxisBasisAtTop(g2D, yMin+20,(Stock)loopBack.get(screenControl.getIndex()), loopBack );

	    //plots.add(xaxis);
		
	}

	public void construct( ScreenControl screenControl, YBorder yBorder) {
		
		//yBorder = screenDivider.getyBorder(false);
		screenControl.setPrimaryScale(yBorder);
		
		yHeight = yBorder.getYheight();
		yMin = yBorder.getyMin();
		
		screenControlBean = screenControl.getScreenControlBean();
		scale = screenControlBean.getScale();
		
		offset = screenControlBean.getOffset();
//		screenControl.setCommonOffset(offset);
//		offset = screenControl.getCommonOffset();
		
		margin_xR = screenControlBean.getX_margin_right();
		
		double x = screenControlBean.getxMin();
		double max = screenControlBean.getMax();
		double min = screenControlBean.getMin();
		double xWidth = screenControlBean.getxWidth();
		double xMin = screenControlBean.getxMin();
		
		g2D = screenControl.getG2d();
		
	    yaxis = new YAxisBasis(g2D, x, max, min, yHeight , yMin,  xWidth, xMin , scale, offset);
	    //System.out.println("yMin "+yMin);
	    yaxis.draw();
	}
	
	public LoopBackData<? extends TimeSeries> getLoopBack() {
		return loopBack;
	}
	
	public void setScreenControlBean(ScreenControlBean screenControlBean)
	{
		this.screenControlBean = screenControlBean;
	}

	public void setLoopBack(LoopBackData<? extends TimeSeries> loopBack) {
		this.loopBack = loopBack;
	}

	private double scale;
	private double offset;
	private double margin_xR;
	private Graphics2D g2D;
	
	public double getyMin() {
		return yMin;
	}

	public void setyMin(double yMin) {
		this.yMin = yMin;
	}

	public double getyHeight() {
		return yHeight;
	}

	public void setyHeight(double yHeight) {
		this.yHeight = yHeight;
	}

	private double yMin;
	private double yHeight;
	
	private ScreenConstants scrConst;
	
	public ScreenConstants getScrConst() {
		return scrConst;
	}

	public void setScrConst(ScreenConstants scrConst) {
		this.scrConst = scrConst;
	}

	int xX;
	public void draw(int index)
	{
		
		Stock stock = (Stock)loopBack.get(index);
//		scale =  scrConst.getScale();
//		offset = scrConst.getOffset();
//		margin_xR = scrConst.getMargin();
		//g2D = scrConst.getG2D();
		
		double first_close=0;
		double second_close=0;
	    if(index>1)
	    {	
			first_close = loopBack.get(index-1).getClose();
		    second_close =  loopBack.get(index).getClose();
	    }
		xX=index*5;
		
		//drawVerticalBars(g2D, xX, stock.getOpen(), stock.getClose(), margin_xR,stock.getHigh(), stock.getLow());
		//drawCandleStick(g2D, xX,  margin_xR, stock);
		drawSimpleLine(g2D, xX, first_close, second_close);
	}	
	
	
	public void drawSimpleLine(Graphics2D g, int x, double first_close, double second_close)
	{

		int X_TICK =5;
	    g.drawLine((int)x-X_TICK, (int)(yHeight-((scale*first_close)-offset)), (int)x, (int)(yHeight-((scale*second_close)-offset)));	
		//Single test line ..
		g.drawLine((int)x, (int)yHeight, (int)x, (int)yHeight);
	}
	
	public void drawVerticalBars(Graphics2D g, double x, double open, double close, double x_marginal, double high, double low )
	{
		double y_open;
		double y_close;
		double y_high = high;
		double y_low = low;

		g.setColor(Color.BLACK);

		if(x < x_marginal)
		{
		    g.drawLine((int)x, (int)(yHeight-((scale*y_high)-offset)), (int)x, (int)(yHeight-((scale*y_low)-offset)));
		}
		// Horisontal open -> close
		y_open = open;
		y_close = close;
		if(y_open > 0 && x < x_marginal)
		{	
		    g.drawLine((int)x-1, (int)(yHeight-((scale*y_open)-offset)), (int)x, (int)(yHeight-((scale*y_open)-offset)));
	    }
		if(y_close > 0 && x < x_marginal)
		{
		    g.drawLine((int)x, (int)(yHeight-((scale*y_close)-offset)), (int)x+1, (int)(yHeight-((scale*y_close)-offset)));
		}
		//Single test line ..
		g.drawLine((int)x, (int)yHeight, (int)x, (int)yHeight);
	}
	
	public void drawCandleStick(Graphics2D g, double x, double x_marginal, Stock stock)
	{
			double high = stock.getHigh();			    
			double low = stock.getLow();
			double open = stock.getOpen();
			double close = stock.getClose();
			drawCandleStick(g, x, open, close, x_marginal, high, low);
	}

		public void drawCandleStick(Graphics2D g, double x, double open, double close, double x_marginal, double high, double low)
		{
			if(x<x_marginal)
			{
			   g.drawLine((int)x, (int)(yHeight-((scale*high)-offset)), (int)x, (int)(yHeight-((scale*low)-offset)));
			   
				//Single test line ..
				g.drawLine((int)x, (int)yHeight, (int)x, (int)yHeight);
			}
			 // Horisontal open -> close
			//if(y_close > y_open) {
			double y_tmp = (yHeight-((scale*open)-offset));
			double y_tmp2 = (yHeight-((scale*close)-offset));
			if(y_tmp2 > y_tmp) {
			    // Lower
			    y_tmp2 -= y_tmp;
			    if(open > 0 && x < x_marginal)
				g.fillRect((int)x-2, (int)y_tmp, 5, (int)y_tmp2);
			}
			else {
			    y_tmp -= y_tmp2;
			    // Higher
			    if(open > 0 && x < x_marginal) {
				g.setColor(new Color(255,255,255));
				g.fillRect((int)x-2, (int)y_tmp2, 4, (int)y_tmp);
				g.setColor(Color.black);
				g.drawRect((int)x-2, (int)y_tmp2, 4, (int)y_tmp);
			    }
			}
		}
}
