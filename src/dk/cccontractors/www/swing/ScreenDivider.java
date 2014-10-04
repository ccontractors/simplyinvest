package dk.cccontractors.www.swing;

public class ScreenDivider {

	double yHeightInit;
	double yHeight;
	public ScreenDivider(double yHeightInit) {
		super();
		this.yHeightInit = yHeightInit;
		yHeight = yHeightInit;
	}


	YBorder yBorder = new YBorder();
	
	
	public YBorder getyBorder(boolean divide) {
		
		yBorder.setYheight(yHeight);
		
		if(divide)
		{
			yHeight /= 1.2; 
			yBorder.setyMin(yHeight);
		}
		return yBorder;
	}


	public void setyBorder(YBorder yBorder) {
		this.yBorder = yBorder;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
