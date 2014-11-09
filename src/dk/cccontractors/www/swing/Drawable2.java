package dk.cccontractors.www.swing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import dk.cccontractors.www.swing.axis.XAxisBasisAtTop;
import dk.cccontractors.www.swing.dimension.ScreenControl;

import dk.cccontractors.www.swing.plot.PlotType;
import dk.cccontractors.www.swing.ta.OCHL;
import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.Stock;
import dk.contractors.www.model.TimeSeries;

public class Drawable2 
{
	protected static final int X_TICK =5;
	protected Graphics2D g2D;

	protected LoopBackData<? extends TimeSeries> loopBackData;
	/**
	 * Index is the calculated as a function of the relative position of the x-coordinate of
	 * the screen, and the width of the tick ( the distance between each x-coordinate).
	 * */
	protected int index;
	/**
	 * Calculates a "blank" margin at the right window. Calculated by adding xMin, xWidth and 
	 * and a preset constant (margin.getRight())
	 **/
	protected int x_margin_right;
	/**
	 * 
	 * */	
	protected int xMin;
	/**
	 * 
	 * */
	protected int yMin; //Must be fixed for subtype component
	protected double yVolMin;
	/**
	 * 
	 * */
	protected int xWidth;
	/**
	 * Scalefactor - the value that subsequent models following the main model will scaled with
	 * */
	//protected double scaleFactor = 1.2;
	/**
	 * Scale is the calculated relative factor between the minimum and maximum of the screen
	 * and the minimum and maximum of the current stock value.
	 * */
	protected double scale;
	protected double volScale;
	/**
	 *  Offset adjusts the y-values to the level of the y-axis
	 * */
	protected double offset;
	protected double volOffset;
	/**
	 * Value holds the current maximum value of the y-axis for stock values
	 * */
	//protected double max;
	/**
	 * Value holds the current minimum value of the y-axis for stock values
	 * */
	//protected double min;
	/**
	 * Value holds the current maximum value of the y-axis for volume values
	 * */
	protected double maxVol;
	/**
	 * Value holds the current minimum value of the y-axis for volume values
	 * */
	protected double minVol;
	
	private ScreenControl sc;
	private GraphicsCommand graphicsCommand;
	ArrayList<Model> models;
	public Drawable2(LoopBackData<? extends TimeSeries> loopBackData, ScreenControl screenControl, ArrayList<Model> models)
	{
		super();
		this.loopBackData = loopBackData;
		sc = screenControl;
		graphicsCommand = new GraphicsCommand(sc.getG2d());
		this.models = models;
		
	}

	private int getStockArrayIndex(int xMin, int X_TICK)
	{
		int index = (xMin / X_TICK);
		return index;
	}
	
	ScreenDivider screenDivider;
	public void draw()
	{
		ArrayList<PlotType> plots = new ArrayList<PlotType>();
		graphicsCommand.setG2D(sc.getG2d());
		graphicsCommand.reset();
		//screenDivider = new ScreenDivider( sc.getPlotHeight(1) );

		index = getStockArrayIndex(xMin, X_TICK);

		YBorder yBorder = new YBorder();
		for(Model _model : models)
		{
			if(_model.getModelName().equals("OHCL") )
			{

				yBorder.setYheight(_model.getYheigt());
			    yBorder.setyMin(_model.getyMin());
				OCHL ochl = new OCHL(loopBackData, sc, yBorder);
			    plots.add(ochl);
				XAxisBasisAtTop xaxis = new XAxisBasisAtTop(sc, yBorder, index, loopBackData);
				plots.add(xaxis);
				
			}
//			else if(_model.getModelName().equals("Volume"))
//			{
//			    yBorder.setYheight(_model.getYheigt());
//			    yBorder.setyMin(_model.getyMin());
//				Volume volume = new Volume(loopBackData, sc, yBorder);
//			    plots.add(volume);
//			}
//			else if(_model.getModelName().equals("RSI"))
//			{
//				Rsi rsi = new Rsi(loopBackData, 10);
//			    yBorder.setYheight(_model.getYheigt());
//			    yBorder.setyMin(_model.getyMin());				
//				BasicRSI basicRSI = new BasicRSI(sc, yBorder);
//				basicRSI.setRsi(rsi);
//				plots.add(basicRSI);
//			}
//			else if(_model.getModelName().equals("MACD"))
//			{
//			    yBorder.setYheight(_model.getYheigt());
//			    yBorder.setyMin(_model.getyMin());
//			    MACD2Study macdStudy = new MACD2Study();
//			    macdStudy.createMACDLines(loopBackData);
//			    macdStudy.createMCADHistogram(loopBackData);
//			    BasicMACD macd = new BasicMACD(sc, yBorder, macdStudy); 
//			    plots.add(macd);
//			}
			/*
			else if(_model.getModelName().equals("ForceIndex"))
			{
			    yBorder.setYheight(_model.getYheigt());
			    yBorder.setyMin(_model.getyMin());
			    
			    ForceIndex forceIndex = new ForceIndex();
			    plots.add(forceIndex);
			}*/
		}

		while(index < loopBackData.size())
		{
	    	for(PlotType _plot : plots)
			{
				_plot.draw(index);
			}
		    index++;
		}	    
	}

	//Plottypes...
	public void drawStables(Graphics2D g, double x, double x_marginal, Stock stock, double scale , double offet, double yHeight)
	{
		drawVerticalStables(g, x, stock.getOpen(), stock.getClose(), x_marginal, stock.getHigh(), stock.getLow(), scale, offset, yHeight);
	}

	public void drawVerticalStables(Graphics2D g, double x, double open, double close, double x_marginal, double high, double low, double scale , double val, double y_win_max )
	{
		double y_open;
		double y_close;
		double y_high = high;
		double y_low = low;	

		if( x < x_marginal)
		{	
		    	g.setColor(new Color(0,0,255));  
		    	g.fillRect((int)x-2, (int)(y_win_max-((scale*y_high)-val)), 3, (int)(y_win_max-((scale*y_low)-val) - (int)(y_win_max-((scale*y_high)-val))));
		    	g.setColor(Color.black);
		}

	    if(open > 0 && x < x_marginal)
		{	
			    g.fillRect((int)x-3, (int)(y_win_max-((scale*open)-val)), 1, 2);
			    
		}

	    if(close > 0 && x < x_marginal)
		{
		    g.fillRect((int)x+1, (int)(y_win_max-((scale*close)-val)), 1, 2);
		}
	}
}
