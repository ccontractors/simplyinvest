package dk.cccontractors.www.swing.dimension;

public class ScreenControlBean {

//	public int getIndex() {
//		return index;
//	}
//	public void setIndex(int index) {
//		this.index = index;
//	}
	public int getIndex_begin() {
		return index_begin;
	}
	public void setIndex_begin(int index_begin) {
		this.index_begin = index_begin;
	}
	public int getWindowTics() {
		return windowTics;
	}
	public void setWindowTics(int windowTics) {
		this.windowTics = windowTics;
	}
	public int getX_margin_right() {
		return x_margin_right;
	}
	public void setX_margin_right(int x_margin_right) {
		this.x_margin_right = x_margin_right;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getX_begin() {
		return x_begin;
	}
	public void setX_begin(int x_begin) {
		this.x_begin = x_begin;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getxMin() {
		return xMin;
	}
	public void setxMin(int xMin) {
		this.xMin = xMin;
	}
	public int getyMin() {
		return yMin;
	}
	public void setyMin(int yMin) {
		this.yMin = yMin;
	}
	public double getyVolMin() {
		return yVolMin;
	}
	public void setyVolMin(double yVolMin) {
		this.yVolMin = yVolMin;
	}
	public int getxWidth() {
		return xWidth;
	}
	public void setxWidth(int xWidth) {
		this.xWidth = xWidth;
	}
	public double getyHeight() {
		return yHeight;
	}
	public void setyHeight(double yHeight) {
		this.yHeight = yHeight;
	}
	public double getyVolHeight() {
		return yVolHeight;
	}
	public void setyVolHeight(double yVolHeight) {
		this.yVolHeight = yVolHeight;
	}
	public int getyDelta() {
		return yDelta;
	}
	public void setyDelta(int yDelta) {
		this.yDelta = yDelta;
	}
	public double getScaleFactor() {
		return scaleFactor;
	}
	public void setScaleFactor(double scaleFactor) {
		this.scaleFactor = scaleFactor;
	}
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
	}
	public double getVolScale() {
		return volScale;
	}
	public void setVolScale(double volScale) {
		this.volScale = volScale;
	}
	public double getOffset() {
		return offset;
	}
	public void setOffset(double offset) {
		this.offset = offset;
	}
	public double getVolOffset() {
		return volOffset;
	}
	public void setVolOffset(double volOffset) {
		this.volOffset = volOffset;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMaxVol() {
		return maxVol;
	}
	public void setMaxVol(double maxVol) {
		this.maxVol = maxVol;
	}
	public double getMinVol() {
		return minVol;
	}
	public void setMinVol(double minVol) {
		this.minVol = minVol;
	}
	//private int index;
	/**
	 * begin_index is the initial value of index that is copied to draw methods
	 * */
	private int index_begin;
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
	private int x_margin_right;
	/**
	 * 
	 * */
	private int x;
	/**
	 * 
	 * */
	private int x_begin; 
	/**
	 * 
	 * */
	private int size;
	/**
	 * 
	 * */	
	private int xMin;
	/**
	 * 
	 * */
	private int yMin; //Must be fixed for subtype component
	private double yVolMin;
	/**
	 * 
	 * */
	private int xWidth;
	/**
	 * 
	 * */
	private double yHeight; //Must be fixed for subtype component
	private double yVolHeight; //Must be fixed for subtype component
	/**
	 * 
	 * */
	private int yDelta;
	
	/**
	 * Scalefactor - the value that subsequent models following the main model will scaled with
	 * */
	private double scaleFactor = 1.2;
	/**
	 * Scale is the calculated relative factor between the minimum and maximum of the screen
	 * and the minimum and maximum of the current stock value.
	 * */
	private double scale;
	private double volScale;
	/**
	 *  Offset adjusts the y-values to the level of the y-axis
	 * */
	private double offset;
	private double volOffset;
	/**
	 * Value holds the current maximum value of the y-axis for stock values
	 * */
	private double max;
	/**
	 * Value holds the current minimum value of the y-axis for stock values
	 * */
	private double min;
	/**
	 * Value holds the current maximum value of the y-axis for volume values
	 * */
	private double maxVol;
	/**
	 * Value holds the current minimum value of the y-axis for volume values
	 * */
	private double minVol;
	
	
	public double getMinMACD() {
		return minMACD;
	}
	public void setMinMACD(double minMACD) {
		this.minMACD = minMACD;
	}
	public double getMaxMACD() {
		return maxMACD;
	}
	public void setMaxMACD(double maxMACD) {
		this.maxMACD = maxMACD;
	}
	private double minMACD;
	private double maxMACD;
	
	public double getMACDScale() {
		return MACDScale;
	}
	public void setMACDScale(double mACDScale) {
		MACDScale = mACDScale;
	}
	public double getMACDOffset() {
		return MACDOffset;
	}
	public void setMACDOffset(double mACDOffset) {
		MACDOffset = mACDOffset;
	}
	private double MACDScale;
	private double MACDOffset;
	
	public double getMinMACDHist() {
		return minMACDHist;
	}
	public void setMinMACDHist(double minMACDHist) {
		this.minMACDHist = minMACDHist;
	}
	public double getMaxMACDHist() {
		return maxMACDHist;
	}
	public void setMaxMACDHist(double maxMACDHist) {
		this.maxMACDHist = maxMACDHist;
	}
	private double minMACDHist;
	private double maxMACDHist;
	public double getMACDHistScale() {
		return MACDHistScale;
	}
	public void setMACDHistScale(double mACDHistScale) {
		MACDHistScale = mACDHistScale;
	}
	public double getMACDHistOffset() {
		return MACDHistOffset;
	}
	public void setMACDHistOffset(double mACDHistOffset) {
		MACDHistOffset = mACDHistOffset;
	}
	private double MACDHistScale;
	private double MACDHistOffset;
	
	
	
}
