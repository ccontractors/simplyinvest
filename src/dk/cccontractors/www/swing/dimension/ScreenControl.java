package dk.cccontractors.www.swing.dimension;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.LinkedList;

import dk.cccontractors.www.swing.YBorder;
import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.TimeSeries;

public class ScreenControl {
	
	private double commonOffset;
	
	public double getCommonOffset() {
		return commonOffset;
	}


	public void setCommonOffset(double commonOffset) {
		this.commonOffset += commonOffset;
	}

	private LoopBackData<? extends TimeSeries> loopBackData;
	
	private Extrema extrema;
	private Extrema volExtrema;
	
	/**
	 * Value holds the current maximum value of the y-axis for stock values
	 * */
	protected double max;
	/**
	 * Value holds the current minimum value of the y-axis for stock values
	 * */
	protected double min;
	/**
	 * Value holds the current maximum value of the y-axis for volume values
	 * */
	protected double maxVol;
	/**
	 * Value holds the current minimum value of the y-axis for volume values
	 * */
	protected double minVol;

	
	
	public int getFirstIndex() {
		
		firstIndex = getStockArrayIndex((getRect()).x, X_TICK);
		return firstIndex;
	}


	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}


	public int getFirstX() {
		
		
		return firstX;
	}


	public void setFirstX(int firstX) {
		
		
		this.firstX = firstX;
	}

//	public int getStockArrayIndex(int xMin, int X_TICK)
//	{
//		int index = (xMin / X_TICK);
//		return index;
//	}
	private int firstIndex;
	
	private int firstX;
	
	public ScreenControl(LoopBackData<? extends TimeSeries> loopBackData) {
		super();
		this.loopBackData = loopBackData;
	}



	
	public ScreenControl() {
		super();
		// TODO Auto-generated constructor stub
	}


	private ScreenControlBean screenControlBean = new ScreenControlBean();
	
	public ScreenControlBean getScreenControlBean() {
		return screenControlBean;
	}


	public void setScreenControlBean(ScreenControlBean screenControlBean) {
		this.screenControlBean = screenControlBean;
	}


	private Graphics2D g2d;// = (Graphics2D) g1;
	
	public Graphics2D getG2d() {
		return g2d;
	}

	public void setG2d(Graphics2D g2d) {
		this.g2d = g2d;
	}

	public void setG2d(Graphics g1) {
		this.g2d = (Graphics2D) g1;
	}

	
	private Rectangle rect;
	
	public Rectangle getRect() {
		return rect;
	}
	public int getEmptySpace(int xMin, int xWidth, int RIGHT_MARGINAL)
	{
		int empty_space = xMin + xWidth - RIGHT_MARGINAL;
		return empty_space;
	}

	
	/**
	 * The number of tics per window is calculated as a function of width of the 
	 * complete set (i.e. not just the visible rectangle but the whole visible part of 
	 * the screen.)
	 * */
	private int windowTics;
	/**
	 * Calculates a "blank" margin at the right window. Calculated by adding xMin, xWidth and 
	 * and a preset constant (margin.getRight())
	 **/
	protected int x_margin_right;
	
	public int getX_margin_right() {
		return x_margin_right;
	}


	public void setX_margin_right(int x_margin_right) {
		this.x_margin_right = x_margin_right;
	}


	public void setRect(Rectangle rect) {
		this.rect = rect;
		screenControlBean.setxMin((getRect()).x);

		screenControlBean.setyMin((getRect()).y);
		screenControlBean.setxWidth((getRect()).width);
		windowTics = getNumberOfTics((getRect()).x,(getRect()).width, X_TICK);
		screenControlBean.setWindowTics(windowTics);
		index = getStockArrayIndex((getRect()).x, X_TICK);
		x_margin_right = getEmptySpace((getRect()).x, (getRect()).width, getRightMargin());
		screenControlBean.setX_margin_right(x_margin_right);

	}
	
	
	public void setPrimaryScale(YBorder yBorder)
	{
		extrema = new StockExtrema();
		extrema.calculateExtrema(index, windowTics, loopBackData);
		min = extrema.getMinimum();
		max = extrema.getMaximum();
		
		screenControlBean.setMin(min);
		screenControlBean.setMax(max);
		
	    Scale scaleObj = new Scale(yBorder.getYheight(), yBorder.getyMin());
	    screenControlBean.setScale(scaleObj.getScale(max, min));
	    screenControlBean.setOffset(scaleObj.getOffset(min));
		
	}
	
	public void setVolumeScale(YBorder yBorder)
	{
		volExtrema = new VolumeExtrema();
		volExtrema.calculateExtrema(index, windowTics, loopBackData);
		minVol = volExtrema.getMinimum();
		maxVol = volExtrema.getMaximum();
		
		screenControlBean.setMinVol(minVol);
		screenControlBean.setMaxVol(maxVol);
		
		Scale scaleVolObj = new Scale(yBorder.getYheight(), yBorder.getyMin());
		
		//Scale scaleVolObj = new Scale( yBorder.getyMin(), yBorder.getYheight());
		
		screenControlBean.setVolScale(scaleVolObj.getScale(maxVol, minVol));
		screenControlBean.setVolOffset(scaleVolObj.getOffset(minVol));
	}
	
	public void setMACDScale(YBorder yBorder, LinkedList<Double> loopBack)
	{
		ExtremaInTimeSeries extrema = new ExtremaInTimeSeries();
		extrema.calculateExtrema(index, windowTics, loopBack);
		double minMACD = extrema.getMin();
		double maxMACD = extrema.getMax();
//		System.out.println("minMACD"+minMACD);
//		System.out.println("maxMACD"+maxMACD);
//		
		
		screenControlBean.setMinMACD(minMACD);
		screenControlBean.setMaxMACD(maxMACD);
		
		
		Scale scaleMACD = new Scale(yBorder.getYheight(), yBorder.getyMin());
		
		screenControlBean.setMACDScale(scaleMACD.getScale(maxMACD, minMACD));
		screenControlBean.setMACDOffset(scaleMACD.getOffset(minMACD));

	}
	
	public void setMACDHistScale(YBorder yBorder, LinkedList<Double> loopBack){

		ExtremaInTimeSeries extrema = new ExtremaInTimeSeries();
		extrema.calculateExtrema(index, windowTics, loopBack);
		double minMACDHist = extrema.getMin();
		double maxMACDHist = extrema.getMax();
		
		screenControlBean.setMinMACDHist(minMACDHist);
		screenControlBean.setMaxMACDHist(maxMACDHist);
		
		
		Scale scaleMACDHist = new Scale(yBorder.getYheight(), yBorder.getyMin());
		
		screenControlBean.setMACDHistScale(scaleMACDHist.getScale(maxMACDHist,  minMACDHist));
		screenControlBean.setMACDHistOffset(scaleMACDHist.getOffset(maxMACDHist));		
		
	}
	
	public void setScale(String dataType)
	{
		ExtremaData extrema = new ExtremaData(loopBackData);
		extrema.findMinMaxSetValue(index, windowTics);
		
	}
	

	static final int  X_TICK = 5; 
	static final int RIGHT_MARGIN = 15; 
	static final int X_MARGIN = 40;
	
	Dimension prefScreenDim;
	public void setPrefScreenDim(Dimension prefScreenDim) {
		this.prefScreenDim = prefScreenDim;
	}

	public Dimension getPrefScreenDim() {
		if(yHeight>0)
		{
			prefScreenDim = new Dimension(prefScreenDim.width, (int) yHeight);
		}
		return prefScreenDim;
	}

	public Dimension updateScreenDim()
	{
		//return new Dimension( rect.x, getPlotWidth());
		return new Dimension( getPlotWidth(), (int ) yHeight + 200);
		
	}
	
	private double yHeight = 0;
	
	public double getPlotHeight(int i) {
		if(i == 1)
		{
			yHeight = plotHeight;
			return yHeight;
		}
		else
		{
			double recalculated = yHeight;
			recalculated /= 1.1;
			yHeight=yHeight+recalculated;
			return recalculated;
		}
		
		
	}

	public void setPlotHeight(int plotHeight) {
		this.plotHeight = plotHeight;
	}

	public int getPlotWidth() {
		return plotWidth;
	}

	public void setPlotWidth(int plotWidth) {
		this.plotWidth = plotWidth;
	}

	private int plotHeight;
	private int plotWidth;
	
	Dimension screenDim;
	
	Margin marginHolder;
	
	public int getTopMargin() {
		return marginHolder.getTop();
	}

	public int getBottomMargin() {
		return marginHolder.getBottom();
	}

	public int getLeftMargin() {
		return marginHolder.getLeft();
	}

	public int getRightMargin() {
		return rightMargin = marginHolder.getRight();
	}

	private int rightMargin;
	
	public void setScreenDimension(int sizeOfDataset_l) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); 
		plotHeight = (screen.height) / 2; 
	    plotWidth = getPlotWidth(sizeOfDataset_l);
	    prefScreenDim=new Dimension(plotWidth,plotHeight);;
	    marginHolder = new Margin(15, 30, 0, 110);
	}
	
	public int getPlotWidth(int sizeOfDataset_l){
		return ( (sizeOfDataset_l * X_TICK) + RIGHT_MARGIN + X_MARGIN);
	}
	
	public void initScreenControlBean()
	{
	}
	
	public int getNumberOfTics(int x_win_start, int x_win_width, int X_SPACE)
	{
		int size = (x_win_start + x_win_width) / X_SPACE;
		return size;
	}
	
	private int index;
	public int getIndex() {

		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getStockArrayIndex(int xMin, int X_TICK)
	{
		int index = (xMin / X_TICK);
		return index;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScreenControl screenControl = new ScreenControl();
		screenControl.setScreenDimension(1000);
	}
}
